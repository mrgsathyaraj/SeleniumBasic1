package com.sel1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.Select;

public class SeleniumLearning1Basic {


    public static void main(String[] args) throws InterruptedException {

        //Login or Register Init the Page

        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/");
        driver.findElement(By.id("email")).sendKeys("mrgsathyaraj12@gmail.com");
        driver.findElement(By.id("enterimg")).click();
        String PageTitle =  driver.getTitle();

        //Register User
        if(PageTitle.equalsIgnoreCase("Register"))
        {
            System.out.println("New User");
            Thread.sleep(2000);
            driver.manage().window().maximize();
            WebElement fileInput = driver.findElement(By.id("imagesrc"));
            fileInput.sendKeys("C:\\Users\\Warrior\\Desktop\\nature.png");
            driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys("Sathya");
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


    }
}
