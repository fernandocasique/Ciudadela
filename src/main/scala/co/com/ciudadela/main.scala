package co.com.ciudadela

import co.com.ciudadela.modelo.{Ciudadela, OrdenConstruccion}
import co.com.ciudadela.vista.{Imprimir, MenuPrincipal}

import java.time.{LocalDate}

object main {
  def main(args: Array[String]): Unit = {
    val fechafechaInicioProyecto = LocalDate.now
    val ordenConstruccion: OrdenConstruccion = OrdenConstruccion(None, None)
    val ciudadela: Ciudadela = Ciudadela(None, fechaInicio = fechafechaInicioProyecto )
    Imprimir.imprimirBienvenida(ciudadela)
    MenuPrincipal.menuPrincipal(ordenConstruccion, ciudadela)
  }

}
