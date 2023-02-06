package neoris.automation.api.stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import neoris.api.dtos.constants.StatusCodeConstants;
import neoris.api.utils.GetStatusCode;
import neoris.api.utils.ValidateRequestResponse;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BaseSteps {
    @Given("^(.*) is a (?:.*) of test")
    public void defineActorName(String name) {
        theActorCalled(name);
    }

    @And("^it get (.*) in (?:.*)")
    public void validateStatusCodeResponse(String response) {
        int statusCodeCurrent = theActorInTheSpotlight().asksFor(GetStatusCode.get());
        StatusCodeConstants statusCodeConstants = StatusCodeConstants.getStatusCodeConstantKeys(response);
        int statusCodeExpected = statusCodeConstants.getValue();

        theActorInTheSpotlight().attemptsTo(
                ValidateRequestResponse.byStatusCode(statusCodeCurrent, statusCodeExpected)
        );
    }
}