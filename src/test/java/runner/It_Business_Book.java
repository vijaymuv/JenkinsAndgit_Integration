package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\Friday\\IdeaProjects\\Project_Interview\\src\\test\\java\\feature\\ItBusinessBook.feature",
glue="stepDefinition",
//        snippets = CucumberOptions.SnippetType.CAMELCASE,
//        monochrome = true
//dryRun = true
        plugin = {"json:Reports/login.json",
                "html:Reports/login.html",
                "junit:Reports/login.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",}
)

public class It_Business_Book extends AbstractTestNGCucumberTests {

}
