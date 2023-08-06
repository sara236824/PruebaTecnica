package co.com.sofka.certification.challenge.tasks;

import co.com.sofka.certification.challenge.utils.restconsumption.ConsultCity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsultWeather implements Task {
    private static final Logger LOGGER = LogManager.getLogger(ConsultWeather.class);
    private String lat;
    private String lon;
    private String key;

    public ConsultWeather(String lat, String lon, String key) {
        this.lat = lat;
        this.lon = lon;
        this.key = key;
    }

    @Subject("consult weather with latitude and longitude")
    @Override
    public <T extends Actor> void performAs(T actor) {
        co.com.sofka.certification.challenge.utils.restconsumption.ConsultWeather.processConsultWeather(lat,lon,key);
    }

    public static ConsultWeather withThe(String lat, String lon, String key) {
        return Tasks.instrumented(ConsultWeather.class, lat, lon, key);
    }

}
