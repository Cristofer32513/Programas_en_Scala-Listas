import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object Ejercicio4 {

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

    println("\nLista 1 actualizada")
    mostrarLista(lista1)
  }

  def main(args: Array[String]): Unit = {
    print("Palabras de la lista 1, ")
    val palabras1 = new ListBuffer[String]()
    llenarLista(palabras1)

    println()
    print("Palabras de la lista 2, ")
    val palabras2 = new ListBuffer[String]()
    llenarLista(palabras2)

    println("\nLista 1 original")
    mostrarLista(palabras1)
    println("\nLista de palabras a borrar en la lista 1")
    mostrarLista(palabras2)

    if (buscarPalabras(palabras1, palabras2) > 0) actualizarLista(palabras1, palabras2)
    else println("\nNo se encontraron coincidencias")
  }
}