import scala.collection.mutable.ListBuffer
import MetodosGenerales._

object Ejercicio5 {

  def eliminarRepetidas(lista:ListBuffer[String]) : Unit = {
    for (e <- lista.indices) {
      for (j <- e+1 until lista.size) {
        if(lista(e).equals(lista(j))) {
          lista.remove(j)
          eliminarRepetidas(lista)
          return
        }
      }
    }
  }

  def obtenerPalabrasEnAmbasListas(lista1:ListBuffer[String], lista2:ListBuffer[String]) : ListBuffer[String] = {
    val palabrasEnAmbasListas = new ListBuffer[String]()

    for (e <- lista1.indices)
      for (j <- lista2.indices)
        if(lista1(e).equals(lista2(j))) palabrasEnAmbasListas += lista2(j)

    palabrasEnAmbasListas
  }

  def obtenerPalabrasDeLista1QueNoEstanEnLista2(lista1:ListBuffer[String], lista2:ListBuffer[String]) : ListBuffer[String] = {
    val palabrasDeLista1QueNoEstanEnLista2 = new ListBuffer[String]()

    for (e <- lista1.indices) {
      var coincidencias = 0

      for (j <- lista2.indices) if (lista1(e).equals(lista2(j))) coincidencias += 1

      if (coincidencias == 0) palabrasDeLista1QueNoEstanEnLista2 += lista1(e)
    }

    palabrasDeLista1QueNoEstanEnLista2
  }

  def obtenerPalabrasDeLista2QueNoEstanEnLista1(lista1:ListBuffer[String], lista2:ListBuffer[String]) : ListBuffer[String] = {
    val palabrasDeLista2QueNoEstanEnLista1 = new ListBuffer[String]()

    for (e <- lista2.indices) {
      var coincidencias = 0

      for (j <- lista1.indices) if (lista1(j).equals(lista2(e))) coincidencias += 1

      if (coincidencias == 0) palabrasDeLista2QueNoEstanEnLista1 += lista2(e)
    }

    palabrasDeLista2QueNoEstanEnLista1
  }

  def main(args: Array[String]): Unit = {
    print("Palabras de la lista 1, ")
    val palabras1 = new ListBuffer[String]()
    llenarListaPalabras(palabras1)
    eliminarRepetidas(palabras1)

    println()
    print("Palabras de la lista 2, ")
    val palabras2 = new ListBuffer[String]()
    llenarListaPalabras(palabras2)
    eliminarRepetidas(palabras2)

    println("\nPalabras de la Lista 1.")
    mostrarListaPalabras(palabras1)
    println("\nPalabras de la lista 2.")
    mostrarListaPalabras(palabras2)


    println("\nPalabras que estan en ambas listas.")
    val listaAmbas = obtenerPalabrasEnAmbasListas(palabras1, palabras2)
    mostrarListaPalabras(listaAmbas)

    println("\nPalabras en la lista 1 que no estan en la lista 2.")
    val listaEnL1 = obtenerPalabrasDeLista1QueNoEstanEnLista2(palabras1, palabras2)
    mostrarListaPalabras(listaEnL1)

    println("\nPalabras en la lista 2 que no estan en la lista 1.")
    val listaEnL2 = obtenerPalabrasDeLista2QueNoEstanEnLista1(palabras1, palabras2)
    mostrarListaPalabras(listaEnL2)

    println("\nUnion de las dos listas anteriores.")
    mostrarListaPalabras(listaEnL1 ++ listaEnL2)
  }
}