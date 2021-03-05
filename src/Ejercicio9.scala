import scala.collection.mutable.ListBuffer
import MetodosGenerales._

object Ejercicio9 {

  def verificarPrimo(num:Int) : Boolean = {
    var divisores = 0

    for (e <- 1 to num) if (num % e == 0) divisores += 1

    if(divisores == 2) true else false
  }

  def obtenerPrimos(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val listaPrimos = new ListBuffer[Int]()

    for (e <- lista.indices) if(verificarPrimo(lista(e))) listaPrimos += lista(e)

    listaPrimos
  }

  def obtenerSumatoriaYPromedio(lista:ListBuffer[Int]) : Unit = {
    var sumatoria = 0

    for (e <- lista.indices) sumatoria += lista(e)

    println("\nLa sumatoria de los numeros es: " + sumatoria)
    println("\nEl promedio de los numeros es: " + sumatoria.toDouble/lista.length)
  }

  def obtenerFactorial(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val listaFactorial = new ListBuffer[Int]()

    for (e <- lista.indices){
      var factorial = 1

      if (lista(e) > 2) for (j <- 2 to lista(e)) factorial *= j
      else factorial = lista(e)

      listaFactorial += factorial
    }

    listaFactorial
  }

  def main(args: Array[String]): Unit = {
    val numeros = new ListBuffer[Int]()
    llenarListaNumeros(numeros)

    println("\nNumeros de la Lista original.")
    mostrarListaNumeros(numeros)
    val primos = obtenerPrimos(numeros)

    if(primos.isEmpty) println("\nNo se encontraron numeros primos.")
    else {
      println("\nNumeros de la lista de primos.")
      mostrarListaNumeros(primos)
    }
    obtenerSumatoriaYPromedio(numeros)
    println("\nFactoriales de la lista de numeros.")
    mostrarListaNumeros(obtenerFactorial(numeros))
  }
}