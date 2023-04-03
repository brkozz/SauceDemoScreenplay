package com.saucedemo.main.questions;

import com.saucedemo.main.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RespuestaConfirmacionCompra implements Question<Boolean> {
    private final String mensaje;

    public RespuestaConfirmacionCompra(String mensaje) {
        this.mensaje = mensaje;
    }

    public static Question<Boolean> delMensaje(String mensaje) {
        return new RespuestaConfirmacionCompra(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return mensaje.equals(CartPage.TITLE_CONFIRMATION.resolveFor(actor).getText());
    }
}
