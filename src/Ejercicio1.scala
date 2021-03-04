import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object Ejercicio1 {

  def llenarLista(palabras:ListBuffer[String]) : Unit = {
    println("¿Cuantas palabras va a ingresar?")
    val cantidadPalabras = readInt()

    for (i <- 1 to cantidadPalabras) {
      println("Ingrese la palabra #" + i + "...")
      palabras += readLine()
    }
  }

  def palabraABuscar() : String = {
    println("\n¿Que palabra quiere buscar en la lista de palabras?")
    readLine()
  }

  def mostrarLista(lista:ListBuffer[String]) : Unit = {
    println()
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }

  def buscarPalabra(lista:ListBuffer[String], palabra:String) : Int = {
    var cantidadCoincidencias = 0

    for (e <- lista) if(e.equals(palabra)) cantidadCoincidencias += 1
    mostrarLista(lista)

    cantidadCoincidencias
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    llenarLista(palabras)

    println("Se encontraron " + buscarPalabra(palabras, palabraABuscar()) + " coincidencias en la lista.")
  }
}