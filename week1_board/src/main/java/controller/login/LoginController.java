package controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import service.login.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

//    @GetMapping("/main")
//    public ModelAndView main() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("main");
//        return mv;
//    }

    @GetMapping("/login")
    public ModelAndView loginPage() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

}
