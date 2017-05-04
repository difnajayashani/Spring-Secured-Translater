package spring.login;

import httpClient.HttpClientClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {



    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView visitWelcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView visitAdmin() {
        return new ModelAndView("admin");
      /*  ModelAndView model = new ModelAndView("admin");
        model.addObject("title", "Admministrator Control Panel");
        model.addObject("message", "This page demonstrates how to use Spring security.");*/

//        return model;
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView visitHome() {
        return new ModelAndView("home");

    }

    @RequestMapping(value="/translate", method = RequestMethod.GET)
    public ModelAndView visitTranslate() throws Exception {

        HttpClientClass clientObject=new HttpClientClass();
        ArrayList<String> list= clientObject.getLangs();
        Map<String, Object> model = new HashMap<String, Object>();
        //ModelAndView model = new ModelAndView("translate");
        model.put("language_list", list);


        return new ModelAndView("translate","model",model);
//        return new ModelAndView("translate");
    }
}