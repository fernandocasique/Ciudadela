package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{Ciudadela, EnProgreso, OrdenConstruccion, Pendiente, Terminado}

import java.util.Calendar

trait ActualizarEstado {

  def actualizarEstado(ciudadela: Ciudadela): Ciudadela = {
    if (ciudadela.solicitudesOrdenes.isEmpty || ciudadela.solicitudesOrdenes == 1) ciudadela
    else {
      val tiempoTrancurrido = tiempoTranscurridoInicioCiudadela(ciudadela)
      ciudadela.copy(solicitudesOrdenes = ciudadela.solicitudesOrdenes.map(ordenConst => cambiarEstado(ordenConst, tiempoTrancurrido)))
    }}

    def cambiarEstado(ordenConstruccion: OrdenConstruccion, tiempoTranscurrido: Int): OrdenConstruccion = {
      if (tiempoTranscurrido > ordenConstruccion.plazo) {
        ordenConstruccion.copy(estadoOrden = Terminado())
      }
      if (ordenConstruccion.plazo >= tiempoTranscurrido  && tiempoTranscurrido <= (ordenConstruccion.plazo - ordenConstruccion.tipoConstruccion.tiempo)) {
        ordenConstruccion.copy(estadoOrden = EnProgreso())
      }else{
        ordenConstruccion.copy(estadoOrden = Pendiente())
      }
      ordenConstruccion
    }

    def tiempoTranscurridoInicioCiudadela(ciudadela: Ciudadela): Int = {
      val fechaAct = Calendar.getInstance()
      fechaAct.get(Calendar.DAY_OF_YEAR) - ciudadela.fechaInicio.get(Calendar.DAY_OF_YEAR)
    }

}
object ActualizarEstado extends ActualizarEstado