package neoris.automation.api.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import neoris.api.dtos.create.Users;
import neoris.api.dtos.create.UsersDTO;
import neoris.api.dtos.create.UsersFactory;
import neoris.api.interactions.create.PostCreate;
import neoris.api.questions.endpoint.UsersResponse;
import neoris.api.tasks.create.ValidateUsers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateSteps {

    @When("^create user with (.*) and (.*)")
    public void createUserWithNameAndPosition(String names, String job) {

        UsersDTO usersDTO = new UsersFactory().requestValue(names, job);
        theActorInTheSpotlight().attemptsTo(PostCreate.withBody(usersDTO));

        Users users = theActorInTheSpotlight().asksFor(UsersResponse.get());
        theActorInTheSpotlight().attemptsTo(ValidateUsers.response(users));
    }
}
