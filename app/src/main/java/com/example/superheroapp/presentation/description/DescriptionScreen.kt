package com.example.superheroapp.presentation.description

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.superheroapp.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun DescriptionScreen(idHero: Int?,
                      navController: NavController,
                      viewModel: DescriptionViewModel = koinViewModel()
){
    LaunchedEffect(key1 = idHero) {
        if (idHero != null) {
            viewModel.getHeroById(idHero)
        }
    }
    viewModel.hero.collectAsStateWithLifecycle().value?.let{ uiStateHero ->
        Description(uiStateHero = uiStateHero)
    }

}

@Composable
fun Description(uiStateHero: DescriptionViewModel.UIStateHero){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painterResource(id = R.drawable.hero_example),
            contentDescription = "Hero example",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier.fillMaxWidth(), text = "${uiStateHero.hero?.localized_name}",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Text(
                modifier = Modifier, text = "Attack type",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                modifier = Modifier, text = "\"${uiStateHero.hero?.attack_type}\"",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(
                modifier = Modifier, text = "Roles",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                modifier = Modifier, text = "${uiStateHero.hero?.roles.toString()}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun SimpleComposablePreview() {
    //DescriptionScreen()
}