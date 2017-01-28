package pcbuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class RateLimitInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RateLimitService rateLimitService;

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