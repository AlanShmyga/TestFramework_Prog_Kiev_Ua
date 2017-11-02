package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

import java.util.ArrayList;
import java.util.List;

public class RuberDucksPage extends AbstractPage {

    By duckNameLocator = By.xpath("//a[@title]//div[@class='name']");

    public List<String> getDuckNames() {
        List<WebElement> duckNamesElements =
                driver.findElements(duckNameLocator);

        List<String> duckNames = new ArrayList<>();

        for (WebElement duckNameElement : duckNamesElements) {
            duckNames.add(duckNameElement.getText());
        }

        return duckNames;
    }

}
