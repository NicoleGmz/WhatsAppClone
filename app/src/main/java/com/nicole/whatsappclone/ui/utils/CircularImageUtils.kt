package com.nicole.whatsappclone.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nicole.whatsappclone.R
import androidx.compose.ui.graphics.drawscope.Stroke
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme


@Composable
fun CircularImageWithCircularIcon(
    imageResId: Int,
    icon: ImageVector = Icons.Default.Add,
    iconSize: Dp = 12.dp
) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .padding(8.dp)
            .background(Color.Transparent, CircleShape)
    ) {
        // Circular image
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null, // Provide a meaningful description
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )

        // Small circle with an icon
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(Color(0xFF25D366), CircleShape)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null, // Provide a meaningful description
                tint = Color.White,
                modifier = Modifier.size(iconSize).align(alignment = Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CircularImageWithIconPreview() {
    WhatsAppCloneTheme {
        CircularImageWithCircularIcon(imageResId = R.drawable.leio_mclaren_l2dtmhqzx4q_unsplash)
    }
}

/*
*
* ANOTHER WAY BUT INCOMPLETE
@Composable
fun CircularImageWithCircularIcon2(){
    Image(
        painter = painterResource(R.drawable.leio_mclaren_l2dtmhqzx4q_unsplash),
        contentDescription = "User/Group profile image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(48.dp)
            .aspectRatio(1f)
            .graphicsLayer {
                compositingStrategy = CompositingStrategy.Offscreen
            }
            .drawWithCache {
                val path = Path()
                path.addOval(
                    Rect(
                        topLeft = Offset.Zero,
                        bottomRight = Offset(size.width, size.height)
                    )
                )
                onDrawWithContent {
                    clipPath(path) {
                        // this draws the actual image - if you don't call drawContent, it wont
                        // render anything
                        this@onDrawWithContent.drawContent()
                    }
                    val dotSize = size.width / 6f
                    // Clip a white border for the content
                    drawCircle(
                        Color.Black,
                        radius = dotSize,
                        center = Offset(
                            x = size.width - dotSize,
                            y = size.height - dotSize
                        ),
                        blendMode = BlendMode.Clear
                    )
                    // draw the red circle indication
                    drawCircle(
                        Color(0xFFEF5350), radius = dotSize * 0.8f,
                        center = Offset(
                            x = size.width - dotSize,
                            y = size.height - dotSize
                        )
                    )

                }

            }
    )
}*/


@Composable
fun CircularImageWithDashedBorder(partitions: Int){

    Box(modifier = Modifier
        .size(56.dp)
        .padding(8.dp)
        .background(Color.Transparent, CircleShape)
        .drawBehind {

            val segmentsToDraw = getSegmentList(partitions)

            segmentsToDraw.startingAngle.forEach {
                drawArc(
                    color = Color(0xFF25D366),
                    startAngle = it,
                    sweepAngle = segmentsToDraw.sweep,
                    useCenter = true,
                    style = Stroke(width = 3.dp.toPx())
                )
            }
        }
    ){
        Image(
            painter = painterResource(id = R.drawable.leio_mclaren_l2dtmhqzx4q_unsplash),
            contentDescription = null, // Provide a meaningful description
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

data class SegmentsToDraw( val nSegments: Int, val sweep: Float, val startingAngle: List<Float>)
fun getSegmentList(nSegments: Int): SegmentsToDraw{
    var returnSegments = nSegments
    return if(nSegments > 1){
        if(nSegments > 8){
            returnSegments = 8
        }
        val sweep = (360f - (15f * returnSegments)) / returnSegments
        var startingAngle = 0f
        val startingAngleList = mutableListOf<Float>()
        for(n in 0..returnSegments){
            startingAngleList.add(startingAngle)
            startingAngle += sweep + 15f
        }
        SegmentsToDraw(returnSegments, sweep, startingAngleList)
    }else{
        SegmentsToDraw(returnSegments, 360f, listOf(0f))
    }
}

@Preview(showBackground = true)
@Composable
fun CircularImageWithDashedBorderPreview(){
    WhatsAppCloneTheme {
        CircularImageWithDashedBorder(1)
    }
}
@Preview(showBackground = true)
@Composable
fun CircularImageWithDashedBorderPreview2(){
    WhatsAppCloneTheme {
        CircularImageWithDashedBorder(4)
    }
}

