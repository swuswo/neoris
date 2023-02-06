package neoris.api.tasks.create;

import neoris.api.dtos.create.Users;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateUsers implements Task {
    private final Users users;

    public ValidateUsers (Users users) {
        this.users = users;
    }

    @Override
    @Step("{0} validates that creation request is correct with id and creation date")
    public void performAs(Actor actor) {
        actor.should(
                seeThat("the id", data -> users.getId(), Matchers.notNullValue()),
                seeThat("creation date", data -> users.getCreatedAt(), Matchers.notNullValue())
        );
    }

    public static ValidateUsers response(Users users) {
        return instrumented(ValidateUsers.class, users);
    }
}
