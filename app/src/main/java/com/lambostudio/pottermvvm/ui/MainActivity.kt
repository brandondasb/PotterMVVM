package com.lambostudio.pottermvvm.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lambostudio.pottermvvm.ui.theme.PotterMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PotterMVVMTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplaySpell(

                    )
                }
            }
        }
    }
}

@Composable
fun DisplaySpell(
    viewModel: RandomSpellViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "Click the button to generate a Spell, if its a killing spell you loose.",
            modifier = modifier
        )
        if (viewModel.uiState.collectAsState().value.name.isNotEmpty()
        ) {
            Text(
                text = "Name: ${viewModel.uiState.collectAsState().value.name}!",
                modifier = modifier
            )

            Text(
                text = "Description: ${viewModel.uiState.collectAsState().value.description}!",
                modifier = modifier
            )
        }

        Button(onClick = { viewModel.generateSpell() }, modifier.fillMaxWidth()) {
            Text("generate new spell")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PotterMVVMTheme {
        DisplaySpell()
    }
}
