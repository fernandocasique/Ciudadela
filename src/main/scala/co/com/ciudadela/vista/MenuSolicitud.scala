package co.com.ciudadela.vista

import co.com.ciudadela.controlador.{AdministradorCiudadela, AdministradorMateriales, RegistrarSolicitud, Validadores}
import co.com.ciudadela.modelo.{CanchaFutbol, Casa, Ciudadela, Coordenada, Edificio, Gimnasio, Lago, OrdenConstruccion}

object MenuSolicitud {

  def  menuTipoConstruccion(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={
    println("___ Solicitud Orden de construccion ___\n")
    println("Digite => \n 1. Para construir una casa \n 2.  Para construir una lago \n 3.  Para construir una Cancha de Futbol " +
      "\n 4.  Para construir un edificio \n 5.  Para construir un gymnasio \n  . Cualquier otro digito ara volver al menú Principal")
    val comandoTipoConstruccion  = scala.io.StdIn.readLine()
    digitarCoordenadasConstruccion(ordenConstruccion, ciudadela, comandoTipoConstruccion)
  }

  def digitarCoordenadasConstruccion( ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela, comandoTipoConstruccion: String ): Unit ={
    println("Digite la coordenada de construccion en el eje X")
    val ejeX  = scala.io.StdIn.readInt()
    println("Digite la coordenada de construccion en el eje Y")
    val ejeY  = scala.io.StdIn.readInt()
    controladorOrden(comandoTipoConstruccion,ordenConstruccion.copy( coordenada = Coordenada(ejeX, ejeY)), ciudadela)
  }

  def controladorOrden(comando: String, ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={
    comando match {
      case "1" =>  ejecutarSolicitudOrden(ordenConstruccion.copy(tipoConstruccion = Casa()), ciudadela)
      case "2" => ejecutarSolicitudOrden(ordenConstruccion.copy(tipoConstruccion = Lago()), ciudadela)
      case "3" => ejecutarSolicitudOrden(ordenConstruccion.copy(tipoConstruccion = CanchaFutbol()), ciudadela)
      case "4" => ejecutarSolicitudOrden(ordenConstruccion.copy(tipoConstruccion = Edificio()), ciudadela)
      case "5" => ejecutarSolicitudOrden(ordenConstruccion.copy(tipoConstruccion = Gimnasio()), ciudadela)
      case _ =>MenuPrincipal.menuPrincipal (ordenConstruccion,ciudadela)
    }
  }
  def ejecutarSolicitudOrden(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={

    val validarMater = Validadores.validarMateriales(ordenConstruccion, ciudadela)
    if ( validarMater )  Imprimir.imprimirErrorValidacion(ordenConstruccion, ciudadela)
    val validarCord = Validadores.validarCoordenadas(ordenConstruccion, ciudadela)
    if (validarCord) Imprimir.imprimirErrorValidacion(ordenConstruccion, ciudadela)
    val materialesAct = AdministradorMateriales.descontarMaterial(ordenConstruccion, ciudadela.materiales)
    val ordenAct = AdministradorCiudadela.estadoSolicitudes(ciudadela, ordenConstruccion)
    val ciudadelaAct = RegistrarSolicitud.guardarSolicitud(ordenAct, ciudadela.copy(materiales = materialesAct))
    Imprimir.imprimirOrden(ordenAct, ciudadelaAct)

  }

}