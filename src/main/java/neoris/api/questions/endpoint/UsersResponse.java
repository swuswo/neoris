package neoris.api.questions.endpoint;

import neoris.api.dtos.create.Users;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

public class UsersResponse implements Question<Users> {

    @Override
    @Step("{0} get info service")
    public Users answeredBy(Actor actor) {

        return SerenityRest.lastResponse().as(Users.class);
    }

    public static Question<Users> get() {
        return new UsersResponse();
    }
}
