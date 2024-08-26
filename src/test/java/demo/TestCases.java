package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.util.logging.Level;
import java.time.Duration;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import dev.failsafe.internal.util.Durations;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;

public class TestCases {
     ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     @Test
     public void testCase01() throws InterruptedException{
     System.out.println("Start of Test Case 01");  
     driver.get("http://www.flipkart.com/");   
     WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='Pke_EE']")));
     Wrappers.searchbox(driver,"Washing Machine");
     Wrappers.searchButton(driver);
     WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
     wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Popularity']")));
     WebElement popularity = driver.findElement(By.xpath("//div[text()='Popularity']"));
     popularity.click();
     int count = 0;
     Thread.sleep(2000);
     List <WebElement> list1 = driver.findElements(By.xpath("//div[@class='XQDdHH']"));
     for (WebElement review : list1){
        Thread.sleep(500);
        
        String reviewStar = review.getText();
        float review1 = Float.parseFloat(reviewStar);
        if(review1 <= 4.0){
         count++;
        }
     }
      System.out.println("the count of items with rating less than or equal to 4 stars :" + count);
      System.out.println("End of Test Case 01");
   }

     @Test
     public void testCase02() throws InterruptedException{
     System.out.println("Start of Test Case 02");
     driver.get("http://www.flipkart.com/");
     Thread.sleep(2000);
     WebElement login = driver.findElement(By.xpath("//div[@class='_17UxrZ']"));
     if(login.isDisplayed()){
        WebElement closeIt = driver.findElement(By.xpath("//span[@class='_30XB9F']"));
        closeIt.click();
     }
     Wrappers.searchbox(driver,"iPhone");
     Thread.sleep(3000);
     Wrappers.searchButton(driver);
     List <WebElement> discountList = driver.findElements(By.xpath("//div[@class='yKfJKb row']//div[@class='col col-5-12 BfVC2z']//div[@class='UkUFwK']"));
     for (WebElement discountBox : discountList){
        Thread.sleep(2000);
        if(discountBox.isDisplayed()){
        String discount = discountBox.getText();
        String[] dis = discount.split(" ");
        String intValue = dis[0].replaceAll("[^0-9]", "");
        int discountValue = Integer.parseInt(intValue);
   
        
        if(discountValue > 17){
         System.out.println("Discount= " + discountValue);
         WebElement Title = driver.findElement(By.xpath("//span[text()='" + discountValue +"% off']//parent::div[@class='UkUFwK']//parent::div//ancestor::div[@class='col col-5-12 BfVC2z']//preceding-sibling::div//child::div[@class='KzDlHZ']"));
         String productTitle = Title.getText();
         System.out.println("Title of Product : " + productTitle );
         System.out.println("Discount on the Product is : " + discountValue+"%" );
        }
       }
     }
     System.out.println("End of Test Case 02");
     }

     @Test
     public void testCase03() throws InterruptedException{
     System.out.println("Start of Test Case 03");
     driver.get("http://www.flipkart.com/");
     Thread.sleep(2000);
   //   WebElement login = driver.findElement(By.xpath("//div[@class='_17UxrZ']"));
   //   if(login.isDisplayed()){
   //      WebElement closeIt = driver.findElement(By.xpath("//span[@class='_30XB9F']"));
   //      closeIt.click();
   //   }
     Wrappers.searchbox(driver,"Coffee Mug");
     Thread.sleep(3000);
     Wrappers.searchButton(driver);
     WebElement clickBox = driver.findElement(By.xpath("//div[contains(text(),'4')]//preceding-sibling::div[@class='XqNaEv']"));
     clickBox.click();
     Thread.sleep(3000);
     List<WebElement> ReviewNumber=driver.findElements(By.xpath("//span[@class='Wphh3N']"));
     ArrayList<Integer> reviewValue = new ArrayList<Integer>(ReviewNumber.size());
     for (WebElement reviews : ReviewNumber){
        String review = reviews.getText();
        String intValue = review.replaceAll("[^0-9]", "");
        int reviewNo = Integer.parseInt(intValue);
        reviewValue.add(reviewNo);
    
     }
     Collections.sort(reviewValue,Collections.reverseOrder());
     for(int i = 0; i < 5 ; i++){
        int mod = reviewValue.get(i);
        System.out.println(mod);
        int num =mod % 1000;
        System.out.println(num);
        
        WebElement productTitle2 = driver.findElement(By.xpath("//span[contains(text(),'" + num + "')]//ancestor::div[@class='slAVV4']//descendant::a[@class='wjcEIp']"));
        String productTitle3 = productTitle2.getText();
        System.out.println("Title of Product : " + productTitle3 );
        WebElement imageUrl = driver.findElement(By.xpath("//span[contains(text(),'" + num + "')]//ancestor::div[@class='slAVV4']//ancestor::div[@class='_4WELSP']//child::img[@class='DByuf4']"));
        String imageUrl1 = imageUrl.getAttribute("src");
        System.out.println("Url of the image of the Product is : " + imageUrl1 );
     }
     System.out.println("End of Test Case 03");
     }
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
    }

    @AfterTest
    public void endTest()
    {
        // driver.close();
         //driver.quit();

    }
}