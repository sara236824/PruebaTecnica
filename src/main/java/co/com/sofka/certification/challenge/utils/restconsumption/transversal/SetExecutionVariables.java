package co.com.sofka.certification.challenge.utils.restconsumption.transversal;

import co.com.sofka.certification.challenge.models.Requests;
import io.cucumber.java.bs.A;

import java.util.HashMap;
import java.util.Map;

public class SetExecutionVariables {

    private  SetExecutionVariables(){throw new IllegalStateException("Utility class");}

    public static void setParameterConsultCityInfo(String city,String key){

        Requests.setEndPoint("http://api.openweathermap.org/geo/1.0/direct?q="+ city +"&limit=5&appid=" + key);
    }

    public static void setParameterConsultWeather(String lat, String lon, String key){

        Requests.setEndPoint("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=" + key);
    }

    public static void setParameterConsultXmlFormat(String city, String key){

        Requests.setEndPoint("https://api.openweathermap.org/data/2.5/weather?q="+city+"&mode=xml&appid=" + key);
    }

}
