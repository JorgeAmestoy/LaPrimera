package com.dam.laprimera

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 *La clase MyViewModel hereda de la clase ViewModel (viene predeterminada por Android Jetpack).
 * MyViewModel() -> los () implican un constructor explicito. Así, puedo inicializar propiedades
 * en la creación de la instancia
 */
class MyViewModel() : ViewModel() {

    /**
     * La usamos para que sea más fácil la etique del Log
     * val -> variable de solo lectura o Constante
     * var -> variable mutable
     */
    private val TAG_LOG: String = "mensaje ViewModel"

    /**
     * Variable llamda _numbers observable, la cual se establece inicialmente con el valor 0.
     * Se usa mutable porque la vamos a modificar y queremos que se actualice en la interfaz.
     * Si se cambia en algún momento dicho valor, todas las funciones que usen esta variable se van a enterar y actualizarse.
     * Esto hace que la interfaz se actualice
     * (BUSCAR MÉTODO QUE USA ESTA VARIABLE,(MODELVIEW..?)
     */
    var _numbers = mutableStateOf(0)

    /**
     * Dos maneras diferentes de definir un estado:
     *
     * var counter by remember { mutableStateOf(0) }
     * var name = remember { mutableStateOf("") } -> Con el = hay que usar value
     */
    var counter = mutableStateOf(0)

    var name = mutableStateOf("")//Igual pero pero uso las comillas para denotar que el valor inicial será un String.

    val listaRandom = mutableStateListOf<Int>()


    /**
     * Es otra forma de hacer una instancia de la clase.
     * Aqui no proporcionamos ningún valor cuando la creamos.
     * Usamos el bloque init{} para inicializar las propiedades que queramos.
     * Esto se va a ejecutar cuando instancie la clase. Así sabemos cuando arranca el ViewModel.
     */
    init {
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }


    /**
     * Función que crea y alamcena numeros aleatorios en una lista
     */
    fun crearRandom(){

        /*
         * Genera un numero aleatorio ente 0 y 3 (inclusive) y lo asigna a la variable _numbers.value
         */
        _numbers.value = (0..3).random()//el value es por el mutableStateOf

        /*
         *Agrega el numero aleatorio a la lista "listaRandom)
         */
        listaRandom.add(_numbers.value)

        Log.d(TAG_LOG, "Añado el ${_numbers.value}")

        /**
         * For in que recorre listaRandom y va imprimiendo cada número que encuentra
         */
        for(numero in listaRandom){
            Log.d(TAG_LOG," Lista de números random: $numero")
        }

        // _numbers.value = (0..10).random()
        //Log.d(TAG_LOG, "creamos random ${_numbers.value}")

    }


    /**
     * Devuelve número aleatorio
     */
    fun getNumero(): Int {
        return _numbers.value
    }

    /**
     * Devuelve lista de numeros aleatorios
     */
    fun getNumerosRandom(): List<Int>{
        return listaRandom.toList()
    }

    /**
     *Funcion que aumenta el valor de la variable counter en uno cada vez que se llama
     */
    fun contador(){
        counter.value++
    }

    /**
     *Funcion que devuelve el valor de la variable counter
     */
    fun getContador():Int{
        return counter.value
    }

    /**
     *Funcion que devuelve el valor de la variable name
     */
    fun getString(): String{
        return name.value
    }


}