package neoris.api.interactions.create;

import neoris.api.dtos.create.UsersDTO;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostCreate implements Task {
    private static final String CREATE_AUTH = "/api/users";
    private final UsersDTO usersDTO;

    public PostCreate(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    @Override
    @Step("{0} request a creation")
    public void performAs(Actor actor) {
        actor.attemptsTo(
                PostReqRes.withBody(usersDTO, CREATE_AUTH)
        );
    }

    public static Performable withBody(UsersDTO usersDTO) {
        return instrumented(PostCreate.class, usersDTO);
    }
}
