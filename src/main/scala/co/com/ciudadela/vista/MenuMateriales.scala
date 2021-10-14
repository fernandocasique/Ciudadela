package co.com.ciudadela.vista

import co.com.ciudadela.controlador.AdministradorMateriales
import co.com.ciudadela.controlador.AdministradorMateriales.recargaMateriales
import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}

object MenuMateriales {
  def menuMateriales( ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={
    println("___ Menú de Materiales ___\n")
    println(" Digite => \n 1. Para ver materiales \n 2. Para recargar 500 por cada material \n _. Cualquier otro digito para regresar")
    val comando  = scala.io.StdIn.readLine()
    controladorMateriales(comando, ordenConstruccion, ciudadela)
  }

  def controladorMateriales(comando: String, ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Any = {
    comando match {
      case "1" => Imprimir.imprimirMateriales(ordenConstruccion, ciudadela)
      case "2" => val materialesAct = recargaMateriales(ciudadela.material)
        Imprimir.imprimirRecargaExitosa(ordenConstruccion,ciudadela.copy(material = materialesAct))
      case _ =>  MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
    }
  }
}
