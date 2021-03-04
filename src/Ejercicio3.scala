import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object Ejercicio3 {

  def llenarLista(palabras:ListBuffer[String]) : Unit = {
    println("¿Cuantas palabras va a ingresar?")
    val cantidadPalabras = readInt()

    for (i <- 1 to cantidadPalabras) {
      println("Ingrese la palabra #" + i + "...")
      palabras += readLine()
    }
  }

  def palabraAEliminar() : String = {
    println("\n¿Que palabra quiere eliminar de la lista de palabras?")
    val palabra = readLine()

    palabra
  }

  def mostrarLista(lista:ListBuffer[String]) : Unit = {
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }

  def actualizarLista(lista:ListBuffer[String], palabraAEliminar:String) : Unit = {
    for (e <- lista.indices) {
      if(lista(e).equals(palabraAEliminar)) {
        lista.remove(e)
        actualizarLista(lista, palabraAEliminar)
        return
      }
    }

    println("\nLista modificada")
    mostrarLista(lista)
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    llenarLista(palabras)

    println("\nLista original")
    mostrarLista(palabras)

    actualizarLista(palabras, palabraAEliminar())
  }
}