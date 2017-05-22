package Clients.services;

import Clients.PropertyFileReader;
import Clients.interfaces.TranslateClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;


@Service
public class HttpClientImpl implements TranslateClients {

    PropertyFileReader property=new PropertyFileReader();

    /** URL to send the request to the API to obtain the language list*/
    final String postUrl = property.getproperty(
            "yandexXmlUrl",
            "system.properties",
            "getLangs",
            "ui=en",
            "",
            "",
            "",
            "",
            "");


    //for testing
    public static void main(String[] args) throws Exception {
        /** for testing purpose of this class*/
        HttpClientImpl client=new HttpClientImpl();
        String  ex2 = client.translate_text("en", "ru", "Hello");
        System.out.println(ex2);


        System.out.println("TRANS DONE");

        HashMap<String, String> s= client.getLangs();
        System.out.println(s);
    }


    /** function to get the language list */
    public  HashMap<String, String> getLangs() throws Exception {

        CloseableHttpClient client = HttpClientBuilder.create().build();
        //send the request
        HttpPost request = new HttpPost(postUrl);

        //excute the request to obtain the response
        CloseableHttpResponse response = client.execute(request);

        /** Get the response */
        InputStream input = response.getEntity().getContent();


        /**creating DOM object to parse the XML returned in response*/
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();

        Document doc = builder.parse(input);

        /** get the elements in the Item TAG*/
        NodeList nameNodesList = doc.getElementsByTagName("Item");

        /**create a new array list */
       // ArrayList<String> listValues = new ArrayList<String>();
        HashMap<String, String> listValues = new HashMap<String, String>();

        /** get the value of the attribute "value" in the Item TAG and put it in to the above created arraylist*/
        for (int i = 0; i < nameNodesList.getLength(); i++) {

            //listValues.add(nameNodesList.item(i).getAttributes().getNamedItem("value").getNodeValue());
            String key= nameNodesList.item(i).getAttributes().getNamedItem("key").getNodeValue();
            String value=nameNodesList.item(i).getAttributes().getNamedItem("value").getNodeValue();
            listValues.put(key,value);

        }

        return listValues;

    }

    /**
     *
     * @param fromLanguage language of the original string to be translated
     * @param toLanguage  language for the string to be translated
     * @param text_input  input string
     * @return  String with the translated text
     * @throws Exception
     */
    public String translate_text(String fromLanguage,String toLanguage,String text_input) throws Exception {


        String output;

        String transUrl=property.getproperty(
                "yandexXmlUrl",
                "system.properties",
                "translate",
                "text=",
                 text_input,
                "&lang=",
                fromLanguage,
                "-",toLanguage);

        /** URL sent to the API to get the string translated*/
        //final String transUrl=url+fromLanguage+"-"+toLanguage+"&text="+text_input;

        /**send the request to the server thorough HttpClient*/
        org.apache.http.client.HttpClient httpClient_translate = new DefaultHttpClient();
        HttpGet request = new HttpGet(transUrl);
        org.apache.http.HttpResponse response2 = httpClient_translate.execute(request);


        /**Get the response*/
        InputStream input2 = response2.getEntity().getContent();

        /**creating DOM object*/
        DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = dbf2.newDocumentBuilder();
        Document doc = builder2.parse(input2);

        NodeList text_tag = doc.getElementsByTagName("text");

        /** get the string value of the content in the text TAG*/
        output = String.valueOf(text_tag.item(0).getTextContent());

        return output;
    }
}
