import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}

object Ejercicio8 {

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

  def verificarCapicuo(num:Int) : Boolean = {
    var mitad1 = ""
    var mitad2 = ""

    if (num.toString.length%2 == 0){
      mitad1 = num.toString.substring(0, num.toString.length/2)
      mitad2 = num.toString.substring(num.toString.length/2, num.toString.length)
    } else {
      mitad1 = num.toString.substring(0, num.toString.length/2)
      mitad2 = num.toString.substring((num.toString.length/2)+1, num.toString.length)
    }

    if (mitad1.equals(mitad2.reverse)) true else false
  }

  def obtenerCapicuos(lista:ListBuffer[Int]) : ListBuffer[Int] = {
    val listaCapicuos = new ListBuffer[Int]()
    for (e <- lista.indices) if(verificarCapicuo(lista(e))) listaCapicuos += lista(e)

    listaCapicuos
  }

  def main(args: Array[String]): Unit = {
    val numeros = new ListBuffer[Int]()
    llenarLista(numeros)

    println("\nNumeros de la Lista original")
    mostrarLista(numeros)
    val capicuos = obtenerCapicuos(numeros)

    if(capicuos.isEmpty) println("\nNo se encontraron capicuos.")
    else {
      println("\nNumeros de la lista de capicuos")
      mostrarLista(capicuos)
    }
  }
}