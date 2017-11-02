import org.junit.Test;
import pages.MainPage;

import java.util.List;

public class UITests {

    @Test
    public void duckNameShouldBeTheSameAsInDb() {

        List<String> duckNamesFromUI = new MainPage()
                .openMainPage()
                .openRubberDucksPage()
                .getDuckNames();

    }

}
