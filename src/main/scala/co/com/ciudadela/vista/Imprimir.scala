package co.com.ciudadela.vista


import co.com.ciudadela.controlador.EstadoCiudadela
import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}

trait Imprimir {
  def imprimirMateriales(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Any ={
    println("\n ___ Materiales ___")
    println(s"\n Madera: ${ciudadela.material.madera}  \n Adobe = ${ciudadela.material.adobe}  \n Arena = ${ciudadela.material.arena}\n Grava = ${ciudadela.material.grava} \n Cemento = ${ciudadela.material.cemento} \n")
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }
  def imprimirRecargaExitosa(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Any ={
    println("\n ___ Se recargaron los materiales con éxito ___")
    println(s"\n Madera: ${ciudadela.material.madera}  \n Adobe = ${ciudadela.material.adobe}  \n Arena = ${ciudadela.material.arena}\n Grava = ${ciudadela.material.grava} \n Cemento = ${ciudadela.material.cemento} \n")
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  def imprimirErrorValidacion(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela): Unit ={
    println("\n No hay materiales suficientes para la construcción o ya existe una construcción en esas coordenadas \n")
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  def imprimirOrden(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela)= {
    println(s"\n ___ Orden de Construcción insertada con Exito ___ \n\n Tipo de Construcción: ${ordenConstruccion.tipoConstruccion}___ " +
      s"Estado de la Construcción: ${ordenConstruccion.estadoOrden}___" +
      s" Coordenadas de la Construcción: EjeX => ${ordenConstruccion.coordenada.get.ejeX}, EjeY => ${ordenConstruccion.coordenada.get.ejeY}\n")
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }


  def mostrarFechaCulminación(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela) = {
    EstadoCiudadela.estadoCiudadela (ciudadela) match {
      case true => println("\nAún no  ha iniciado la construcción de la Ciudadela\n")
      case false =>  println(s"\n La fecha de culminación del proyecto es: ${ciudadela.fechaFin} \n")
    }
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  def mostrarSolicitudOrdenes(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela) = {
    println("\n___ Ordenes de Construcción ___")
    EstadoCiudadela.estadoCiudadela (ciudadela) match {
      case true => println("\nAún no ha insertado ninguna orden\n")
      case false =>    ciudadela.solicitudesOrdenes.map(ordConstruccion => println(s"\n Tipo de Construcción: ${ordConstruccion.tipoConstruccion}___ " +
        s"Estado de la Construcción: ${ordConstruccion.estadoOrden}___" +
        s" Coordenadas de la Construcción: EjeX => ${ordConstruccion.coordenada.get.ejeX}, EjeY => ${ordConstruccion.coordenada.get.ejeY}\n"))
    }
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }
  def imprimirEstadosAct(ordenConstruccion: OrdenConstruccion, ciudadela: Ciudadela) = {
    EstadoCiudadela.estadoCiudadela (ciudadela) match {
      case true =>   println("\nAún no ha insertado ninguna orden\n")
      case false =>   println("\n ___ Todos los estados fueron actualizados con éxito ___\n")
        ciudadela.solicitudesOrdenes.map(ordConstruccion => println(s"\n Tipo de Construcción: ${ordConstruccion.tipoConstruccion}___ " +
          s"Estado de la Construcción: ${ordConstruccion.estadoOrden}___" +
          s" Coordenadas de la Construcción: EjeX => ${ordConstruccion.coordenada.get.ejeX}, EjeY => ${ordConstruccion.coordenada.get.ejeY}\n"))
    }
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

  def imprimirBienvenida(ciudadela: Ciudadela): Unit ={
    println("__ Bienvenido a la Ciudadela del futuro __")
    println(s"\n El arquitecto encargado del proyecto es: ${ciudadela.arquitecto.nombre} \n Su número de indentificación es: ${ciudadela.arquitecto.identificacion} \n")
  }

}
object Imprimir extends Imprimir

