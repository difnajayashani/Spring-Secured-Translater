package spring.login;

import Clients.HttpClientImpl;
import Clients.RestTemplateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
@EnableWebMvc
public class MainController {

    @Autowired
    HttpClientImpl clientObject;

    @Autowired
    RestTemplateImpl restTemplate;

    //to give the welcome page
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView visitWelcome() {
        return new ModelAndView("welcome");
    }

    //to gives the custom login page
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {


        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
       return model;
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

    //to give the translate page and load the language list
    @RequestMapping(value="/translate", method = RequestMethod.GET)
    public ModelAndView visitTranslate() throws Exception {


        HashMap<String, String> language_list = clientObject.getLangs();
        //HashMap<String, String> language_list = restTemplate.getLangs();

        ModelAndView model = new ModelAndView();
        model.addObject("language_list",language_list);
        model.setViewName("translate");

        return model;

    }

    //to retrieve the translated text
    @RequestMapping(value="/translatedText", method = RequestMethod.GET)
    public ModelAndView getTranslatedText(@RequestParam("original-lang") String from_lang,
                             @RequestParam("translate-lang") String to_lang,
                             @RequestParam("original_text") String original_text,
                             @RequestParam("selectedOl") String selectedOl) throws Exception {


        String transText= clientObject.translate_text(from_lang,to_lang,original_text);
        //String transText= restTemplate.translate_text(from_lang,to_lang,original_text);

        ModelAndView model = new ModelAndView();

        model.addObject("original_lang", from_lang);
        model.addObject("translated_lang", to_lang);
        model.addObject("original_text", original_text);
        model.addObject("translated_text", transText);
        model.addObject("language_list",clientObject.getLangs());
       // model.addObject("language_list",restTemplate.getLangs());

        model.setViewName("translate");
        return model;
    }

    //to destroy the session in logout function
    @RequestMapping(value = "/login?logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "welcome";
    }
}