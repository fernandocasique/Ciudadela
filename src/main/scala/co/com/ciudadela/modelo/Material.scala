package co.com.ciudadela.modelo

trait Material {
  val cemento: Int
  val grava: Int
  val arena: Int
  val madera: Int
  val adobe: Int
}

case class Materiales(  cemento: Int = 80, grava: Int = 100, arena: Int = 100, madera: Int = 100, adobe: Int = 100) extends Material




