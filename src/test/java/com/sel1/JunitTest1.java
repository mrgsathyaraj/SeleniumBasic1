 package com.sel1;

import static org.junit.Assert.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

 public class JunitTest1 {

static WebDriver driver;

@BeforeAll

public static void initDriver()
{
   driver = new ChromeDriver();
   Assert.assertNotNull(driver);
   driver.manage().window().maximize();
   System.out.println("Driver Initialized");
}

@BeforeEach

public void LaunchPage()
{
    driver.get("http://demo.automationtesting.in/Register.html");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    String PageTitle =  driver.getTitle();
    Assert.assertEquals("Register",PageTitle);
    System.out.println("Launch Page Called");
}

@Test
public void Test_MethodTest()
{
    System.out.println("Test Annotation Runs Once");
}


@RepeatedTest(2)

public void Test_RepeatedTest()
{
    System.out.println("RepeatedTest Runs Two times as per the args passed as number");
}

static Stream<String> stringIntAndListProvider() {

    System.out.println(Stream.of(
            ("apple")));
        return Stream.of(
                ("apple")

        );
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void SignupformWithCompleteData(String FirstName){

    System.out.println("Test Started");

    WebElement fileInput = driver.findElement(By.id("imagesrc"));
    fileInput.sendKeys("C:\\Users\\Warrior\\Desktop\\nature.png");

    driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys(FirstName);
    driver.findElement(By.xpath("//input[@ng-model='LastName']")).sendKeys("Raj");
    driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Chennai,Salem,Kovai");
    driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("mrgsathyaraj12@gmail.com");
    driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("9876543210");
    driver.findElement(By.xpath("//input[@value='Male']")).click();
    driver.findElement(By.xpath("//input[@value='Cricket']")).click();
    driver.findElement(By.xpath("//input[@value='Movies']")).click();
    driver.findElement(By.xpath("//input[@value='Hockey']")).click();
    driver.findElement(By.xpath("//div[@class ='ui-autocomplete-multiselect ui-state-default ui-widget']")).click();
    driver.findElement(By.xpath("//a[text()='Arabic']")).click();
    driver.findElement(By.xpath("//a[text()='Dutch']")).click();
    Select Skills = new Select(driver.findElement(By.id("Skills")));
    Skills.selectByValue("Analytics");
    Select countries = new Select(driver.findElement(By.id("countries")));
    countries.selectByValue("Albania");
    driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']")).click();
    WebElement SelectCountry=  driver.findElement(By.xpath("//input[@class='select2-search__field']"));
    SelectCountry.sendKeys("India");
    SelectCountry.sendKeys(Keys.ENTER);
    Select yearbox = new Select(driver.findElement(By.id("yearbox")));
    yearbox.selectByValue("1995");
    Select monthbox = new Select(driver.findElement(By.xpath("//select[@ng-model='monthbox']")));
    monthbox.selectByValue("June");
    Select daybox = new Select(driver.findElement(By.id("daybox")));
    daybox.selectByValue("23");
    driver.findElement(By.id("firstpassword")).sendKeys("CheckWord@1");
    driver.findElement(By.id("secondpassword")).sendKeys("CheckWord@1");
    driver.findElement(By.id("submitbtn")).click();

}

@Disabled
public void ignoreMethod()
{
    System.out.println("This merthod should not be printed");
}

@AfterAll

    public static void cleanTest()
{
    driver.quit();
    System.out.println("Test Completed");
}

}
