package co.com.sofka.certification.challenge.questions;

import co.com.sofka.certification.challenge.models.Requests;
import co.com.sofka.certification.challenge.utils.common.GetFiles;
import com.google.gson.JsonObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class TheJsonResponse  implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(TheJsonResponse.class.getName());

    public TheJsonResponse() {

    }

    @Subject("Verify response in json format")
    @Override
    public Boolean answeredBy(Actor actor) {
        JsonObject responseConsult = Requests.getJsonResponse();

        boolean validation = false;

       validation = responseConsult.isJsonObject();
        LOGGER.info("The json format validation was: " + validation);
        return validation;
    }

    public static TheJsonResponse wasExpected() {
        return new TheJsonResponse();
    }
}