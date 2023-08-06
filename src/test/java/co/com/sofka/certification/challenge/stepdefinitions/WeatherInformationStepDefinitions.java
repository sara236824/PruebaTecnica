package co.com.sofka.certification.challenge.stepdefinitions;

import co.com.sofka.certification.challenge.exceptions.ValidateExecptions;
import co.com.sofka.certification.challenge.questions.*;
import co.com.sofka.certification.challenge.tasks.ConsultCityInformation;
import co.com.sofka.certification.challenge.tasks.ConsultWeather;
import co.com.sofka.certification.challenge.tasks.ConsultWeatherByCity;
import co.com.sofka.certification.challenge.tasks.ConsultWeatherXmlFormat;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class WeatherInformationStepDefinitions extends  GeneralStepDefinitions {

    @Before
    public void setUp() {
        generalSetUp();

    }

    @Given("the user consulted latitude and longitude of the {string} with  {string}")
    public void theUserConsultedLatitudeAndLongitudeOfTheWithAndAnd(String city, String key) {
        theActorInTheSpotlight().wasAbleTo(ConsultCityInformation.withThe(city, key));

    }

    @When("the user sends the weather consult by city requests with the  {string}")
    public void theUserSendsTheWeatherConsultByCityRequestsWithThe(String key) {
        theActorInTheSpotlight().attemptsTo(ConsultWeatherByCity.withThe(key));
    }

    @Then("the user sees the weather in {string}")
    public void theUserSeesTheWeatherIn(String city) {
        theActorInTheSpotlight().should(seeThat(TheWeatherConsultByCity.wasExpectedFor(city)).
                orComplainWith(ValidateExecptions.class, ValidateExecptions.ERROR_VALIDATING_BY_CITY));
    }

    @When("the user sends the weather consult with {string} and {string} and  {string}")
    public void theUserSendsTheWeatherConsultWithAndAnd(String lat, String lon, String key) {
        theActorInTheSpotlight().attemptsTo(ConsultWeather.withThe(lat, lon, key));

    }

    @Then("the user sees that {string} and {string} for the weather in {string}  is correct")
    public void theUserSeesThatAndForTheWeatherInIsCorrect(String lat, String lon, String city) {
        theActorInTheSpotlight().should(seeThat(TheWeatherCosult.wasExpectedFor(lat, lon, city)).
                orComplainWith(ValidateExecptions.class, ValidateExecptions.ERROR_VALIDATING_BY_CITY));
    }

    @When("the user sends the consult of weather in XML format with the {string}  and  {string}")
    public void theUserSendsTheConsultOfWeatherInXMLFormatWithTheAnd(String city, String key) {
        theActorInTheSpotlight().attemptsTo(ConsultWeatherXmlFormat.withThe(city, key));

    }

    @Then("the user sees the weather in xml format")
    public void theUserSeesTheWeatherInXmlFormat() {
        theActorInTheSpotlight().should(seeThat(TheXmlResponse.wasExpected()).
                orComplainWith(ValidateExecptions.class, ValidateExecptions.ERROR_VALIDATING_FORMAT));
    }

    @Then("the user sees the weather in Json format")
    public void theUserSeesTheWeatherInJsonFormat() {
        theActorInTheSpotlight().should(seeThat(TheJsonResponse.wasExpected()).
                orComplainWith(ValidateExecptions.class, ValidateExecptions.ERROR_VALIDATING_FORMAT));

    }
    @Then("The user will see the failed message")
    public void theUserWillSeeTheFailedMessage() {
        theActorInTheSpotlight().should(seeThat(TheFailedConsult.forThe().geocodeMessage()).
                orComplainWith(ValidateExecptions.class, ValidateExecptions.ERROR_VALIDATING_RESPONSE_MESSAGE));    }

    @Then("The user will see the failed latitud message")
    public void theUserWillSeeTheFailedLatitudMessage() {
        theActorInTheSpotlight().should(seeThat(TheFailedConsult.forThe().latitudMessage()).
                orComplainWith(ValidateExecptions.class, ValidateExecptions.ERROR_VALIDATING_RESPONSE_MESSAGE));
    }

    @Then("The user will see the failed longitude message")
    public void theUserWillSeeTheFailedLongitudeMessage() {
        theActorInTheSpotlight().should(seeThat(TheFailedConsult.forThe().longitudMessage()).
                orComplainWith(ValidateExecptions.class, ValidateExecptions.ERROR_VALIDATING_RESPONSE_MESSAGE));
    }
}
