package co.com.sofka.certification.challenge.tasks;

import co.com.sofka.certification.challenge.utils.restconsumption.ConsultCity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConsultCityInformation  implements Task {

    private  String city;
    private  String key;

    public ConsultCityInformation(String city, String key) {
        this.city = city;
        this.key =key;

    }

    @Subject("consult latitude and longitude of the city")
    @Override
    public <T extends Actor> void performAs(T actor) {
        ConsultCity.processConsultCityInfo(city,key);
    }

    public static ConsultCityInformation withThe(String city, String key){
        return Tasks.instrumented(ConsultCityInformation.class, city,key);
    }

}
