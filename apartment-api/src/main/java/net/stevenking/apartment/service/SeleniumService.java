package net.stevenking.apartment.service;

import net.stevenking.apartment.data.Apartment;
import net.stevenking.apartment.data.FloorPlan;
import net.stevenking.apartment.repository.FloorPlanRepository;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SeleniumService {

    @Autowired
    FloorPlanRepository floorPlanRepository;

    public List<Apartment> fetchNewPrice(FloorPlan floorPlan) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        Capabilities cap = DesiredCapabilities.chrome();
        ((DesiredCapabilities) cap).setPlatform(org.openqa.selenium.Platform.WINDOWS);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("test-type"));
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(floorPlan.getUrl());

        WebElement element = driver.findElement(By.cssSelector("[data-selenium-id=\"Rent1\"]"));

        Apartment apartment = new Apartment();
        apartment.setPrice(Short.valueOf(element.getText()));
        apartment.setFloorPlan(floorPlan);
        System.out.println(apartment.getPrice());

        driver.close();
        driver.quit();
    }
}
