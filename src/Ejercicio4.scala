import scala.collection.mutable.ListBuffer
import MetodosGenerales._

object Ejercicio4 {

  def buscarPalabras(lista1:ListBuffer[String], lista2:ListBuffer[String]) : Int = {
    var conincidencias = 0
    for (e <- lista2.indices)
      for (j <- lista1.indices)
        if(lista1(j).equals(lista2(e))) conincidencias += 1

    conincidencias
  }

  def actualizarLista(lista1:ListBuffer[String], lista2:ListBuffer[String]) : Unit = {
    for (e <- lista2.indices) {
      for (j <- lista1.indices) {
        if(lista1(j).equals(lista2(e))) {
          lista1.remove(j)
          actualizarLista(lista1, lista2)
          return
        }
      }
    }

    println("\nLista 1 actualizada.")
    mostrarListaPalabras(lista1)
  }

  def main(args: Array[String]): Unit = {
    print("Palabras de la lista 1, ")
    val palabras1 = new ListBuffer[String]()
    llenarListaPalabras(palabras1)

    println()
    print("Palabras de la lista 2, ")
    val palabras2 = new ListBuffer[String]()
    llenarListaPalabras(palabras2)

    println("\nLista 1 original.")
    mostrarListaPalabras(palabras1)
    println("\nLista de palabras a borrar en la lista 1.")
    mostrarListaPalabras(palabras2)

    if (buscarPalabras(palabras1, palabras2) > 0) actualizarLista(palabras1, palabras2)
    else println("\nNo se encontraron coincidencias.")
  }
}