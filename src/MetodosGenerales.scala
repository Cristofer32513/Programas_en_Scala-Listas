import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object MetodosGenerales {

  def llenarListaPalabras(lista:ListBuffer[String]) : Unit = {
    println("¿Cuantas palabras va a ingresar?")
    val cantidadPalabras = readInt()

    for (i <- 1 to cantidadPalabras) {
      println("Ingrese la palabra #" + i + "...")
      lista += readLine()
    }
  }

  def llenarListaNumeros(lista:ListBuffer[Int]) : Unit = {
    println("¿Cuantas numeros va a ingresar?")
    val cantidadNumeros = readInt()

    for (i <- 1 to cantidadNumeros) {
      println("Ingrese el numero #" + i + "...")
      lista += readInt()
    }
  }

  def mostrarListaPalabras(lista:ListBuffer[String]) : Unit = {
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }

  def mostrarListaNumeros(lista:ListBuffer[Int]) : Unit = {
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }

  def palabraA(mensaje:String) : String = {
    println(mensaje)
    readLine()
  }






}
