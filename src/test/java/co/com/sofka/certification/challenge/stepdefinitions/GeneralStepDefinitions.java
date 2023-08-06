package co.com.sofka.certification.challenge.stepdefinitions;

import net.bytebuddy.implementation.FieldAccessor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

public class GeneralStepDefinitions {


    private void initialSetUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Sofkiano");

    }


    protected  void generalSetUp(){
        initialSetUp();
    }

}
