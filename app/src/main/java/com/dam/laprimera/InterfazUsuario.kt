package com.dam.laprimera
import android.util.Log
import androidx.compose.foundation.Image
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
@Composable
fun IU3(miViewModel: MyViewModel){

    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        Image(//FONDO DE PANTALLA DE OCEANO

            painter = painterResource(id = R.drawable.oceano),
            contentDescription = null, // Puedes establecer una descripción apropiada si es necesario
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()

        )
        Button(//BOTON PARA GENERAR NUMEROS ALEATORIOS
            onClick ={ miViewModel.crearRandom()},
            modifier = Modifier
                //.padding(vertical = 360.dp, horizontal = 110.dp)
                .offset(y = 175.dp)
                .offset(x = 0.dp)


        ){//PERSONALIZACIÓN DEL BOTÓN
            Image(
                painter = painterResource(id = R.drawable.lagartojuancho),//FREESVG.ORG PARA DESCARGAR MAS
                contentDescription = "Generar numeros",
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp)

            )
            Text(text="Pulsa para generar numeros")
        }

        Text(//TEXTO DÓNDE APARECEN LOS NUMEROS ALEATORIOS AL PULSAR EL BOTÓN

            //text = "Numeros: ${miViewModel.getNumero()}",//llama al método que me devuelve un número random
            text = "Numeros: ${miViewModel.getNumerosRandom()}",//llama al método que me devuelve laa lista de números random
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .offset(y = 250.dp)//Y = EJE VERTICAL
                .offset(x = 20.dp)

        )
        Box(

        ) {
            Image(//FONDO DE PANTALLA DE OCEANO

                painter = painterResource(id = R.drawable.pescador),
                contentDescription = "pescador",
                modifier = Modifier
                    .offset(y = 168.dp)//Y = EJE VERTICAL
                    .offset(x = 290.dp)

            )
        }

    }
    Login(miViewModel)// FUNCIÓN QUE TIENE PALABRA "CLICS" QUE GENERA NÚMERO CUANDO LE PULSO
}

@Composable
 fun InterfazUsuario2(miViewModel: MyViewModel){//llamo a la clase creada MyViewModel. Luego en la main, la paso por aprametro cuando llame

//Esta interfaz tiene el BOTON y el texto NUMEROS
      Text(
        //text = "Numeros: ${miViewModel.getNumero()}",
          text = "Numeros: ${miViewModel.getNumerosRandom()}",
        modifier = Modifier
            .offset(y = 225.dp)//Y = EJE VERTICAL
            .offset(x = 35.dp)
    )

    //un boton para generar numeros aleatorios
    Button(
        onClick ={ miViewModel.crearRandom()},
        modifier = Modifier
            .padding(vertical = 360.dp, horizontal = 110.dp)
            .offset(y = 400.dp)
            .offset(x = 0.dp)
        //Usar paddin(vertical = 100) y el size para camboiar su tamaño

    ){

        Image(
            painter = painterResource(id = R.drawable.lagartojuancho),//FREESVG.ORG PARA DESCARGAR MAS
            contentDescription = "Generar numeros",
            modifier = Modifier
                .padding(4.dp)
                .size(40.dp)


        )

        Text(text="Generar numeros")
        // campo de texto para rellenar

    }
Login(miViewModel)

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  //  var msj_saludo = stringResource(id = R.string.saludo)
   // var name = remember {mutableStateOf("")}

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Box{
            Image(painter = painterResource(R.drawable.neil150),contentDescription = "icono")
           /* Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "icono_check"
            )*/
        }
        Column{
            Text(
                text = "Hola $name",
                fontSize = 50.sp,
                color = Color.Blue,
                modifier = modifier
            )
            Text(
                text = stringResource(R.string.saludo),
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = modifier

            )

            Button(onClick = { Log.d("Calcular", "Click!!!!") }) {
                Text(text = "Click me!", color= Color.Yellow)
            }




        }
        
    }


    /**
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
            Spacer(modifier = Modifier.height(50.dp))//Para separar el Text de arriba de la Image de abajo
            Image(
                modifier = modifier.offset(y=50.dp),
                painter = painterResource(R.drawable.chelo),
                contentDescription = "Icono"
            )
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

            Button(onClick = { Log.d("calcular", "click!!!") }) {
                Text(text = "Click me!!", color = Color.Yellow)
            }
        }
    }**/
}


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
            value = miViewModel.getString(),
            onValueChange = {
                miViewModel.name.value = it
            },
            label = { Text(text = "Escribe") }
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



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        InterfazUsuario2(miViewModel = MyViewModel())
    }
}

