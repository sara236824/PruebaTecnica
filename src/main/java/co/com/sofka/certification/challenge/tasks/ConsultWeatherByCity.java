package co.com.sofka.certification.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsultWeatherByCity implements Task {
    private  static final Logger LOGGER = LogManager.getLogger(ConsultWeatherByCity.class);
    private  String key;
    public ConsultWeatherByCity(String key) {
        this.key =key;
    }

    @Subject("consult weather with latitude and longitude")
    @Override
    public <T extends Actor> void performAs(T actor) {
        co.com.sofka.certification.challenge.utils.restconsumption.ConsultWeatherByCity.processConsultWeatherByCity(key);
    }

    public static ConsultWeatherByCity withThe(String key){
        return Tasks.instrumented(ConsultWeatherByCity.class,  key);
    }

}
