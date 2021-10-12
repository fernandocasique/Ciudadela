package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{Ciudadela, EnProgreso, OrdenConstruccion, Pendiente}

import java.util.{Calendar}

object AdministradorCiudadela {

  def calcularPlazoCiudadela(ciudadela: Ciudadela): Int ={
    ciudadela.solicitudesOrdenes.map(orden => orden.tipoConstruccion.get.tiempo).sum
  }

  def calcularPlazoOrden(ciudadela: Ciudadela, ordenConstruccion: OrdenConstruccion): Int ={
    ciudadela.solicitudesOrdenes.map(orden => orden.tipoConstruccion.get.tiempo).sum + ordenConstruccion.tipoConstruccion.get.tiempo
  }

  def calculaFechaCulminacion(ciudadela: Ciudadela): Ciudadela ={
    EstadoCiudadela.estadoCiudadela(ciudadela) match {
      case true => ciudadela.copy(plazoEntrega = calcularPlazoCiudadela(ciudadela))
      case false => val fecha = ciudadela.fechaInicio
        val plazoProyecto = calcularPlazoCiudadela(ciudadela)
        fecha.add(Calendar.DAY_OF_YEAR, plazoProyecto)
        ciudadela.copy(fechaFin = Some(fecha.getTime()), plazoEntrega = calcularPlazoCiudadela(ciudadela))}
    }

  def estadoSolicitudes(ciudadela: Ciudadela, ordenConstruccion: OrdenConstruccion): OrdenConstruccion = {
    EstadoCiudadela.estadoCiudadela(ciudadela) match {
      case true => ordenConstruccion.copy(estadoOrden = EnProgreso(),  plazo = calcularPlazoCiudadela(ciudadela) + ordenConstruccion.tipoConstruccion.get.tiempo)
      case false => ordenConstruccion.copy( estadoOrden = Pendiente(), plazo = calcularPlazoCiudadela(ciudadela) + ordenConstruccion.tipoConstruccion.get.tiempo)
    }
  }


}

