package com.dam.laprimera
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.laprimera.ui.theme.LaPrimeraTheme

@Composable
 fun InterfazUsuario2(miViewModel: MyViewModel){//llamo a la clase creada MyViewModel. Luego en la main, la paso por aprametro cuando llame

//Esta interfaz tiene el BOTON y el texto NUMEROS
      Text(
        text = "Numeros: ${miViewModel.getNumero()}",
        modifier = Modifier
            .padding(110.dp)
            .offset(y = -30.dp)
            .offset(x = 185.dp)
    )
    //un boton para generar numeros aleatorios
    Button(
        onClick ={ miViewModel.crearRandom()},
        modifier = Modifier
            .padding(vertical = 360.dp, horizontal = 110.dp)

            .offset(y = 0.dp)
            .offset(x = 100.dp)
        //Usar paddin(vertical = 100) y el size para camboiar su tamaño

    ){

        Image(
            painter = painterResource(id = R.drawable.lagartojuancho),//FREESVG.ORG PARA DESCARGAR MAS
            contentDescription = "Generar numeros",
            Modifier.padding(8.dp)
        )
        Text(text="Generar numeros")
        // campo de texto para rellenar



    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel) {



    Column {
        // mostrar el contador de clics
        TextButton(onClick = { miViewModel.contador()}) {
            Text("CLICS: ${miViewModel.getContador()}")
        }

        // mientras no tecleamos mas de tres caracteres no se muestra el saludo
        if (miViewModel.name.value.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.getString()}!",
                fontSize = 24.sp
            )
        }
        // campo de texto para rellenar
        OutlinedTextField(
            value = miViewModel.getString(),
            onValueChange = {
                miViewModel.name.value = it
            },
            label = { Text(text = "Name") }
        )

    }

}

@Composable
fun InterfazUsuario(){
    login()
    texto_descriptivo("Hola texto")
    chat()
}
@Composable
fun chat() {
    TODO("Not yet implemented")
}
@Composable
fun texto_descriptivo(texto:String) {
    Text(text = texto)
}

@Composable
fun login(){
    texto_descriptivo(texto = "Fallo de login")
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//Tiene las fotos de CHELO y PAISAJE
    var msj_saludo = stringResource(id = R.string.saludo)
    var name = remember {mutableStateOf("")}

    Row {

        Image(
            modifier = modifier.offset(y=50.dp),
            painter = painterResource(R.drawable.chelo),
            contentDescription = "Icono"
        )
        /*
            Text(
                //Atributos separados por coma
                text = msj_saludo,
                fontSize = 50.sp,
                color = Color.Blue,
                modifier = modifier
            )*/

        Column {


            Text(
                text = "Chelo Garcia",
                fontSize = 40.sp,
                color = Color.Black,
                modifier = modifier
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "3 minutes ago",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(R.drawable.estrellas),
                contentDescription = "Estrellas"
            )
            /*
            Button(onClick = { Log.d("calcular", "click!!!") }) {
                Text(text = "Click me!!", color = Color.Yellow)
            }*/



        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        InterfazUsuario2(miViewModel = MyViewModel())
    }
}
