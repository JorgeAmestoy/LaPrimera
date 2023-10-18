package com.dam.laprimera

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.laprimera.ui.theme.LaPrimeraTheme

//DEFINICION DE VARIABLES
val TAG: String = "estado"
val name: String = "Android"

//datos de la aplicacion que queremos
var _numbers = mutableStateOf(0) //EL REMEMBER ES SOLO PARA QUE FUNCIONE EL OBSERVER CUANDO ESTE DENTRO DE LA INTERFAZ, DENTRO DE UN COMPOSSABLE
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {    //el oncreate es como la main. Tienes que llamarlo desde onCreate
        //o tambien en el onStart
        super.onCreate(savedInstanceState)
        //ASí el logcat de MyViewModel, nos va adecir cada vcez que se inicia. POr eso hay que hacer ese sout de ese logcat.
        val miViewModel: MyViewModel = MyViewModel()//es como cuando en netbeans llamo a la clase con el new
        setContent {
            LaPrimeraTheme {

                Surface(//pasando curso por encima de Surface, nos pone los parametros por defectos y al final uno que es una funcion
                    modifier = Modifier.fillMaxSize(),//para que me rellene toDDo el movil??
                    color = MaterialTheme.colorScheme.background
                ) {
                 //Greeting(name)
                  // InterfazUsuario2(miViewModel)//llamo a la variable en la que "guardé" la clase
                    IU3(miViewModel)
                }
            }
        }

        Log.d(TAG, "Estoy en on Create")

        calcular()//No pongo valores dentro porque ya se los di por defecto al crear la funcion
        //Tambien puedes cambiar el orden de los parametros


        calcular2(aa = 3, bb = 5, fun(numero1: Int, numero2: Int) {
            val suma = numero1 + numero2
            Log.d("calcular", suma.toString())
        })

        calcular2(4,1,fun(x,y){
            val resta = x-y
            Log.d("calcular",resta.toString())
        })
        calcularVacio(4,1,fun(){
            Log.d("calcular","Yo no hago nada, solo Log")
        })
        calcularVacio{//puedes no escribir el ultimo parametro, es decir, la funcion. Solo puedo hacer esto
            //con el ultimo parametro
            //tambien quitas los dos primeros porque les doy los pametros por defecto
            //tambien se puede prescindir de los parentesis
            Log.d("calcular","Yo no hago nada, solo Log")
        }


    }


   //METODOS CALCULAR PRIMERAS CLASES
    fun calcular(
        a: Int = 1,
        b: Int = 1
    ) {//les doy valores por defecto, aunque en la "main" ponga otro num, usará estos
        val operacion = a + b
        Log.d("calcular", operacion.toString())
    }

    //operacion es una funcion que recibe dos parametros (x,y) y no devuelve nada
    fun calcular2(aa: Int,bb: Int,operacion: (x: Int, y: Int) -> Unit) {
        operacion(aa,bb)  //en la funcion operacion voy a usar a y b, que representa x e y en la funcion operacion
    }

    fun calcularVacio(a: Int=0, b: Int=0, operacion: () -> Unit){
        operacion()
    }


    //ESTADOS DE LA APP(se quedan en la main. No van en MVVM).
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "He llegado al onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "He llegado al onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "He llegado al onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "He llegado al onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "He llegado al onDestroy")
    }


}



