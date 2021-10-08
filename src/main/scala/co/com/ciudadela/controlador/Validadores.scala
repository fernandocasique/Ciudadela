package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}


trait Validadores {
  def validarMateriales(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Boolean ={
    (ciudadela.materiales.cemento < ordenConstruccion.tipoConstruccion.cemento ||
      ciudadela.materiales.grava < ordenConstruccion.tipoConstruccion.grava ||
      ciudadela.materiales.adobe < ordenConstruccion.tipoConstruccion.adobe ||
      ciudadela.materiales.madera < ordenConstruccion.tipoConstruccion.madera ||
      ciudadela.materiales.arena < ordenConstruccion.tipoConstruccion.arena
    )
  }

  def verificarEstadoProyecto(ciudadela: Ciudadela): Boolean = ciudadela.solicitudesOrdenes.isEmpty


  def validarCoordenadas(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Boolean ={
      verificarCoordenadas(ciudadela.solicitudesOrdenes.map(ord => valid(ord, ordenConstruccion)))
  }

  def valid (ord: OrdenConstruccion, ordenConstruccion: OrdenConstruccion): Boolean ={
    ord.coordenada.ejeX != ordenConstruccion.coordenada.ejeX && ord.coordenada.ejeY != ordenConstruccion.coordenada.ejeY
  }

  def verificarCoordenadas(listaComparacionCoordenadas: List[Boolean]): Boolean ={
    listaComparacionCoordenadas.contains(false)
  }
}
object Validadores extends Validadores