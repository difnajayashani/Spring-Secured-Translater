package spring.login;

import httpClient.HttpClientClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {



    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView visitWelcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView visitAdmin() {
        return new ModelAndView("admin");
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView visitHome() {
        return new ModelAndView("home");

    }

    @RequestMapping(value="/translate", method = RequestMethod.GET)
    public ModelAndView visitTranslate() throws Exception {

        HttpClientClass clientObject=new HttpClientClass();
        ArrayList<String> list= clientObject.getLangs();
        ModelAndView model = new ModelAndView("translate");
        model.addObject("language_list", list);

        return model;
//        return new ModelAndView("translate");
    }
}