package co.com.sofka.certification.challenge.questions;

import co.com.sofka.certification.challenge.models.Requests;
import co.com.sofka.certification.challenge.utils.common.GetFiles;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class TheWeatherCosult implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(TheWeatherCosult.class.getName());

    private String lat;
    private String lon;
    private String city;

    public TheWeatherCosult(String lat, String lon, String city) {
        this.lat = lat;
        this.lon = lon;
        this.city = city;
    }

    @Subject("Verify response of consult weather by lat and lon")
    @Override
    public Boolean answeredBy(Actor actor) {
        Map<String, Object> responseConsult = Requests.getConsultResponse();

        boolean validation = false;

        try {
            String weathercodes = GetFiles.getFile("src/main/resources/weathersCode.txt");
            validation = (responseConsult.get("City").toString()).contains(city) &&
                    (responseConsult.get("lat").toString()).contains(lat) &&
                    (responseConsult.get("lon").toString()).contains(lon) &&
                    weathercodes.contains(responseConsult.get("weatherId").toString());
        } catch (Exception e) {
            LOGGER.error("Error trying to read code file");
        }

        LOGGER.info("The weather validation was: " + validation);
        return validation;
    }

    public static TheWeatherCosult wasExpectedFor(String lat, String lon, String city) {
        return new TheWeatherCosult(lat, lon, city);
    }
}
