package com.saucedemo.main.stepdfinitios;

import com.saucedemo.main.hooks.SaucedemoHooks;
import com.saucedemo.main.models.UsuarioDatos;
import com.saucedemo.main.questions.RespuestaConfirmacionCompra;
import com.saucedemo.main.task.IngresarCredencialesInicioSesion;
import com.saucedemo.main.task.ProcesoDeCompra;
import com.saucedemo.main.task.SeleccionarProducto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompraStepDefinitions {

    @Given("^que estoy en la pagina de inicio de sesion de SauceDemo$")
    public void queEstoyEnLaPaginaDeInicioDeSesionDeSauceDemo() {
        theActorInTheSpotlight().attemptsTo(
                Open.url(SaucedemoHooks.getProperties().getProperty("sauceDemoURL"))
        );
    }

    @When("^ingreso mis credenciales de inicio de sesion$")
    public void ingresoMisCredencialesDeInicioDeSesion() {
        theActorInTheSpotlight().attemptsTo(
                IngresarCredencialesInicioSesion.conCredenciales(
                        SaucedemoHooks.getProperties().getProperty("sauceDemoUser"),
                        SaucedemoHooks.getProperties().getProperty("sauceDemoPassword")
                )
        );
    }

    @And("^selecciono un producto para comprar$")
    public void seleccionoUnProductoParaComprar() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarProducto.conNombre("Sauce Labs Bike Light")
        );
    }

    @And("^completo el proceso de compra$")
    public void completoElProcesoDeCompra() {
        theActorInTheSpotlight().attemptsTo(
                ProcesoDeCompra.deFormaExitosa(UsuarioDatos.FIRST_NAME, UsuarioDatos.LAST_NAME, UsuarioDatos.ZIP_CODE)
        );
    }

    @Then("^se muestra \"([^\"]*)\" de confirmacion de compra exitosa$")
    public void seMuestraSomethingDeConfirmacionDeCompraExitosa(String valor) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Contiene: ", RespuestaConfirmacionCompra.delMensaje(valor))
        );
    }
}
