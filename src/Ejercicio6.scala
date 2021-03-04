import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object Ejercicio6 {

  def llenarLista(palabras:ListBuffer[Int]) : Unit = {
    println("¿Cuantas numeros va a ingresar?")
    val cantidadNumeros = readInt()

    for (i <- 1 to cantidadNumeros) {
      println("Ingrese el numero #" + i + "...")
      palabras += readInt()
    }
  }

  def mostrarLista(lista:ListBuffer[Int]) : Unit = {
    print("[ ")
    for (e <- lista.indices) if(e == lista.length-1) print(lista(e)) else print(lista(e) + ", ")
    println(" ]")
  }

  def realizarSumaAcumulada(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val sumaAcumulada = new ListBuffer[Int]()
    for (e <- lista.indices) if(e == 0) sumaAcumulada += lista(e) else sumaAcumulada += sumaAcumulada(e-1) + lista(e)

    sumaAcumulada
  }

  def main(args: Array[String]): Unit = {
    val numeros = new ListBuffer[Int]()
    llenarLista(numeros)

    println("\nLista de numeros original")
    mostrarLista(numeros)
    print("\nLista con la suma acumulada")
    mostrarLista(realizarSumaAcumulada(numeros))
  }
}