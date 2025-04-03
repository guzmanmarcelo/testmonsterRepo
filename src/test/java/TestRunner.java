import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"org.example.steps"},
        features = {"src/test/resources/features"},
        plugin = {
                "json:target/jsonReports/cucumber.json"
        }
)
public class TestRunner {
}
