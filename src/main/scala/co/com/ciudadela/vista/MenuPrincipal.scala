package co.com.ciudadela.vista

import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}
import co.com.ciudadela.vista.MenuConsultar.{menuInforme}

object MenuPrincipal {
  def menuPrincipal( ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={
    println("___ Menú Principal ___\n")
    println("Digite:  \n 1. Para ir al menu de materiales \n 2. Para hacer una solicitud de construcción \n 3. Para ir al menu de informes \n 4. Para actualizar estados \n _. Cualquier otro digito para volver al menú principal")
    val comando  = scala.io.StdIn.readLine()
    comando match {
      case "1" => MenuMateriales.menuMateriales(ordenConstruccion, ciudadela)
      case "2" => MenuSolicitud.menuTipoConstruccion( ordenConstruccion, ciudadela)
      case "3" => menuInforme( ordenConstruccion, ciudadela)
      case "4" => MenuEstado.menuCambioEstado( ciudadela, ordenConstruccion)
      case _ => menuPrincipal(ordenConstruccion,ciudadela)
    }
  }
}
