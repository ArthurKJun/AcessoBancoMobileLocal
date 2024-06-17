package com.senac.persistenciabanco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senac.persistenciabanco.ui.theme.PersistenciaBancoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersistenciaBancoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}
@ExperimentalMaterial3Api
@Composable
fun MyApp(){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Room DataBase") })
        }
    ) {
        Column (

            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .padding(16.dp)

        ){
            OutlinedTextField(value = "", onValueChange = {}, label = { Text(text = "Name")})
            OutlinedTextField(value = "", onValueChange = {}, label = { Text(text = "Description")})
            OutlinedTextField(value = "", onValueChange = {}, label = { Text(text = "Price")})
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Save")
            }
        }
    }
}
