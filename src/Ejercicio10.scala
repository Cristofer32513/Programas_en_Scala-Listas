import scala.collection.mutable.ListBuffer
import MetodosGenerales._

object Ejercicio10 {

  def eliminarRepetidas(lista:ListBuffer[ListBuffer[Int]]) : Unit = {
    for (e <- lista.indices) {
      for (j <- e+1 until lista.size) {
        if(lista(e).head == lista(j).head) {
          lista.remove(j)
          eliminarRepetidas(lista)
          return
        }
      }
    }
  }

  def buscarNumero(lista:ListBuffer[Int], num:Int) : Int = {
    var cantidadCoincidencias = 0

    for (e <- lista) if(e == num) cantidadCoincidencias += 1

    cantidadCoincidencias
  }

  def empaquetarLista(lista:ListBuffer[Int]) : ListBuffer[ListBuffer[Int]] = {
    val listaEmpaquetada = ListBuffer[ListBuffer[Int]]()

    for (e <- lista){
      val paquete = ListBuffer[Int]()
      paquete += e
      paquete += buscarNumero(lista, e)

      listaEmpaquetada += paquete
    }

    eliminarRepetidas(listaEmpaquetada)

    listaEmpaquetada
  }

  def mostrarListaEmpaquetada(lista:ListBuffer[ListBuffer[Int]]) : Unit = {
    print("[ ")
    for (e <- lista.indices) {
      if(e == lista.length-1) print("[ " + lista(e).head + ", " + lista(e)(1) + " ]")
      else print("[ " + lista(e).head + ", " + lista(e)(1) + " ], ")
    }
    println(" ]")
  }

  def main(args: Array[String]): Unit = {
    val numeros = new ListBuffer[Int]()
    llenarListaNumeros(numeros)

    println("\nNumeros de la Lista original.")
    mostrarListaNumeros(numeros)
    println("\nDatos de la lista original empaquetados.")
    mostrarListaEmpaquetada(empaquetarLista(numeros))
  }
}