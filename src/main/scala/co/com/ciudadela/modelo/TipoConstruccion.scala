package co.com.ciudadela.modelo

sealed trait TipoConstruccion {

  val cemento: Int
  val grava: Int
  val arena: Int
  val madera: Int
  val adobe: Int
  val tiempo: Int

}
/**/
case class Casa(cemento: Int = 100, grava: Int = 50, arena: Int = 90, madera: Int = 20, adobe: Int = 100, tiempo: Int = 3) extends TipoConstruccion

case class Lago(cemento: Int = 50, grava: Int = 60, arena: Int = 80, madera: Int = 10, adobe: Int = 20, tiempo: Int = 2) extends TipoConstruccion

case class CanchaFutbol(cemento: Int = 20, grava: Int = 20, arena: Int = 20, madera: Int = 20, adobe: Int = 20, tiempo: Int = 1) extends TipoConstruccion

case class Edificio(cemento: Int = 200, grava: Int = 100, arena: Int = 180, madera: Int = 40, adobe: Int = 200, tiempo: Int = 6) extends TipoConstruccion

case class Gimnasio(cemento: Int = 50, grava: Int = 25, arena: Int = 45, madera: Int = 10, adobe: Int = 50, tiempo: Int = 2) extends TipoConstruccion

