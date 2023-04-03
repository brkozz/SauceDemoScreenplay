package com.saucedemo.main.hooks;

import com.saucedemo.main.exceptions.ExceptionLoadProperties;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SaucedemoHooks {
    static Properties properties = new Properties();

    @Before
    public void setUpOneStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    @Before
    public void onStage() {
        try (FileReader reader = new FileReader("src/test/resources/general.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            throw new ExceptionLoadProperties("Error en cargar el archivo de propiedades", e);
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
