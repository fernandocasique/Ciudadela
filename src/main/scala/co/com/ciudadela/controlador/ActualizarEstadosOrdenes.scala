package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{Ciudadela, EnProgreso, OrdenConstruccion, Pendiente, Terminado}

import java.util.Calendar

trait ActualizarEstadosOrdenes {

  def actualizarEstado(ciudadela: Ciudadela): Ciudadela = {
    EstadoCiudadela.estadoCiudadela (ciudadela) match {
      case true => ciudadela
      case false =>  val tiempoTrancurrido = tiempoTranscurridoInicioCiudadela(ciudadela)
        ciudadela.copy(solicitudesOrdenes = ciudadela.solicitudesOrdenes.map(ordenConst => cambiarEstado(ordenConst, tiempoTrancurrido)))
    }

  }

  def cambiarEstado(ordenConstruccion: OrdenConstruccion, tiempoTranscurrido: Int): OrdenConstruccion = {
   ordenConstruccion match {
      case _  if(tiempoTranscurrido > ordenConstruccion.plazo) =>  ordenConstruccion.copy(estadoOrden = Terminado())
      case _  if( ordenConstruccion.plazo >= tiempoTranscurrido && tiempoTranscurrido >= (ordenConstruccion.plazo - ordenConstruccion.tipoConstruccion.get.tiempo)) => ordenConstruccion.copy(estadoOrden = EnProgreso())
      case _ => ordenConstruccion.copy(estadoOrden = Pendiente())
    }
  }

  def tiempoTranscurridoInicioCiudadela(ciudadela: Ciudadela): Int = {
      val fechaAct = Calendar.getInstance()
      fechaAct.get(Calendar.DAY_OF_YEAR) - ciudadela.fechaInicio.get(Calendar.DAY_OF_YEAR)
  }


}
object ActualizarEstadosOrdenes extends ActualizarEstadosOrdenes