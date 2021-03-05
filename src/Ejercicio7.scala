import scala.collection.mutable.ListBuffer
import MetodosGenerales._

object Ejercicio7 {

  def verificarPalabra(palabra:String) : Boolean = {
    if (palabra.equals(palabra.reverse)) true else false
  }

  def obtenerPalindromas(lista:ListBuffer[String]) : ListBuffer[String] = {
    val listaPalindromas = new ListBuffer[String]()

    for (e <- lista.indices) if (verificarPalabra(lista(e))) listaPalindromas += lista(e)

    listaPalindromas
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    llenarListaPalabras(palabras)

    println("\nPalabras de la Lista original.")
    mostrarListaPalabras(palabras)
    val palindromas = obtenerPalindromas(palabras)

    if(palindromas.isEmpty) println("\nNo se encontraron palindromas.")
    else {
      println("\nPalabras de la lista de palindromas.")
      mostrarListaPalabras(palindromas)
    }
  }
}