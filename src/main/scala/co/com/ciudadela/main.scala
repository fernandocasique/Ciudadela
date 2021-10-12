package co.com.ciudadela

import co.com.ciudadela.modelo.{Ciudadela,  OrdenConstruccion}
import co.com.ciudadela.vista.{Imprimir, MenuPrincipal}

import java.util.{Calendar}

object main {
  def main(args: Array[String]): Unit = {
    val fechaInicioProyecto = Calendar.getInstance()
    val ordenConstruccion: OrdenConstruccion = OrdenConstruccion(None, None)
    val ciudadela: Ciudadela = Ciudadela(None,fechaInicio = fechaInicioProyecto)
    Imprimir.imprimirBienvenida(ciudadela)
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

}
