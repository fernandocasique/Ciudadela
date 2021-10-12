package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.Ciudadela

trait EstadoCiudadela {
  def estadoCiudadela(ciudadela: Ciudadela):Boolean = {
    ciudadela.solicitudesOrdenes.isEmpty
  }
}
object EstadoCiudadela extends EstadoCiudadela