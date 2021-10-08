package co.com.ciudadela.controlador

import co.com.ciudadela.modelo.{Ciudadela, EnProgreso, OrdenConstruccion, Pendiente}

import java.util.{Calendar}

object AdministradorCiudadela {

  def calcularPlazoCiudadela(ciudadela: Ciudadela): Int ={
    ciudadela.solicitudesOrdenes.map(orden => orden.tipoConstruccion.tiempo + 1).sum
  }

  def calculaFechaCulminacion(ciudadela: Ciudadela): Ciudadela ={
    if(ciudadela.solicitudesOrdenes.isEmpty) ciudadela.copy(plazoEntrega = calcularPlazoCiudadela(ciudadela))
    else {
    val fecha = ciudadela.fechaInicio
    val plazoProyecto = calcularPlazoCiudadela(ciudadela)
    fecha.add(Calendar.DAY_OF_YEAR, plazoProyecto)
    ciudadela.copy(fechaFin = fecha.getTime(), plazoEntrega = calcularPlazoCiudadela(ciudadela))}
  }

def estadoSolicitudes(ciudadela: Ciudadela, ordenConstruccion: OrdenConstruccion): OrdenConstruccion ={
  val fechaInicioOrde = Calendar.getInstance()
  if(ciudadela.solicitudesOrdenes.isEmpty) ordenConstruccion.copy(estadoOrden = EnProgreso(), fechaInicio = fechaInicioOrde, plazo = calcularPlazoCiudadela(ciudadela) + ordenConstruccion.tipoConstruccion.tiempo)
  else  ordenConstruccion.copy( fechaInicio = fechaInicioOrde, estadoOrden = Pendiente() , plazo = calcularPlazoCiudadela(ciudadela))
}
}
