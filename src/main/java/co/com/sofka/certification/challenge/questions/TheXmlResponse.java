package co.com.sofka.certification.challenge.questions;

import co.com.sofka.certification.challenge.models.Requests;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TheXmlResponse  implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(TheXmlResponse.class.getName());

    public TheXmlResponse() {

    }

    @Subject("Verify response in xml format")
    @Override
    public Boolean answeredBy(Actor actor) {
        String responseConsult = Requests.getXmlResponse();

        boolean validation = false;

        validation = responseConsult.contains("<?xml version=");

         LOGGER.info("The xml format validation was: " + validation);
        return validation;
    }

    public static TheXmlResponse wasExpected() {
        return new TheXmlResponse();
    }
}