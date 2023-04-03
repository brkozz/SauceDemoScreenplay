package com.saucedemo.main.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    private CartPage() {

    }

    public static final Target BTN_CHECKOUT = Target.the("boton para iniciar el checkout").
            locatedBy("//button[@id='checkout']");
    public static final Target INPUT_FIRST_NAME = Target.the("input para ingresar el primer nombre").
            locatedBy("//input[@id='first-name']");
    public static final Target INPUT_FIRST_LASTNAME = Target.the("input para ingresar el apellido").
            locatedBy("//input[@id='last-name']");
    public static final Target INPUT_ZIP = Target.the("input para ingresar el codigo zip").
            locatedBy("//input[@id='postal-code']");
    public static final Target BTN_CONTINUE = Target.the("boton para continuar checkout").
            locatedBy("//input[@id='continue']");
    public static final Target BTN_FINISH = Target.the("boton para finalizar con la compra").
            locatedBy("//button[@id='finish']");
    public static final Target TITLE_CONFIRMATION = Target.the("titulo que muesta la confirmacion de la compra").
            locatedBy("//h2[@class='complete-header']");
}
