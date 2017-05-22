package Clients.client_factory;

import Clients.PropertyFileReader;
import Clients.interfaces.TranslateClients;
import Clients.services.HttpClientImpl;
import Clients.services.RestTemplateImpl;
import org.springframework.stereotype.Service;

@Service
public class TranslateClientsFactory {

    PropertyFileReader property=new PropertyFileReader();

    private TranslateClients client;


    public TranslateClientsFactory(){

        String clientType = property.getproperty("clientType",
                "system.properties",
                "", "", "", "",
                "", "", "");

        if (clientType.equals("HttpClient")){
            this.client = new HttpClientImpl();
        }
        else  if (clientType.equals("RestTemplate")){
            this.client = new RestTemplateImpl();
        }
    }

    public TranslateClients getClient( ){
     return client;
    }


}
