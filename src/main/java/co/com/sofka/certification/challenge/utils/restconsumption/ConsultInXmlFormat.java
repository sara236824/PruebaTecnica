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

public class ConsultInXmlFormat  {
    private static final Logger LOGGER = LogManager.getLogger(ConsultInXmlFormat.class.getName());
    private ConsultInXmlFormat() {
    }
    public static void processConsultInXmlFormat(String city, String key) {
        MakeJsonRequets jrMadeXmlConsult = new MakeJsonRequets();
        String[] responseConsult = new String[3];
        try {
            SetExecutionVariables.setParameterConsultXmlFormat(city,key);
            responseConsult = jrMadeXmlConsult.consumeRestServices("GetXml", Requests.getEndPoint());
        } catch (Exception | ServiceConsumptionException e) {
            LOGGER.error("Error when trying to consume the service", e);
        }

        if("200".equals(responseConsult[0])){
            try {
                Requests.setXmlResponse(responseConsult[2]);
            }catch (Exception e){
                LOGGER.error("Problem procesing response", e);
            }
        }

    }
}
