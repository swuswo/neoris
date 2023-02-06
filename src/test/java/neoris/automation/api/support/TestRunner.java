package neoris.automation.api.support;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty"},
        snippets = CAMELCASE,
        glue = {"/neoris/automation/api/stepsdefinitions", "neoris/automation/api/support"},
        tags = "@test"
)

public class TestRunner {
}