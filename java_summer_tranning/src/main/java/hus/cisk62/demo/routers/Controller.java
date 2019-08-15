package hus.cisk62.demo.routers;

import hus.cisk62.demo.entities.ApplicationEntity;
import hus.cisk62.demo.repositories.ApplicationRepository;
import hus.cisk62.demo.services.ApplicationService;
import hus.cisk62.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/")
    public String index(Model model) {
        model.addAttribute("applications", applicationService.findByElementID(1));
        return "page.html";
    }

    @RequestMapping(path = "/logintest", method = RequestMethod.GET)
    public String login() {
        return "logintest.html";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") LoginForm form, Model model) {
        if(loginService.checkLogin(form.getAccount(),form.getPassword())){
            model.addAttribute("applications", applicationService.findByElementID(1));
            return "admin.html";
        }
        return "404.html";
    }

    @GetMapping("/contact/add")
    public String add(Model model) {
        model.addAttribute("applications", new ApplicationEntity());
        return "emp.html";
    }

    @RequestMapping(value = "/contact/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("applications") ApplicationEntity applicationEntity) {
        if (applicationEntity == null)

            System.out.println("nulll");
        else
            System.out.println(applicationEntity);
            applicationService.save(applicationEntity);

        return "redirect:/admin";
    }
}