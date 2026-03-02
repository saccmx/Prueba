package com.example.prueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen()
        }
    }
}

@Composable
fun WelcomeScreen() {
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
                .background(color = Color.White, shape = RoundedCornerShape(25.dp)),
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