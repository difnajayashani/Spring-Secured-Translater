package spring.login;

import httpClient.HttpClientClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;

@Controller
@EnableWebMvc
public class MainController {



    //to give the welcome page
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView visitWelcome() {
        return new ModelAndView("welcome");
    }

    //to gives the custom login page
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }


    //to give the admin page only for customers
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView visitAdmin() {
        return new ModelAndView("admin");
    }

    //to give the home page for normal logged in users
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView visitHome() {
        return new ModelAndView("home");

    }

    //
    @RequestMapping(value="/translate", method = RequestMethod.GET)
    public ModelAndView visitTranslate() throws Exception {

        HttpClientClass clientObject=new HttpClientClass();
        ArrayList<String> list= clientObject.getLangs();
        ModelAndView model = new ModelAndView("translate");
        model.addObject("language_list", list);

        return model;
//        return new ModelAndView("translate");
    }

    @RequestMapping(value="/translatedText", method = RequestMethod.GET)
    public @ResponseBody
    String getTranslatedText(@RequestParam("from_lang") String from_lang,
                             @RequestParam("to_lang") String to_lang,
                             @RequestParam("original_text") String original_text) throws Exception {

        HttpClientClass clientObject=new HttpClientClass();
        String list= clientObject.translate_text(from_lang,to_lang,original_text);
        return list;

//        return new ModelAndView("translate");
    }
}