package com.dam.laprimera

import android.util.Log
import androidx.compose.runtime.State
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
     * Variable llamada _numbers observable, la cual se establece inicialmente con el valor 0.
     * Se usa mutable porque la vamos a modificar y queremos que se actualice en la interfaz.
     * Si se cambia en algún momento dicho valor, todas las funciones que usen esta variable se van a enterar y actu33alizarse.
     * Esto hace que la interfaz se actualice
     * (BUSCAR MÉTODO QUE USA ESTA VARIABLE,(MODELVIEW..?)
     */
    var _numbers = mutableStateOf(0)

    /**
     * Dos maneras diferentes de definir un estado:
     *
     * var counter by remember { mutableStateOf(0) } -> hay que usar set(¿?)
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

    private val _randomData = mutableStateOf(DataRandom(0, emptyList()))
    val randomData: State<DataRandom> = _randomData



    fun reset() {
        _randomData.value = _randomData.value.copy(randomNumber = 0)
        Log.d(TAG_LOG, "Reiniciando")
    }


    /**
     * Función que crea y alamcena numeros aleatorios en una lista
     */
    fun crearRandom(){

        val random = (0..3).random()
        val updatedList = _randomData.value.randomNumbersList + random
        _randomData.value = DataRandom(random, updatedList)
        Log.d(TAG_LOG, "Añado el $random")

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