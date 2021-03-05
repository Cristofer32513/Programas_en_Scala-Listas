import scala.collection.mutable.ListBuffer
import MetodosGenerales._
import Ejercicio1.buscarPalabra

object Ejercicio2 {

  def actualizarLista(lista:ListBuffer[String], palabraABuscar:String, palabraAInsertar:String) : Unit = {
    println("\nLista original.")
    mostrarListaPalabras(lista)

    for (e <- lista.indices) if (lista(e).equals(palabraABuscar)) lista(e) = palabraAInsertar

    println("\nLista modificada.")
    mostrarListaPalabras(lista)
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    llenarListaPalabras(palabras)
    val palabraAEncontrar = palabraA("\n¿Que palabra quiere buscar en la lista de palabras?")

    if (buscarPalabra(palabras, palabraAEncontrar) > 0) actualizarLista(palabras, palabraAEncontrar, palabraA("\n¿Que palabra quiere insertar en las coincidencias de la lista de palabras?"))
    else println("\nNo se encontraron coincidencias.")
  }
}