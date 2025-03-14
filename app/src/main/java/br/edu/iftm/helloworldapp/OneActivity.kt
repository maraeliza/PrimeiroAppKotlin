package br.edu.iftm.helloworldapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import br.edu.iftm.helloworldapp.ui.theme.HelloWorldAppTheme

object KEYS {
    val message = "br.edu.iftm.helloworldapp.MESSAGE"
}


class OneActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = intent?.getStringExtra(KEYS.message) ?: "opsss"
        enableEdgeToEdge()
        setContent {
            HelloWorldAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(name=message, context=applicationContext)
                }
            }
        }

    }
    override  fun onStart(){
        super.onStart()
        Log.d("OneActivityDebugging", "onStart Executou")
    }
    override fun onResume (){
        super.onResume()
        Log.d("OneActivityDebugging", "onResumeExecutou")
    }
    override  fun onPause(){
        super.onPause()
        Log.d("OneActivityDebugging", "onPauseExecutou")
    }
    override fun onRestart(){
        super.onRestart()
        Log.d("OneActivityDebugging", "onRestart Executou")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("OneActivityDebugging", "onDestroy Executou")
    }
    override fun onStop(){
        super.onStop()
        Log.d("OneActivityDebugging", "onStop Executou")
    }
}
@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier, context:Context) {
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
                text = "Call $name?",
                fontSize = 30.sp,
                color = Color.Blue

            )
        }
    }

}
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Call $name?",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldAppTheme {
        Greeting2("Android")
    }
}