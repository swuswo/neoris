package neoris.api.interactions.create;

import neoris.api.utils.GetUrlPaths;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostReqRes implements Interaction {

    protected static final String REQRES_API_BASE_URL = theActorInTheSpotlight().asksFor(GetUrlPaths.byProperty("env.dev.api.base.url.reqres.api"));
    private final Object body;
    String urlPath;

    public PostReqRes(Object body, String urlPath) {
        this.body = body;
        this.urlPath = urlPath;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(REQRES_API_BASE_URL));
        actor.attemptsTo(
                Post.to(urlPath)
                        .with(requestSpecification -> requestSpecification.body(body))
        );
    }

    public static PostReqRes withBody(Object body, String urlPath) {
        return instrumented(PostReqRes.class, body, urlPath);
    }
}