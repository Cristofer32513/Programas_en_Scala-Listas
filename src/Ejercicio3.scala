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
    val palabraABorrar = palabraAEliminar()

    println("\nLista original")
    mostrarLista(palabras)

    if (buscarPalabra(palabras, palabraABorrar) > 0) actualizarLista(palabras, palabraABorrar)
    else println("\nNo se encontraron coincidencias")
  }
}