package co.com.ciudadela.modelo

import java.time.LocalDate

case class Ciudadela(fechaFin: Option[LocalDate],
                     solicitudesOrdenes: List[OrdenConstruccion] = List(),
                     material: Material = Material(),
                     plazoEntrega: Int = 0,
                     fechaInicio: LocalDate,
                     arquitecto: Arquitecto = Arquitecto())

case class Arquitecto(identificacion: String = "123451", nombre: String = "Fernando Casique")
