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

import static co.com.sofka.certification.challenge.models.Requests.getConsultResponse;

public class ConsultWeatherByCity {
    private static final Logger LOGGER = LogManager.getLogger(ConsultWeatherByCity.class.getName());

    private ConsultWeatherByCity() {
    }

    public static void processConsultWeatherByCity(String key) {
        MakeJsonRequets jrMadeConsultByCity = new MakeJsonRequets();
        Map<String, Object> objectConsutlByCityMade = new HashMap<>();
        String[] responseConsult = new String[3];
        try {
            SetExecutionVariables.setParameterConsultWeather(getConsultResponse().get("Lat").toString(),
                    getConsultResponse().get("Lon").toString(),key);
            responseConsult = jrMadeConsultByCity.consumeRestServices("Get", Requests.getEndPoint());

        } catch (Exception | ServiceConsumptionException e) {
            LOGGER.error("Error when trying to consume the service", e);
        }

        if("200".equals(responseConsult[0])){
            try {
                objectConsutlByCityMade.put("City", JsonParser.parseString(responseConsult[2]).getAsJsonObject().get("name"));
                objectConsutlByCityMade.put("weatherId", JsonParser.parseString(responseConsult[2]).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("id"));
                Requests.setConsultResponse(objectConsutlByCityMade);
            }catch (Exception e){
                LOGGER.error("Problem processing response", e);
            }
        }

    }
}

