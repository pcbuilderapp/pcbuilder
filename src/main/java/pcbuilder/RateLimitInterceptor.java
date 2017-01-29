package pcbuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Intercept all HTTP requests to enable rate limiting.
 */

@Service
public class RateLimitInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RateLimitService rateLimitService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        if (rateLimitService.exceedsLimit(request.getRemoteAddr())) {
            response.sendError(429, "Rate limit exceeded.");
            return false;
        }
        return true;
    }
}