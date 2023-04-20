import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegAndLoginLoop {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i <= 15; i++) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://demo.nopcommerce.com/");

            //Register
            driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
            driver.findElement(By.id("gender-male")).click();
            driver.findElement(By.id("FirstName")).sendKeys("Software");
            driver.findElement(By.id("LastName")).sendKeys("Testing");
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")).sendKeys("7");
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]")).sendKeys("August");
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]")).sendKeys("2000");
            driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("Homework" + i + "@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("Testing123");
            driver.findElement(By.id("ConfirmPassword")).sendKeys("Testing123");
            driver.findElement(By.id("register-button")).click();
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a")).click();
            System.out.println("Registered with Testing" + i + "@gmail.com");
            //Login
            driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
            driver.findElement(By.id("Email")).sendKeys("Homework" + i + "@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("Testing123");
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
            driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
            System.out.println("Login Successfully");
            driver.close();
            Thread.sleep(2000);

        }
    }
}
