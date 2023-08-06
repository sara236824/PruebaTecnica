package co.com.sofka.certification.challenge.utils.restconsumption.transversal;

import co.com.sofka.certification.challenge.exceptions.ServiceConsumptionException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MakeJsonRequets {
    private static final Logger LOGGER = LogManager.getLogger(MakeJsonRequets.class.getName());

    public String[] consumeRestServices(String requestType, String requestEndpoint) throws ServiceConsumptionException {
        String[] responseAux = new String[3];
        HttpResponse<JsonNode> response = null;
        HttpResponse<String> responseXml = null;
        String msg1 = "Consumption of a " + requestType + " request";
        LOGGER.info(msg1);
        try {
            if ("Get".equalsIgnoreCase(requestType)) {
                response = Unirest.get(requestEndpoint).asJson();

            } else if ("GetXml".equalsIgnoreCase(requestType)) {
                responseXml = Unirest.get(requestEndpoint).asString();

            } else {
                LOGGER.info("Error trying to consume Rest Services: unsupported type of request");
            }
            if( response != null){
                responseAux[0] = String.valueOf(response.getStatus());
                responseAux[1] = response.getStatusText();
                responseAux[2] = IOUtils.toString(response.getRawBody(), StandardCharsets.UTF_8);
            }else {
                responseAux[0] = String.valueOf(responseXml.getStatus());
                responseAux[1] = responseXml.getStatusText();
                responseAux[2] = IOUtils.toString(responseXml.getRawBody(), StandardCharsets.UTF_8);
            }



        } catch (UnirestException | IOException e) {
            throw new ServiceConsumptionException("Error trying to consume Rest Services(JSONRequests Class)", e);
        }
        String msg2 = "El servicio respondio un código " + responseAux[0] + " " + responseAux[1];
        LOGGER.info(msg2);
        LOGGER.info("Response Body: " + responseAux[2]);
        return responseAux;
    }
}
