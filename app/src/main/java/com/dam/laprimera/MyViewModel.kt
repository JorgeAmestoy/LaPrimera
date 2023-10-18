package com.dam.laprimera

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
    val listaRandom = mutableStateListOf<Int>()


    //Inicializamos variable cuando instanciamos
    //ESte es el constructor de la clase.Es el otro sitio donde podemos inicializar.
    // Esto se va a ejecutar cuando instancie la clase. Así sabemos cuando arranca el ViewModel.
    init {
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }

    /**
     * Queremos que un numero entero se cree aleatoriamente
     */
    fun crearRandom(){
        _numbers.value = (0..3).random()
      //  val numeroAleatorio = (0..3).random()
        listaRandom.add(_numbers.value)

        //Log.d(TAG_LOG, "creamos random ${_numbers.value}")
        Log.d(TAG_LOG, "Añado el ${_numbers.value}")
        for(numero in listaRandom){
            Log.d(TAG_LOG," Lista de números random: $numero")
        }

    }
    /**
     * Devuelve el número aleatorio
     */
    fun getNumero(): Int {//nos devuelve la clase Int. En Kotlin no hay valores primitivos
        return _numbers.value
    }

    fun getNumerosRandom(): List<Int>{
        return listaRandom.toList()
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