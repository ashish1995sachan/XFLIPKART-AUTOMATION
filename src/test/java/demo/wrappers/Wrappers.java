package demo.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void searchbox(WebDriver driver, String search){
        WebElement SearchBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        SearchBox.clear();
        SearchBox.sendKeys(search);
    }

    public static void searchButton(WebDriver driver){
        WebElement SearchButton = driver.findElement(By.xpath("//button[@class='_2iLD__']"));
        SearchButton.click();
    }


    public static void Reviewbox(WebDriver driver, String search){
    WebElement reviewBox = driver.findElement(By.xpath("//div[text()='" + search + "'"));
    reviewBox.sendKeys(search);


    // public static void startBox(WebDriver driver , String star){
    //     WebElement starBox = driver.findElement(By.xpath());
    // }
}
}
