import org.junit.Test;
import pages.MainPage;
import utils.DBHelper;

import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class UITests {

    @Test
    public void duckNameShouldBeTheSameAsInDb() {

        List<String> duckNamesFromUI = new MainPage()
                .openMainPage()
                .openRubberDucksPage()
                .getDuckNames();

        List<String> duckNamesFromDB = DBHelper.getDuckNames();

        Collections.sort(duckNamesFromDB);
        Collections.sort(duckNamesFromUI);

        assertEquals(duckNamesFromDB, duckNamesFromUI);
    }
}
