package co.com.sofka.certification.challenge.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features/weather_information.feature",
                 glue = {"co.com.sofka.certification.challenge.stepdefinitions"},
                 snippets = CucumberOptions.SnippetType.CAMELCASE)

public class WeatherInformation {

    private WeatherInformation() {}

}
