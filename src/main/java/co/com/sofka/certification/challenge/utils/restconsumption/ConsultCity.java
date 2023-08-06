package co.com.sofka.certification.challenge.utils.restconsumption;

import co.com.sofka.certification.challenge.exceptions.ServiceConsumptionException;
import co.com.sofka.certification.challenge.models.Requests;
import co.com.sofka.certification.challenge.utils.restconsumption.transversal.MakeJsonRequets;
import co.com.sofka.certification.challenge.utils.restconsumption.transversal.SetExecutionVariables;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ConsultCity {
    private static final Logger LOGGER = LogManager.getLogger(ConsultCity.class);

    private ConsultCity() {
    }

    public static void processConsultCityInfo(String city, String key) {
        MakeJsonRequets jrMadeConsult = new MakeJsonRequets();
        Map<String, Object> objectConsutlMade = new HashMap<>();
        String[] responseConsult = new String[3];
        try {
            SetExecutionVariables.setParameterConsultCityInfo(city, key);
            responseConsult = jrMadeConsult.consumeRestServices("Get", Requests.getEndPoint());

        } catch (Exception | ServiceConsumptionException e) {
            LOGGER.error("Error when trying to consume the service", e);
        }

        if ("200".equals(responseConsult[0])) {
            try {

                objectConsutlMade.put("Lat", JsonParser.parseString(responseConsult[2]).getAsJsonArray().get(0).getAsJsonObject().get("lat"));
                objectConsutlMade.put("Lon", JsonParser.parseString(responseConsult[2]).getAsJsonArray().get(0).getAsJsonObject().get("lon"));
                Requests.setConsultResponse(objectConsutlMade);
            } catch (Exception e) {
                LOGGER.error("Problem procesing response", e);
            }
        }else{
            objectConsutlMade.put("error", JsonParser.parseString(responseConsult[2]).getAsJsonObject().get("message"));
            Requests.setConsultResponse(objectConsutlMade);

        }
    }
}
