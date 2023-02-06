package neoris.api.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class    ValidateRequestResponse implements Task {

    private final int statusCodeCurrent;
    private final int statusCodeExpected;

    public ValidateRequestResponse(int statusCodeCurrent, int statusCodeExpected) {

        this.statusCodeCurrent = statusCodeCurrent;
        this.statusCodeExpected = statusCodeExpected;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        theActorInTheSpotlight().should(
                seeThat("", actor -> statusCodeCurrent, Matchers.equalTo(statusCodeExpected))
        );
    }

    public static ValidateRequestResponse byStatusCode(int statusCodeCurrent, int statusCodeExpected) {
        return instrumented(ValidateRequestResponse.class, statusCodeCurrent, statusCodeExpected);
    }
}