package com.example.artspace


import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentScreen by remember { mutableStateOf(1) }

    when (currentScreen) {
        1 -> Pantalla1 { currentScreen = 2 }
        2 -> Pantalla2(
            onPreviousClick = { currentScreen = 1 },
            onNextClick = { currentScreen = 3 }
        )
        3 -> Pantalla3 { currentScreen = 2 }
    }
}

@Composable
fun Pantalla1(onNextClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = R.drawable.darth_vader), // Reemplaza con tu imagen
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .border(2.dp, Color.Gray),
            contentScale = ContentScale.Crop
        )


        Column(
            modifier = Modifier
                .padding(30.dp)
        ) {
            Text(
                text = "\"En la oscuridad de mi máscara, veo la luz que una vez rechacé\"",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontStyle = FontStyle.Italic
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "- Darth Vader",
                modifier = Modifier.align(Alignment.Start),
                fontSize = 12.sp,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onNextClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Siguiente")
            }
        }
    }
}

@Composable
fun Pantalla2(onPreviousClick: () -> Unit, onNextClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = R.drawable.erwin),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.Crop
        )


        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "\"¡Mis soldados, griten!¡Mis soldados, enfurezcan!¡Mis soldados, luchen!\"",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontStyle = FontStyle.Italic
                )
            )
            Text(
                text = "- Erwin Smith - SNK",
                modifier = Modifier.align(Alignment.Start),
                fontSize = 12.sp
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPreviousClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Anterior")
            }
            Button(
                onClick = onNextClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Siguiente")
            }
        }
    }
}

@Composable
fun Pantalla3(onPreviousClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = R.drawable.theoden),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .border(2.dp, Color.Gray),
            contentScale = ContentScale.Crop
        )


        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "\"¡LLego la hora del coraje, la hora de los lobos rotos escudo astillados!!El dia rojo se alza!\"",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontStyle = FontStyle.Italic
                )
            )
            Text(
                text = "- Rey Theoden - Lords of the Rings",
                modifier = Modifier.align(Alignment.Start),
                fontSize = 12.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPreviousClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Anterior")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}