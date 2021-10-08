package co.com.ciudadela.controlador

import co.com.ciudadela.controlador.AdministradorCiudadela.calcularPlazoCiudadela
import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}

trait RegistrarSolicitud {
  def guardarSolicitud(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Ciudadela= {
    ciudadela.copy( solicitudesOrdenes = ciudadela.solicitudesOrdenes:+ordenConstruccion, plazoEntrega = calcularPlazoCiudadela(ciudadela))
  }
}
object RegistrarSolicitud extends RegistrarSolicitud
