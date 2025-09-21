package com.example.simplelistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.simplelistapp.ui.theme.SimpleListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleListAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompanyListPreview()
                }
            }
        }
    }
}

data class SampleCompany(
    val name: String,
    val description: String,
    val logo: Int
)

val sampleCompanies = listOf(
    SampleCompany("Google", "Technology leader in search and cloud services", R.drawable.ic_launcher_foreground),
    SampleCompany("Microsoft", "Software giant with Windows and Azure", R.drawable.ic_launcher_foreground),
    SampleCompany("Apple", "Consumer electronics and software company", R.drawable.ic_launcher_foreground),
    SampleCompany("Amazon", "E-commerce and cloud computing leader", R.drawable.ic_launcher_foreground),
    SampleCompany("Facebook", "Social media and technology company", R.drawable.ic_launcher_foreground)
)

@Composable
fun CompanyListPreview() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(sampleCompanies) { company ->
            CompanyCardPreview(company = company)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyCardPreview(company: SampleCompany) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = company.logo),
                contentDescription = "${company.name} logo",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = company.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = company.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}