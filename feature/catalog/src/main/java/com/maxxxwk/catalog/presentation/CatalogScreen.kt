@file:Suppress("FunctionNaming")

package com.maxxxwk.catalog.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.maxxxwk.android.R
import com.maxxxwk.android.text.UIText
import com.maxxxwk.catalog.domain.Brand
import kotlinx.collections.immutable.ImmutableList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun CatalogScreen(viewModel: CatalogScreenViewModel, bottomBar: @Composable () -> Unit) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        bottomBar = bottomBar,
        topBar = { CatalogScreenTopAppBar() }
    ) {
        when (state) {
            is CatalogScreenState.Content -> CatalogScreenContent((state as CatalogScreenState.Content).brands)
            is CatalogScreenState.Error -> CatalogScreenError((state as CatalogScreenState.Error).message)
            CatalogScreenState.Loading -> CatalogScreenLoading()
        }
    }
}

@Composable
private fun CatalogScreenTopAppBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 0.dp,
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.brands_catalog_title),
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
            )
        }
    )
}

@Composable
private fun CatalogScreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = MaterialTheme.colors.secondary)
    }
}

@Composable
private fun CatalogScreenError(message: UIText) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message.asString(),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
private fun CatalogScreenContent(brands: ImmutableList<Brand>) {
    LazyVerticalGrid(
        modifier = Modifier.background(MaterialTheme.colors.primary),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = brands,
            key = { it.brandId }
        ) { BrandItem(it) }
    }
}

@Composable
private fun BrandItem(brand: Brand) {
    Column(
        modifier = Modifier
            .size(120.dp)
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AsyncImage(
            modifier = Modifier.size(80.dp),
            model = brand.brandImage,
            contentDescription = brand.brandName,
            contentScale = ContentScale.Fit
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(
                    Brush.linearGradient(
                        0f to MaterialTheme.colors.secondary,
                        1f to MaterialTheme.colors.primary
                    )
                ),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = brand.brandName,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}
