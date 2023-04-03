package com.saucedemo.main.task;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GeneralSteps {

    private GeneralSteps() {

    }

    public static Performable llenarFormularioLogin() {
        return instrumented(LlenarFormularioLogin.class);
    }
}
