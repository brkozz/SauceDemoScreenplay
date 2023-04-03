package com.saucedemo.main.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    private LoginPage() {

    }

    public static final Target INPUT_USERNAME = Target.the("input para ingresar username").
            locatedBy("//input[@id='user-name']");
    public static final Target INPUT_PASSWORD = Target.the("input para ingresar contrasena").
            locatedBy("//input[@id='password']");
    public static final Target BTN_LOGIN = Target.the("boton para iniciar sesion").
            locatedBy("//input[@id='login-button']");

}
