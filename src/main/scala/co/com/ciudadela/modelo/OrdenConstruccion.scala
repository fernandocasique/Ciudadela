package co.com.ciudadela.modelo

import java.util.Calendar


case class Coordenada(ejeX: Int, ejeY: Int)

case class OrdenConstruccion (tipoConstruccion: TipoConstruccion = null,
                              estadoOrden: EstadoOrden = Pendiente(),
                              coordenada: Coordenada = null,
                              fechaInicio: Calendar = null,
                              plazo: Int = 0)
