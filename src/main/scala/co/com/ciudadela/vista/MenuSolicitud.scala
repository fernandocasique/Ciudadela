package co.com.ciudadela.vista

import co.com.ciudadela.controlador.{AdministradorCiudadela, AdministradorMateriales, RegistrarSolicitud, Validadores}
import co.com.ciudadela.modelo.{CanchaFutbol, Casa, Ciudadela, Coordenada, Edificio, Gimnasio, Lago, OrdenConstruccion}

object MenuSolicitud {

  def  menuTipoConstruccion(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={
    println("___ Solicitud Orden de construccion ___\n")
    println("Digite => \n 1. Para construir una casa \n 2.  Para construir una lago \n 3.  Para construir una Cancha de Futbol " +
      "\n 4.  Para construir un edificio \n 5.  Para construir un gymnasio \n  _. Cualquier otro digito para volver al menú Principal")
    val comandoTipoConstruccion  = scala.io.StdIn.readLine()
    controladorOrden(comandoTipoConstruccion,ordenConstruccion, ciudadela )
  }

def digitarCoordenadasConstruccion( ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela ): Unit ={
  println("Digite la coordenada de construccion en el eje X")
  val ejeX  = scala.io.StdIn.readInt()
  println("Digite la coordenada de construccion en el eje Y")
  val ejeY  = scala.io.StdIn.readInt()
  ejecutarSolicitudOrden(ordenConstruccion.copy( coordenada = Some(Coordenada(ejeX, ejeY))), ciudadela)
}

  def controladorOrden(comando: String, ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={
    comando match {
      case "1" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion = Some(Casa())), ciudadela)
      case "2" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion =  Some(Lago())), ciudadela)
      case "3" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion =  Some(CanchaFutbol())), ciudadela)
      case "4" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion =  Some(Edificio())), ciudadela)
      case "5" => digitarCoordenadasConstruccion(ordenConstruccion.copy(tipoConstruccion =  Some(Gimnasio())), ciudadela)
      case _ =>MenuPrincipal.menuPrincipal (ordenConstruccion,ciudadela)
    }
  }
  def ejecutarSolicitudOrden(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={

    val validarMateriales = Validadores.validarMateriales(ordenConstruccion, ciudadela)
    if ( validarMateriales )  Imprimir.imprimirErrorValidacion(ordenConstruccion, ciudadela)
    val validarCoord = Validadores.validarCoordenadas(ordenConstruccion, ciudadela)
    if (validarCoord) Imprimir.imprimirErrorValidacion(ordenConstruccion, ciudadela)
    val materialesAct = AdministradorMateriales.descontarMaterial(ordenConstruccion, ciudadela.materiales)
    val ordenAct = AdministradorCiudadela.estadoSolicitudes(ciudadela, ordenConstruccion)
    val ciudadelaAct = RegistrarSolicitud.guardarSolicitud(ordenAct, ciudadela.copy(materiales = materialesAct))
    Imprimir.imprimirOrden(ordenAct, ciudadelaAct)

  }

}