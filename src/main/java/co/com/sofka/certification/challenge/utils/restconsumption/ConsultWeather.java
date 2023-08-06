package co.com.sofka.certification.challenge.utils.restconsumption;

import co.com.sofka.certification.challenge.exceptions.ServiceConsumptionException;
import co.com.sofka.certification.challenge.models.Requests;
import co.com.sofka.certification.challenge.utils.restconsumption.transversal.MakeJsonRequets;
import co.com.sofka.certification.challenge.utils.restconsumption.transversal.SetExecutionVariables;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class ConsultWeather {
    private static final Logger LOGGER = LogManager.getLogger(ConsultWeatherByCity.class.getName());

    private ConsultWeather() {
    }

    public static void processConsultWeather(String lat, String lon, String key) {
        MakeJsonRequets jrMadeConsultWether = new MakeJsonRequets();
        JsonObject jsonObjectConsutWeatherMade = new JsonObject();
        Map<String, Object> objectConsutlWeatherMade = new HashMap<>();
        String[] responseConsult = new String[3];
        try {
            SetExecutionVariables.setParameterConsultWeather(lat,lon,key);
            responseConsult = jrMadeConsultWether.consumeRestServices("Get", Requests.getEndPoint());

        } catch (Exception | ServiceConsumptionException e) {
            LOGGER.error("Error when trying to consume the service", e);
        }

        if("200".equals(responseConsult[0])){
            try {
                objectConsutlWeatherMade.put("City", JsonParser.parseString(responseConsult[2]).getAsJsonObject().get("name"));
                objectConsutlWeatherMade.put("lat", JsonParser.parseString(responseConsult[2]).getAsJsonObject().get("coord").getAsJsonObject().get("lat"));
                objectConsutlWeatherMade.put("lon", JsonParser.parseString(responseConsult[2]).getAsJsonObject().get("coord").getAsJsonObject().get("lon"));
                objectConsutlWeatherMade.put("weatherId", JsonParser.parseString(responseConsult[2]).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("id"));
                Requests.setConsultResponse(objectConsutlWeatherMade);
                Requests.setJsonResponse(JsonParser.parseString(responseConsult[2]).getAsJsonObject());
            }catch (Exception e){
                LOGGER.error("Problem processing response", e);
            }
        }else {
            objectConsutlWeatherMade.put("error", JsonParser.parseString(responseConsult[2]).getAsJsonObject().get("message"));
            Requests.setConsultResponse(objectConsutlWeatherMade);

        }

    }
}

