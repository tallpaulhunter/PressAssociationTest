package functions;

/**
 * Created by paul.hunter on 10/08/2017.
 */
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.junit.Cucumber.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "src/test/java/steps")
public class runTest {
}
