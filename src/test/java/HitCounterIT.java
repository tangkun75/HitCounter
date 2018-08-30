import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HitCounterIT {
    private static String CONTEXT = "HitCounter";

    @Test
    public void testHitCounterShouldPassed() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        String url = "http://localhost:8080/" + CONTEXT;
                WebDriver driver = new ChromeDriver();
        try {
            driver.get(url + "/myHtml/1.html");
            Thread.sleep(2000);  // Let the user actually see something!

            driver.get(url + "/myHtml/2.html");
            Thread.sleep(2000);  // Let the user actually see something!

            driver.get(url + "/HitCounter.jsp");
            Thread.sleep(5000);  // Let the user actually see something!

            assertTrue("Expected myHtml/1.html hit 2 times", driver.findElement(By.xpath("html/body/table/tbody")).getText().contains("myHtml/1.html 1"));
            assertTrue("Expected myHtml/2.html hit 2 times", driver.findElement(By.xpath("html/body/table/tbody")).getText().contains("myHtml/2.html 1"));

            assertFalse(driver.findElement(By.xpath("html/body/table/tbody")).getText().contains("HitCounter.jsp"));
        } finally {
            driver.quit();
        }

    }
}
