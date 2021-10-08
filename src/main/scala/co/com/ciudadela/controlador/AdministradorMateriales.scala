package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{ Materiales, OrdenConstruccion}


object AdministradorMateriales {


  def recargaMateriales(  materiales: Materiales): Materiales = {
   materiales.copy(
        cemento = materiales.cemento + 500,
        grava = materiales.grava + 500,
        arena = materiales.arena + 500,
        madera = materiales.madera + 500,
        adobe = materiales.adobe + 500)
  }

  def descontarMaterial( ordenConstruccion: OrdenConstruccion, materiales: Materiales): Materiales ={
  materiales.copy( cemento = materiales.cemento - ordenConstruccion.tipoConstruccion.cemento,
    grava = materiales.grava - ordenConstruccion.tipoConstruccion.grava,
    adobe = materiales.adobe - ordenConstruccion.tipoConstruccion.adobe,
    madera = materiales.madera - ordenConstruccion.tipoConstruccion.madera,
    arena = materiales.arena - ordenConstruccion.tipoConstruccion.arena)
  }
}