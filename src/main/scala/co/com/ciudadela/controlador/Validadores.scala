package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}


trait Validadores {
  def validarMateriales(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Boolean ={
    (ciudadela.material.cemento < ordenConstruccion.tipoConstruccion.get.cemento ||
      ciudadela.material.grava < ordenConstruccion.tipoConstruccion.get.grava ||
      ciudadela.material.adobe < ordenConstruccion.tipoConstruccion.get.adobe ||
      ciudadela.material.madera < ordenConstruccion.tipoConstruccion.get.madera ||
      ciudadela.material.arena < ordenConstruccion.tipoConstruccion.get.arena
    )
  }

  def verificarEstadoProyecto(ciudadela: Ciudadela): Boolean = ciudadela.solicitudesOrdenes.isEmpty


  def validarCoordenadas(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Boolean ={
      verificarCoordenadas(ciudadela.solicitudesOrdenes.map(ord => validarCoordenadasOrdenes(ord, ordenConstruccion)))
  }

  def validarCoordenadasOrdenes (ord: OrdenConstruccion, ordenConstruccion: OrdenConstruccion): Boolean ={
    ord.coordenada.get.ejeX != ordenConstruccion.coordenada.get.ejeX && ord.coordenada.get.ejeY != ordenConstruccion.coordenada.get.ejeY
  }

  def verificarCoordenadas(listaComparacionCoordenadas: List[Boolean]): Boolean ={
    listaComparacionCoordenadas.contains(false)
  }
}
object Validadores extends Validadores