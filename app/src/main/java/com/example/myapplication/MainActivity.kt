package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArithmeticScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArithmeticScreen() {
    var numberOne: Int by remember {
        mutableStateOf(0)
    }
    var numberTwo: Int by remember {
        mutableStateOf(0)
    }

    var resultado: String by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Mi calculadora", fontSize = 32.sp, modifier = Modifier.padding(20.dp))
        TextField(value = numberOne.toString(), onValueChange = {
           numberOne = checkWroteNumber(it)
        }, label= {
            Text(text = "Cantidad 1:")
        }, placeholder =  {
            Text(text = "Porfavor escribe un número")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "Icon")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = numberTwo.toString(), onValueChange = {
            numberTwo = checkWroteNumber(it)
        }, label= {
            Text(text = "Cantidad 1:")
        }, placeholder =  {
            Text(text = "Porfavor escribe un número")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "Icon")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Row(modifier = Modifier.padding(20.dp)){
            Button(onClick = {
                resultado = (numberOne + numberTwo).toString()
            }) {
                Text(text = "+")
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = {
                resultado = (numberOne - numberTwo).toString()
            }) {
                Text(text = "-")
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = {
                resultado = (numberOne * numberTwo).toString()
            }) {
                Text(text = "*")
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = {
                resultado = ( numberOne.toFloat() / numberTwo.toFloat()).toString()
            }) {
                Text(text = "/")
            }
        }
        Text(text = resultado)
    }


}

fun checkWroteNumber(text: String): Int {
    if(text.toIntOrNull() != null) {
        return text.toInt()
    } else if (TextUtils.isEmpty(text)) {
        return 0
    }
    return 0
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArithmeticScreen()
}