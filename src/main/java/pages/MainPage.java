package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends AbstractPage {

    final String MAIN_PAGE_URL = "http://localhost/litecart";
    By ruberDuckButtonLocator =
            By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-1']");

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);

        return this;
    }

    public RuberDucksPage openRubberDucksPage() {
        driver.findElement(ruberDuckButtonLocator).click();

        return new RuberDucksPage();
    }
}
