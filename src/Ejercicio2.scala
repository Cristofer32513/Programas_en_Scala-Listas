import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object Ejercicio2 {

  def llenarLista(palabras:ListBuffer[String]) : Unit = {
    println("¿Cuantas palabras va a ingresar?")
    val cantidadPalabras = readInt()

    for (i <- 1 to cantidadPalabras) {
      println("Ingrese la palabra #" + i + "...")
      palabras += readLine()
    }
  }

  def palabraABuscar() : String = {
    println("\n¿Que palabra queire buscar en la lista de palabras?")
    val palabra = readLine()

    palabra
  }

  def palabraAInsertar() : String = {
    println("\n¿Que palabra queire insertar en las coincidencias de la lista de palabras?")
    val palabra = readLine()

    palabra
  }

  def mostrarLista(lista:ListBuffer[String]) : Unit = {
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }

  def actualizarLista(lista:ListBuffer[String], palabraABuscar:String, palabraAInsertar:String) : Unit = {
    println("\nLista original")
    mostrarLista(lista)

    for (e <- lista.indices) if(lista(e).equals(palabraABuscar)) lista(e) = palabraAInsertar

    println("\nLista modificada")
    mostrarLista(lista)
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    llenarLista(palabras)
    actualizarLista(palabras, palabraABuscar(), palabraAInsertar())
  }
}