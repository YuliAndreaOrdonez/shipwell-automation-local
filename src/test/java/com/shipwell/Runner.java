package com.shipwell;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"classpath:com/shipwell/features/"},
        glue = {"com.shipwell.definitions"},
        tags =  "@test")
public class Runner {

}
