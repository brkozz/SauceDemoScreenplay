package com.saucedemo.main.task;

import com.saucedemo.main.userinterfaces.CartPage;
import com.saucedemo.main.userinterfaces.PrincipalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProcesoDeCompra implements Task {
    private final String nombre;
    private final String apellido;
    private final String codigoZip;

    public ProcesoDeCompra(String nombre, String apellido, String codigoZip) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoZip = codigoZip;
    }

    public static Performable deFormaExitosa(String firstName, String lastName, String zipCode) {
        return instrumented(ProcesoDeCompra.class, firstName, lastName, zipCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PrincipalPage.BTN_CART),
                Click.on(CartPage.BTN_CHECKOUT),
                Enter.theValue(nombre).into(CartPage.INPUT_FIRST_NAME),
                Enter.theValue(apellido).into(CartPage.INPUT_FIRST_LASTNAME),
                Enter.theValue(codigoZip).into(CartPage.INPUT_ZIP),
                Click.on(CartPage.BTN_CONTINUE),
                Click.on(CartPage.BTN_FINISH)
        );
    }
}
