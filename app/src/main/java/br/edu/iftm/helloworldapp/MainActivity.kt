package br.edu.iftm.helloworldapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import br.edu.iftm.helloworldapp.ui.theme.HelloWorldAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    BotaoLigar(name="Mara", context=applicationContext)
                    BotaoTrocarTela(name="OneActivity", context = applicationContext)
                }
            }
        }
        Log.d("MainActivityDebugging", "onCreateExecutou")
    }
    override  fun onStart(){
        super.onStart()
        Log.d("MainActivityDebugging", "onStart Executou")
    }
    override fun onResume (){
        super.onResume()
        Log.d("MainActivityDebugging", "onResumeExecutou")
    }
    override  fun onPause(){
        super.onPause()
        Log.d("MainActivityDebugging", "onPauseExecutou")
    }
    override fun onRestart(){
        super.onRestart()
        Log.d("MainActivityDebugging", "onRestart Executou")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("MainActivityDebugging", "onDestroy Executou")
    }
    override fun onStop(){
        super.onStop()
        Log.d("MainActivityDebugging", "onStop Executou")
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Button(onClick={
            Log.d("MainActivityLogs", "\uD83D\uDFE5 --------------- CLICOU NO BOTÃO -------------\n ")
        },
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = "Ligar para $name!",
                fontSize = 30.sp,
                color = Color.Blue

            )
        }
    }

}

@Composable
fun BotaoAnotherTela(name: String, modifier: Modifier = Modifier, context: Context) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Button(onClick={
            val intent = Intent(context, OneActivity::class.java).apply {
                setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(KEYS.message, "HEI VIM DA MAIN")
            }
            context.startActivity(intent)

        },
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = "Ir para tela $name!",
                fontSize = 30.sp,
                color = Color.Blue

            )
        }
    }

}


@Composable
fun BotaoTrocarTela(name: String, modifier: Modifier = Modifier, context: Context) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Button(onClick={
            val intent = Intent(context, OneActivity::class.java).apply {
                setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)

        },
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = "Ir para tela $name!",
                fontSize = 30.sp,
                color = Color.Blue

            )
        }
    }

}

@Composable
fun BotaoLigar(name: String, modifier: Modifier = Modifier, context: Context) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Button(onClick={
            val intent  = Intent(Intent.ACTION_DIAL, "tel:34984094854".toUri())
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        },
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = "Ligar para $name!",
                fontSize = 30.sp,
                color = Color.Blue

            )
        }
    }

}
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier, context: Context) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Button(onClick={
            val intent  = Intent(Intent.ACTION_DIAL, "tel:34984094854".toUri())
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        },
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = "Ligar para $name!",
                fontSize = 30.sp,
                color = Color.Blue

            )
        }
    }

}
@Composable
fun ChangeBackgroundColor(modifier: Modifier = Modifier) {
    val backgroundColor = remember { mutableStateOf(Color.White) }
    val colorRed =  remember { mutableIntStateOf(128) }
    val colorGreen = remember {  mutableIntStateOf(128) }
    val colorBlue = remember { mutableIntStateOf(128) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor.value)
                .padding(32.dp)
        ){
            Text(text="Cor atual: ${colorRed.intValue}, ${colorGreen.intValue}, ${colorBlue.intValue}",
                color=Color.White,
                fontSize=32.sp,
                fontWeight = FontWeight.W600
                )
        }

        Button(onClick = {
            colorRed.intValue = Random.nextInt(0, 106)
            colorGreen.intValue = Random.nextInt(0, 106)
            colorBlue.intValue = Random.nextInt(0, 106)
            backgroundColor.value = Color(
                colorRed.intValue,
                colorGreen.intValue,
                colorBlue.intValue
            )
        }) {
            Text("Mudar Cor de Fundo")
        }
    }
}
