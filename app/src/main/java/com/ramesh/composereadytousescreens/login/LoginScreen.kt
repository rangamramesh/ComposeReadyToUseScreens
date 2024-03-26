package com.ramesh.composereadytousescreens.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.ramesh.composereadytousescreens.login.Authenticator.authenticate
import com.ramesh.composereadytousescreens.ui.theme.Primary
import com.ramesh.composereadytousescreens.ui.theme.Secondary

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 140.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom
    ) {

        OutlinedTextField(
            value = userName, onValueChange = { userName = it },
            label = { Text(text = "Username") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Primary,
                unfocusedLeadingIconColor = Secondary,
                focusedLabelColor = Primary,
                unfocusedLabelColor = Secondary,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Primary,
                unfocusedIndicatorColor = Primary,
                unfocusedPlaceholderColor = Primary
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "username")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = password, onValueChange = { password = it },
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Primary,
                unfocusedLeadingIconColor = Secondary,
                focusedLabelColor = Primary,
                unfocusedLabelColor = Secondary,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Primary,
                unfocusedIndicatorColor = Primary,
                unfocusedPlaceholderColor = Primary
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "username")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {
                if (authenticate(userName, password)) {
                    onLoginSuccess()
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(context, "Login Failure", Toast.LENGTH_SHORT).show()
            }, colors = ButtonDefaults.buttonColors(Primary),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Login", color = Color.White)
        }
    }
}


