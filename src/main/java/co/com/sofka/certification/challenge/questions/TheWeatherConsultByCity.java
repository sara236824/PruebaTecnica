package co.com.sofka.certification.challenge.questions;

import co.com.sofka.certification.challenge.models.Requests;
import co.com.sofka.certification.challenge.utils.common.GetFiles;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class TheWeatherConsultByCity  implements Question<Boolean> {
     private static final Logger LOGGER = LogManager.getLogger(TheWeatherConsultByCity.class.getName());

     private String city;
     public TheWeatherConsultByCity(String city){
         this.city = city;
     }

    @Subject("Verify response of consult weather by City")
    @Override
    public Boolean answeredBy(Actor actor) {
        Map<String, Object> responseConsult = Requests.getConsultResponse();

        boolean validation = false;

        try {
            String weathercodes = GetFiles.getFile("src/main/resources/weathersCode.txt");
            validation =(responseConsult.get("City").toString()).contains(city) &&
                          weathercodes.contains(responseConsult.get("weatherId").toString());
        } catch (Exception e) {
            LOGGER.error("Error trying to read code file");
        }

        LOGGER.info("The weather by city validation was: " + validation);
        return validation;
    }

    public static TheWeatherConsultByCity wasExpectedFor(String city){
        return  new TheWeatherConsultByCity(city);
    }
}
