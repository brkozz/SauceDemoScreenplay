package com.saucedemo.main.task;

import com.saucedemo.main.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarCredencialesInicioSesion implements Task {

    private final String usuario;
    private final String password;

    public IngresarCredencialesInicioSesion(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public static Performable conCredenciales(String sauceDemoUser, String sauceDemoPassword) {
        return instrumented(IngresarCredencialesInicioSesion.class, sauceDemoUser, sauceDemoPassword);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.INPUT_USERNAME),
                Enter.theValue(password).into(LoginPage.INPUT_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN)
        );
    }
}
