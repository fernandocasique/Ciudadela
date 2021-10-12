package co.com.ciudadela.vista

import co.com.ciudadela.controlador.ActualizarEstadosOrdenes
import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}

object MenuEstado {

  def menuCambioEstado(ciudadela: Ciudadela, ordenConstruccion: OrdenConstruccion): Unit = {
    val ciudadelaAct = ActualizarEstadosOrdenes.actualizarEstado(ciudadela)
    Imprimir.imprimirEstadosAct( ordenConstruccion, ciudadelaAct)
  }


}
