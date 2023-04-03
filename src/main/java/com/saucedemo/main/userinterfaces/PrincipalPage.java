package com.saucedemo.main.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PrincipalPage {
    private PrincipalPage() {

    }

    public static final Target SPAN_PRODUCTS = Target.the("span de validacion de pagina principal").
            locatedBy("//span[contains(text(),'Products')]");
    public static final Target PRODUCT = Target.the("producto de la lista").
            locatedBy("//div[@class='inventory_item_name' and text()='{0}']");
    public static final Target BTN_ADD_PRODUCT = Target.the("boton para agregar al carrito").
            locatedBy(".btn_primary.btn_inventory");
    public static final Target BTN_CART = Target.the("boton de carrito de compras")
            .locatedBy("//a[@class='shopping_cart_link']");

}
