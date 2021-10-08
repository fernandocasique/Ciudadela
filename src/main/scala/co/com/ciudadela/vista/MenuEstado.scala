package co.com.ciudadela.vista

import co.com.ciudadela.controlador.ActualizarEstado
import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}

object MenuEstado {

  def menuCambioEstado(ciudadela: Ciudadela, ordenConstruccion: OrdenConstruccion): Unit = {
    val ciudadelaAct = ActualizarEstado.actualizarEstado(ciudadela)
    Imprimir.imprimirEstadosAct( ordenConstruccion, ciudadelaAct)
  }


}
