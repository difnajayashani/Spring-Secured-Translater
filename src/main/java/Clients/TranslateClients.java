package Clients;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by hsenid on 5/9/17.
 */
public interface TranslateClients {

    public HashMap<String, String> getLangs() throws Exception ;

    public  String translate_text(String o_lan,String t_lan,String text_input)  throws Exception;

}
