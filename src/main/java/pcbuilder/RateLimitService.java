package pcbuilder;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RateLimitService {
    private Map<String,RequestEntry> cache = new HashMap<>();
    private Calendar calendar = Calendar.getInstance();

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

    public boolean exceedsLimit(String userKey) {
        RequestEntry requestEntry;
        if (cache.containsKey(userKey)) {
            requestEntry = cache.get(userKey);
        } else {
            requestEntry = new RequestEntry();
            cache.put(userKey,requestEntry);
        }

        if (requestEntry.count > 100) {
            return true;
        }

        requestEntry.count++;
        requestEntry.time = calendar.getTimeInMillis();

        return false;
    }


    private class RequestEntry {
        public int count;
        public long time;
    }
}