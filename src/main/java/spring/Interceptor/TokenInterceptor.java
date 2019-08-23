package spring.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import spring.token.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义token拦截器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            System.out.println("preHandle");
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("admin-token");
        if (token != null) {
            boolean result = TokenUtil.verify(token);
            if (result) {
                System.out.println("通过拦截器");
                return true;
            }
        }
        System.out.println("认证失败");
        response.getWriter().write("50000");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
