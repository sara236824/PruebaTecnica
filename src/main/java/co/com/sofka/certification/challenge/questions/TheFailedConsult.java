package co.com.sofka.certification.challenge.questions;

import co.com.sofka.certification.challenge.models.Requests;
import com.google.gson.JsonObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class TheFailedConsult implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(TheFailedConsult.class.getName());

    private boolean latitudMessageFailed = true;
    private boolean longitudMessageFailed = true;
    private boolean geocodeMessageFailed = true;
    public TheFailedConsult() {

    }

    @Subject("Verify response Failed message")
    @Override
    public Boolean answeredBy(Actor actor) {
        Map<String, Object> responseConsult = Requests.getConsultResponse();


        boolean validation = false;

        if(latitudMessageFailed){
            String message = "wrong latitude";
            validation = responseConsult.get("error").toString().contains(message);

        }else if (longitudMessageFailed){
            String message = "wrong longitude";
            validation = responseConsult.get("error").toString().contains(message);

        }else{
            String message = "Nothing to geocod";
            validation = responseConsult.get("error").toString().contains(message);
        }

        LOGGER.info("The validation of failed message was: " + validation);
        return validation;
    }

    public  TheFailedConsult latitudMessage(){
       this.latitudMessageFailed = true;
       this.longitudMessageFailed = false;
       this.geocodeMessageFailed = false;
       return this;
    }
    public  TheFailedConsult longitudMessage(){
        this.latitudMessageFailed = false;
        this.longitudMessageFailed = true;
        this.geocodeMessageFailed = false;
        return this;
    }
    public  TheFailedConsult geocodeMessage(){
        this.latitudMessageFailed = false;
        this.longitudMessageFailed = false;
        this.geocodeMessageFailed = true;
        return this;
    }


    public static TheFailedConsult forThe() {
        return new TheFailedConsult();
    }
}