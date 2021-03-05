import scala.collection.mutable.ListBuffer
import MetodosGenerales._

object Ejercicio1 {

  def buscarPalabra(lista:ListBuffer[String], palabra:String) : Int = {
    var cantidadCoincidencias = 0

    for (e <- lista) if(e.equals(palabra)) cantidadCoincidencias += 1

    cantidadCoincidencias
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    llenarListaPalabras(palabras)

    println("\nLista de palabras.")
    mostrarListaPalabras(palabras)

    println("\nRESULTADO: Se encontraron " + buscarPalabra(palabras, palabraA("\n¿Que palabra quiere buscar en la lista de palabras?")) + " coincidencias en la lista.")
  }
}