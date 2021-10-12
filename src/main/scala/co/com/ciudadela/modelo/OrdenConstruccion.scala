package co.com.ciudadela.modelo




case class Coordenada(ejeX: Int, ejeY: Int)

case class OrdenConstruccion (tipoConstruccion: Option[TipoConstruccion],
                              coordenada: Option[Coordenada],
                              plazo: Int = 0,
                              estadoOrden: EstadoOrden = Pendiente())
