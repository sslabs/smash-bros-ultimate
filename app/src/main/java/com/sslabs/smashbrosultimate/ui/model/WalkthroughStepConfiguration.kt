package com.sslabs.smashbrosultimate.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WalkthroughStepConfiguration(
    @StringRes val headerId: Int,
    @DrawableRes val fighterDrawableId: Int
)