package com.jichinx.open.abadge.brand

import android.content.Context
import android.util.Log
import com.jichinx.open.abadge.BadgeManager

class VivoImpl(val context: Context) : BadgeManager.IMPL {
    companion object {
        private const val TAG = "BadgeManager-VivoImpl"
    }

    override fun setBadgeNumber(number: Int) {
        Log.d(TAG, "setBadgeNumber: $number")
    }
}