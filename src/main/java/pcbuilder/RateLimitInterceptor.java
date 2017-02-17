package pcbuilder;

import javassist.bytecode.stackmap.TypeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Intercept all HTTP requests to enable rate limiting.
 */

@Service
public class RateLimitInterceptor extends HandlerInterceptorAdapter {
    private InetAddress crawler;
    private static final Logger LOGGER = Logger.getLogger( TypeData.ClassName.class.getName() );

    @Autowired
    private RateLimitService rateLimitService;

    RateLimitInterceptor() {
/*        crawler = InetAddress.getLoopbackAddress();
        try {
            crawler = InetAddress.getByName("crawler");
        } catch (UnknownHostException e) {
            LOGGER.log(Level.SEVERE, "Couldn't get crawler address.",e);
        }*/
    }


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        // Crawler get a free pass
        if (request.getRemoteAddr() == crawler.getHostAddress())
            return true;
        if (rateLimitService.exceedsLimit(request.getRemoteAddr())) {
            response.sendError(429, "Rate limit exceeded.");
            return false;
        }
        return true;
    }
}