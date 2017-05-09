package Clients;


import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateImpl implements TranslateClients{



    static final String PostUrl = "https://translate.yandex.net/api/v1.5/tr.json/getLangs?ui=en&key=trnsl.1.1.20170503T100221Z.4368a98a5bf8695f.8e5ad4958ffe22ab6cadefa6a54bb7be12111796";



    RestTemplate restTemplate = new RestTemplate();
    String translatedText;
    JSONParser parser = new JSONParser();


    //for testing of the individual class
    public static void main(String[] args) throws Exception {
        RestTemplateImpl rs=new RestTemplateImpl();

        HashMap<String, String> ex1=rs.getLangs();
        for (Map.Entry<String, String> entry : ex1.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
       String tText=rs.translate_text("en","tt","mother");
       System.out.println(tText);
        System.out.println("TRANS DONE");
    }


    public  HashMap<String, String> getLangs() throws ParseException, JSONException, IOException {


        //initiate an empty hashmap to load the output
        HashMap<String, String> result = null;

        //get the language list from the REST Template
        String getAllLanguagesList = restTemplate.getForObject(PostUrl, String.class);

        //parse the string language list to an JSON object
        JSONObject obj= new JSONObject(getAllLanguagesList);

        //get the "langs" as a separate JSON object
        JSONObject langObj=obj.getJSONObject("langs");

        //map the JSON object to a HashMap
        result = new ObjectMapper().readValue(langObj.toString(), HashMap.class);

        return result;
    }


    /** function to translate a input string to the given language using the REST Template when the HTTP
     response is in JSON format
     * o_lan => language of the original string to be translated
     * t_lan => language for the string to be translated
     * text_input => input string
     * */
    public  String translate_text(String o_lan,String t_lan,String text_input) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String translatedResponse;
        String transUrl="https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20170503T100221Z.4368a98a5bf8695f.8e5ad4958ffe22ab6cadefa6a54bb7be12111796&lang="+o_lan+"-"+t_lan+"&text="+text_input;

        translatedResponse=restTemplate.getForObject(transUrl,String.class);
        JSONObject translatedResponseJson= new JSONObject(translatedResponse);
        String translatedText= String.valueOf(translatedResponseJson.get("text"));

        return  translatedText;

    }
}
