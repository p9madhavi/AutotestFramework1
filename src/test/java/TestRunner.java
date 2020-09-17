
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "stepdefs"
//         ,tags = { "@login" })
        ,tags = { "not @wip" })
public class TestRunner extends AbstractTestNGCucumberTests{

}