package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{Material,OrdenConstruccion}


object AdministradorMateriales {


  def recargaMateriales(  materiales: Material): Material = {
   materiales.copy(
        cemento = materiales.cemento + 500,
        grava = materiales.grava + 500,
        arena = materiales.arena + 500,
        madera = materiales.madera + 500,
        adobe = materiales.adobe + 500)
  }

  def descontarMaterial( ordenConstruccion: OrdenConstruccion, materiales: Material): Material ={
  materiales.copy( cemento = materiales.cemento - ordenConstruccion.tipoConstruccion.get.cemento,
    grava = materiales.grava - ordenConstruccion.tipoConstruccion.get.grava,
    adobe = materiales.adobe - ordenConstruccion.tipoConstruccion.get.adobe,
    madera = materiales.madera - ordenConstruccion.tipoConstruccion.get.madera,
    arena = materiales.arena - ordenConstruccion.tipoConstruccion.get.arena)
  }
}