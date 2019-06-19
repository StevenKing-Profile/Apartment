package net.stevenking.apartment.service;

import net.stevenking.apartment.data.Apartment;
import net.stevenking.apartment.data.FloorPlan;
import net.stevenking.apartment.repository.FloorPlanRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class SeleniumService {

    @Autowired
    FloorPlanRepository floorPlanRepository;

    public void fetchNewPrice() throws MalformedURLException {
        List<FloorPlan> floorPlanList = floorPlanRepository.findAll();
        URL local = new URL("http://localhost:9515");
        for (FloorPlan fp : floorPlanList) {
            Apartment apartment = new Apartment();
            WebDriver driver = new RemoteWebDriver(local, DesiredCapabilities.chrome());
            driver.get(fp.getUrl());
            WebElement element = driver.findElement(By.cssSelector("[data-selenium-id=\"Rent1\"]"));
            apartment.setPrice(Short.valueOf(element.getText()));

            System.out.println(apartment.getPrice());
        }
    }
}
