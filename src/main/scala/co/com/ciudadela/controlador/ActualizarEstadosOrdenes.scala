package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{Ciudadela, EnProgreso, OrdenConstruccion, Pendiente, Terminado}

import java.time.{LocalDate, Period}

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
    val fechaAct = LocalDate.now
    Period.between(ciudadela.fechaInicio, fechaAct).getDays()
  }


}
object ActualizarEstadosOrdenes extends ActualizarEstadosOrdenes