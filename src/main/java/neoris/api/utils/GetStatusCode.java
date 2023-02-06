package neoris.api.utils;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

public class GetStatusCode implements Question<Integer> {

    @Override
    @Step("{0} obtiene código de respuesta")
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static Question<Integer> get(){
        return new GetStatusCode();
    }
}
