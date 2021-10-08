package co.com.ciudadela.vista

import co.com.ciudadela.controlador.{AdministradorCiudadela, AdministradorMateriales}
import co.com.ciudadela.modelo.{Ciudadela, Coordenada, OrdenConstruccion}
import com.sun.prism.Material

import java.awt.peer.MenuPeer

object MenuConsultar {

  def menuInforme(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={
    println("___ Menú de Informes ___\n")
    println("Digite:  \n 1. Para consultar las ordenes de construción \n 2. Para consultar fecha de finalización del proyecto \n _. En caso de precionar otra tecla volverá al menú principal")
    val comando  = scala.io.StdIn.readLine()
    comando match {
      case "1" => Imprimir.mostrarSolicitudOrdenes( ordenConstruccion, ciudadela)
      case "2" =>
        val ciudadelaAct = AdministradorCiudadela.calculaFechaCulminacion(ciudadela)
        Imprimir.mostrarFechaCulminación(ordenConstruccion, ciudadelaAct)
      case _ => MenuPrincipal.menuPrincipal(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela)
    }
  }








}
