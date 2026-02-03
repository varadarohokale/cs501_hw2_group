package com.example.dashboardscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboardscreen.ui.theme.DashboardScreenTheme
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashboardScreenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // calls the main dashboard UI and adds scaffold padding
                    DashboardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier){

    // boolean state toggled by the Switch
    var isEnabled by remember {mutableStateOf(false)}

    // int state updated by the button
    var clickCount by remember { mutableIntStateOf(0) }

    // A centered container with a max width keeps everything aligned
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // title text displayed at the top of the screen
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )

        CustomCard(
            isEnabled = isEnabled,
            count = clickCount,
            onToggleChange = { newValue ->
                isEnabled = newValue
            }
        )

        Button(
            onClick = { clickCount++ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Click me", fontSize = 18.sp)
        }



    }
}

@Composable
fun CustomCard(
    isEnabled: Boolean,
    count: Int,
    onToggleChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Toggle",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 16.sp
                )
                Switch(
                    checked = isEnabled,
                    onCheckedChange = onToggleChange
                )
            }

            Divider()

            Text(
                text = if (isEnabled) "ON" else "OFF",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Total clicks: $count",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

// preview was extremely large so i tried to manually set the dimensions
// but there is a zoom in & zoom out buttons so I set that to 100% and it looked good
@Preview(
    showBackground = true
)
@Composable
fun DashboardScreenPreview() {
    DashboardScreenTheme {
        DashboardScreen()
    }
}


