#Author: Brandon

Feature: Prueba de compra en SauceDemo

  Scenario: Realizar compra
    Given que estoy en la pagina de inicio de sesion de SauceDemo
    When ingreso mis credenciales de inicio de sesion
    And selecciono un producto para comprar
    And completo el proceso de compra
    Then se muestra "Thank you for your order!" de confirmacion de compra exitosa