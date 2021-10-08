package co.com.ciudadela.modelo

 sealed trait EstadoOrden

case class Pendiente() extends EstadoOrden

case class Terminado() extends EstadoOrden

case class EnProgreso() extends EstadoOrden
