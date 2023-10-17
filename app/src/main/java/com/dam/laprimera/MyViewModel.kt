package com.dam.laprimera

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * Inicializa y modifica los datos de la app
 * Añadir el () a la clase es otra forma de inicializar(constructor)
 * Se puede inicializar parametros
 */
class MyViewModel() : ViewModel() {

    //para que sea más fácil la etiqueta del log
    private val TAG_LOG: String = "mensaje ViewModel"

    //esta va a ser nuestra lista para la secuencia random
    //usamos mutable, ya que lo queremos modificar
    //El mutable hace que siga siendo observable. Cuando cambie de valor, todos los que usan
    //esta variable, van a enterarse y hacer sus cambios(?)
    var _numbers = mutableStateOf(0)



    // Dos maneras diferentes de definir un estado
    // con el = necesitamos utilizar value
    var counter = mutableStateOf(0)
    var name =mutableStateOf("")


    //Inicializamos variable cuando instanciamos
    //ESte es el constructor de la clase.Es el otro sitio donde podemos inicializar.
    // Esto se va a ejecutar cuando instancie la clase. Así sabemos cuando arranca el ViewModel.
    init {
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }



    /**
     * Queremos que un numero entero se cree aleatoriamente
     */
    fun crearRandom() {
        _numbers.value = (0..10).random()
        Log.d(TAG_LOG, "creamos random ${_numbers.value}")
    }
    /**
     * Devuelve el número aleatorio
     */
    fun getNumero(): Int {//nos devuelve la clase Int, en Kotlin no hay valores primitivos
        return _numbers.value
    }

    fun contador(){
        counter.value++
    }

    fun getContador():Int{
        return counter.value
    }

    fun getString(): String{
        return name.value
    }


}