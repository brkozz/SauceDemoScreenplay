package com.saucedemo.main.task;

import com.saucedemo.main.userinterfaces.PrincipalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarProducto implements Task {
    private final String producto;

    public SeleccionarProducto(String producto) {
        this.producto = producto;
    }

    public static Performable conNombre(String producto) {
        return instrumented(SeleccionarProducto.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PrincipalPage.PRODUCT.of(producto)),
                Click.on(PrincipalPage.BTN_ADD_PRODUCT)
        );
    }
}
