import scala.collection.mutable.ListBuffer
import MetodosGenerales._
import Ejercicio1.buscarPalabra

object Ejercicio3 {

  def actualizarLista(lista:ListBuffer[String], palabraAEliminar:String) : Unit = {
      for (e <- lista.indices) {
        if(lista(e).equals(palabraAEliminar)) {
          lista.remove(e)
          actualizarLista(lista, palabraAEliminar)
          return
        }
      }

    println("\nLista modificada.")
    mostrarListaPalabras(lista)
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    llenarListaPalabras(palabras)
    val palabraABorrar = palabraA("\n¿Que palabra quiere eliminar de la lista de palabras?")

    println("\nLista original.")
    mostrarListaPalabras(palabras)

    if (buscarPalabra(palabras, palabraABorrar) > 0) actualizarLista(palabras, palabraABorrar)
    else println("\nNo se encontraron coincidencias.")
  }
}