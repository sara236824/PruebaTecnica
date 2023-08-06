package co.com.sofka.certification.challenge.tasks;

import co.com.sofka.certification.challenge.utils.restconsumption.ConsultCity;
import co.com.sofka.certification.challenge.utils.restconsumption.ConsultInXmlFormat;
import co.com.sofka.certification.challenge.utils.restconsumption.ConsultWeatherByCity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsultWeatherXmlFormat   implements Task {

    private  String city;
    private  String key;

    public ConsultWeatherXmlFormat(String city, String key) {
        this.city = city;
        this.key =key;

    }

    @Subject("consult weather in xml formart")
    @Override
    public <T extends Actor> void performAs(T actor) {
        ConsultInXmlFormat.processConsultInXmlFormat(city,key);
    }

    public static ConsultWeatherXmlFormat withThe(String city, String key){
        return Tasks.instrumented(ConsultWeatherXmlFormat.class, city,key);
    }

}
