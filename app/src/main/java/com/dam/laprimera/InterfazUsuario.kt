package com.dam.laprimera
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.laprimera.ui.theme.LaPrimeraTheme
import java.time.format.TextStyle

/**
 * miViewModel es una instancia de la clase MyViewModel,
 * y se espera que se le pase como argumento
 * cuando se llame a la función IU3.
 */
@Composable
fun IU3(miViewModel: MyViewModel){

    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        Image(//FONDO DE PANTALLA DE OCEANO

            painter = painterResource(id = R.drawable.oceano),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()

        )
        Button(//BOTON PARA GENERAR NUMEROS ALEATORIOS
            onClick ={ miViewModel.crearRandom()},
            modifier = Modifier
                //.padding(vertical = 360.dp, horizontal = 110.dp)
                .offset(y = 175.dp)
                .offset(x = 0.dp)


        ){//PERSONALIZACIÓN DEL BOTÓN(foto lagartoJuancho...)
            Image(
                painter = painterResource(id = R.drawable.lagartojuancho),//FREESVG.ORG PARA DESCARGAR MAS
                contentDescription = "Generar numeros",
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp)

            )
            Text(text="Pulsa para generar numeros")
        }

        Text(//TEXTO DONDE APARECEN LOS NUMEROS ALEATORIOS AL PULSAR EL BOTÓN

            //text = "Numeros: ${miViewModel.getNumero()}",//llama al método que me devuelve un número random
            text = "Numeros: ${miViewModel.getNumerosRandom()}",//llama al método que me devuelve la lista de números random
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .offset(y = 250.dp)//Y = EJE VERTICAL
                .offset(x = 20.dp)//X = EJE HORIZONTAL

        )


    }
    Login(miViewModel)// FUNCIÓN QUE TIENE PALABRA "CLICKS" Y LA CAJA DE TEXTO
    Picture(miViewModel)//FUNCIÓN QUE TIENE LA FOTO DEL NIÑO PESCADOR
    Juego(miViewModel)//FUNCIÓN QUE TIENE EL JUEGO SIMON DICE

}

/**
 * FUNCIÓN PARA AÑADIR LA FOTO DEL NIÑO PESCADOR
 */
@Composable
fun Picture(miViewModel: MyViewModel){

    Box(

    ) {
        Image(//FOTO NIÑO PESCADOR

            painter = painterResource(id = R.drawable.pescador2),
            contentDescription = "pescador",
            modifier = Modifier
                .offset(y = 155.dp)//Y = EJE VERTICAL
                .offset(x = 290.dp)//X = EJE HORIZONTAL
                .size(100.dp)
        )

    }

}

/**
 * FUNCION DEL JUEGO QUE
 * TIENE LOS BOTONES Y SUS FUNCIONES
 */
@Composable
fun Juego(miViewModel: MyViewModel){
    Box{

        if(miViewModel.getContador()<10){
            Text("Rondas: ${miViewModel.getContador()}",
                modifier = Modifier
                    .offset(y = 350.dp)
                    .offset(x = 55.dp),
                fontSize = 25.sp
            )

        }else{
            Text("Rondas: ${miViewModel.getContador()}",
                modifier = Modifier
                    .offset(y = 350.dp)
                    .offset(x = 55.dp),
                fontSize = 40.sp)
        }
    
        Button(//BOTON AZUL
            onClick ={},
            modifier = Modifier
                //.padding(vertical = 360.dp, horizontal = 110.dp)
                .offset(y = 400.dp)
                .offset(x = 50.dp)
                .size(100.dp)
                .background(Color.Blue)


        ){

        }
        Button(//BOTON ROJO
            onClick ={},
            modifier = Modifier
                //.padding(vertical = 360.dp, horizontal = 110.dp)
                .offset(y = 550.dp)
                .offset(x = 50.dp)
                .size(100.dp)
                .background(Color.Red)


        ){

        }
        Button(//BOTON VERDE
            onClick ={ miViewModel.crearRandom()},
            modifier = Modifier
                //.padding(vertical = 360.dp, horizontal = 110.dp)
                .offset(y = 400.dp)
                .offset(x = 200.dp)
                .size(100.dp)
                .background(Color.Green)


        ){

        }
        Button(//BOTON AMARILLO
            onClick ={},
            modifier = Modifier
                //.padding(vertical = 360.dp, horizontal = 110.dp)
                .offset(y = 550.dp)
                .offset(x = 200.dp)
                .size(100.dp)
                .background(Color.Yellow)


        ){

        }


        Button(//BOTON PLAY
            onClick ={ miViewModel.contador()},
            modifier = Modifier
                //.padding(vertical = 360.dp, horizontal = 110.dp)
                .offset(y = 673.dp)
                .offset(x = 220.dp)
                .size(70.dp)



        ){
            Image(
                painter = painterResource(id = R.drawable.play),//FREESVG.ORG PARA DESCARGAR MAS
                contentDescription = "Generar numeros",
                modifier = Modifier
                    .size(40.dp)

            )

        }

        botonStart()

    }//Cierra la Box

}

/**
 * FUNCION QUE CUANDO PULSO BOTON START
 * CAMBIA LA PALABRA POR RESET
 */
@Composable
fun botonStart() {
    var start = remember { mutableStateOf(true) }

    Button(
        onClick = {
            start.value = ! start.value
        },
        modifier = Modifier
            .offset(y = 680.dp)
            .offset(x = 65.dp)
            .size(100.dp, 60.dp)
    ) {
        Text(
            text = if (start.value) "START" else "RESET",
            fontWeight = FontWeight.Bold
        )
    }
}


/**
 * CLICKS Y CAJA DE TEXTO
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel) {

    Column {

        // BOTÓN DE TEXTO LLAMADO "CLICKS" QUE CUANDO PULSO GENERA NÚMERO
        TextButton(onClick = { miViewModel.contador()}) {
            Text("CLICKS: ${miViewModel.getContador()}")
        }

        //CAJA DE TEXTO QUE SE PUEDE RELLENAR
        OutlinedTextField(
            value = miViewModel.getString(),//Coge el valor de lo que escriba dentro de la caja de texto
            onValueChange = {//Lo actualiza a medida que lo escribo
                miViewModel.name.value = it
            },
            label = { Text(text = "Escribe") }//Palabra que aparece dentro de la caja y que al escribir se pone como titulo
        )

        // CONDICIONAL EN LA QUE SI ESCRIBO MÁS DE TRES LETRAS ME SALE NUEVO TEXTO DEBAJO
        if (miViewModel.name.value.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.getString()}",
                fontSize = 24.sp
            )
        }

    }
}

/**
 * Vista previa de la app
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        IU3(miViewModel = MyViewModel())
    }
}
