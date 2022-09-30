package com.study.jetpackcomposelayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.study.jetpackcomposelayouts.ui.theme.ComposeStudyTheme

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        // 测量元素
        val placeable = measurable.measure(constraints)

        // 获取元素的基线值
        val firstBaseLine= placeable[FirstBaseline]
        // 元素新的Y坐标=新基线值-旧基线值
        val placeableY=firstBaselineToTop.roundToPx()-firstBaseLine
        layout(0, 0) {
            // 设置元素的位置
            placeable.placeRelative(0,placeableY)
        }
    }
)

@Composable
fun TextWithPaddingToBaseline() {
    ComposeStudyTheme {
        Text(
            text = "Hi there!",
            Modifier
                .firstBaselineToTop(24.dp)
                .background(Color.Red)
        )
    }
}