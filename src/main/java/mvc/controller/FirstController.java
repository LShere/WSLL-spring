package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FirstController {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "这是我的第一个Spring MVC程序");
        mav.setViewName("/WEB-INF/jsp/first.jsp");
        return mav;
    }
}
