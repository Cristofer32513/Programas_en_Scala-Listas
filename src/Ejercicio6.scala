import scala.collection.mutable.ListBuffer
import MetodosGenerales._

object Ejercicio6 {

  def realizarSumaAcumulada(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val sumaAcumulada = new ListBuffer[Int]()
    for (e <- lista.indices) if(e == 0) sumaAcumulada += lista(e) else sumaAcumulada += sumaAcumulada(e-1) + lista(e)

    sumaAcumulada
  }

  def main(args: Array[String]): Unit = {
    val numeros = new ListBuffer[Int]()
    llenarListaNumeros(numeros)

    println("\nLista de numeros original")
    mostrarListaNumeros(numeros)
    println("\nLista con la suma acumulada")
    mostrarListaNumeros(realizarSumaAcumulada(numeros))
  }
}