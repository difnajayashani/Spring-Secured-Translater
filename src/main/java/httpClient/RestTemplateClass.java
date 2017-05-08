package httpClient;

import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by hsenid on 5/8/17.
 */
public class RestTemplateClass {

    Gson gson = new Gson();
    JSONObject obj;
    String convertedText;
    BufferedReader br;
    HashMap<String, Object> result;

    public HashMap getLanguages() {
        try {
            URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/getLangs?key=trnsl.1.1.20170503T091519Z.9f30c24402100dfb.91f7ddaca07e07cddb27fd1cd769dd2b43d5c765&ui=en");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            obj = new JSONObject(br.readLine()).getJSONObject("langs");
            result = new ObjectMapper().readValue(obj.toString(), HashMap.class);

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String translate_text(String o_lan,String t_lan,String text_input) {
        try {
            URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20170503T091519Z.9f30c24402100dfb.91f7ddaca07e07cddb27fd1cd769dd2b43d5c765&text="
                    + text_input + "&lang=" + o_lan + "-" + t_lan);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            convertedText = gson.fromJson(br.readLine(), convertedText);
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertedText;
    }
}
