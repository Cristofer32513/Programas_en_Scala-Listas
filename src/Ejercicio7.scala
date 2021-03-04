import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object Ejercicio7 {

  def llenarLista(palabras:ListBuffer[String]) : Unit = {
    println("¿Cuantas palabras va a ingresar?")
    val cantidadPalabras = readInt()

    for (i <- 1 to cantidadPalabras) {
      println("Ingrese la palabra #" + i + "...")
      palabras += readLine()
    }
  }

  def mostrarLista(lista:ListBuffer[String]) : Unit = {
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }

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
    llenarLista(palabras)

    println("\nPalabras de la Lista original")
    mostrarLista(palabras)
    val palindromas = obtenerPalindromas(palabras)

    if(palindromas.isEmpty) println("\nNo se encontraron palindromas.")
    else {
      println("\nPalabras de la lista de palindromas")
      mostrarLista(palindromas)
    }
  }
}