package com.example.prueba

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("registro") {
            RegistroScreen()
        }
    }
}

// Login
@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = "Imagen de prueba",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 32.dp)
        )

        Text(
            text = "Hello",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Welcome To Little Drop, where\nyou manage you daily tasks",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        Box(
            modifier = Modifier
                .width(280.dp)
                .height(50.dp)
                .background(color = Color(0xFF424095), shape = RoundedCornerShape(25.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .width(280.dp)
                .height(50.dp)
                .border(width = 1.dp, color = Color(0xFF424095), shape = RoundedCornerShape(25.dp))
                .background(color = Color.White, shape = RoundedCornerShape(25.dp))
                .clickable { navController.navigate("registro") },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Sign Up",
                color = Color(0xFF424095),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

// Regsitroo
@Composable
fun RegistroScreen() {
    // Estados
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmar by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    // Validaciones
    val nombreValido = nombre.isNotEmpty() && nombre.all { it.isLetter() || it == ' ' }
    val correoValido = correo.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    val contrasenasIguales = contrasena.isNotEmpty() && contrasena == confirmar
    val telefonoValido = telefono.length == 10 && telefono.all { it.isDigit() }

    // El botón se activa soolo si es valido
    val formularioValido = nombreValido && correoValido && contrasenasIguales && telefonoValido

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Registro",
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            isError = nombre.isNotEmpty() && !nombreValido, // Muestra error en rojo
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            isError = correo.isNotEmpty() && !correoValido,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = confirmar,
            onValueChange = { confirmar = it },
            label = { Text("Confirmar Contraseña") },
            isError = confirmar.isNotEmpty() && !contrasenasIguales,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            isError = telefono.isNotEmpty() && !telefonoValido,
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
        )

        Button(
            onClick = {},
            enabled = formularioValido, // DesactivaR el botón si hay errore
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar", fontSize = 18.sp)
        }
    }
}