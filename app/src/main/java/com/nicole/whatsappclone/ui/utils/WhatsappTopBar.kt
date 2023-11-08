package com.nicole.whatsappclone.ui.utils

import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.nicole.whatsappclone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsappTopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.primary
            )
        },
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Outlined.PhotoCamera, contentDescription = null)
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Outlined.Search, contentDescription = null)
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Outlined.MoreVert, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        )
}