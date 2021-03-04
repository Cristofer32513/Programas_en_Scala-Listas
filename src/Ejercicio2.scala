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
    println("\n¿Que palabra quiere buscar en la lista de palabras?")
    val palabra = readLine()

    palabra
  }

  def palabraAInsertar() : String = {
    println("\n¿Que palabra quiere insertar en las coincidencias de la lista de palabras?")
    readLine()
  }

  def mostrarLista(lista:ListBuffer[String]) : Unit = {
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }

  def buscarPalabra(lista:ListBuffer[String], palabra:String) : Int = {
    var cantidadCoincidencias = 0

    for (e <- lista) if(e.equals(palabra)) cantidadCoincidencias += 1

    cantidadCoincidencias
  }

  def actualizarLista(lista:ListBuffer[String], palabraABuscar:String, palabraAInsertar:String) : Unit = {
    for (e <- lista.indices) if (lista(e).equals(palabraABuscar)) lista(e) = palabraAInsertar

    println("\nLista modificada")
    mostrarLista(lista)
  }

  def main(args: Array[String]): Unit = {
    val palabras = new ListBuffer[String]()
    llenarLista(palabras)
    val palabraAEncontrar = palabraABuscar()

    println("\nLista original")
    mostrarLista(palabras)
    if (buscarPalabra(palabras, palabraAEncontrar) > 0) actualizarLista(palabras, palabraAEncontrar, palabraAInsertar())
    else println("\nNo se encontraron coincidencias")
  }
}