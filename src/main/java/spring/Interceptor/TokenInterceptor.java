package spring.Interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import spring.token.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义token拦截器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("request.getMethod:" + request.getMethod());
        //if (request.getMethod().equals("OPTIONS")) {
        //    System.out.println("HttpServletResponse.SC_OK:" + HttpServletResponse.SC_OK);
        //    response.setStatus(HttpServletResponse.SC_OK);
        //    response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        //    response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
        //    response.addHeader("Access-Control-Allow-Credentials:","true");
        //    response.addHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,Content-Type");
        //    System.out.println("preHandle");
        //    return true;
        //}
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("Authorization");
        System.out.println("token" + token);
        if (token != null) {
            boolean result = TokenUtil.verify(token.replace("\"", ""));
            if (result) {
                System.out.println("通过拦截器");
                return true;
            }
        }
        System.out.println("认证失败");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 401);
        map.put("message", "未登录或token过期!");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print(JSON.toJSONString(map));

        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
