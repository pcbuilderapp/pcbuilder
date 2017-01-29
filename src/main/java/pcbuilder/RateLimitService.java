package pcbuilder;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Rate limit service keeps track of requests per IP.
 * Request count is reset after 10 minutes have past since the last request.
 */

@Service
public class RateLimitService {
    private Map<String,RequestEntry> cache = new HashMap<>();
    private Calendar calendar = Calendar.getInstance();

    /**
     * Cronjob for pruning the request count cache.
     */

    @Scheduled(cron = "0 * * * * *")
    public void updateExpireTimeForCache() {
        long curTime = calendar.getTimeInMillis();
        List<String> rmList = new LinkedList<>();
        for (Map.Entry<String,RequestEntry> entry : cache.entrySet()) {
            if (curTime - entry.getValue().time < 600000) // 10 minutes
                continue;

            rmList.add(entry.getKey());
        }
        for (String key : rmList) {
            cache.remove(key);
        }
    }

    /**
     * Check if the requester has exceeded his limit.
     *
     * @param userKey The IP or unique identifier of the requester.
     * @return True if limit has been exceeded, false otherwise.
     */

    public boolean exceedsLimit(String userKey) {
        RequestEntry requestEntry;
        if (cache.containsKey(userKey)) {
            requestEntry = cache.get(userKey);
        } else {
            requestEntry = new RequestEntry();
            cache.put(userKey,requestEntry);
        }

        if (requestEntry.count > 6000) {
            return true;
        }

        requestEntry.count++;
        requestEntry.time = calendar.getTimeInMillis();

        return false;
    }

    /**
     * Request entry structure.
     */

    private class RequestEntry {
        private int count;
        private long time;
    }
}