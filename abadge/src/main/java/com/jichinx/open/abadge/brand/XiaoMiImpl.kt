package com.jichinx.open.abadge.brand

import android.content.Context
import android.util.Log
import com.jichinx.open.abadge.BadgeManager

class XiaoMiImpl(val context: Context) : BadgeManager.IMPL {
    companion object {
        private const val TAG = "BadgeManager-XiaoMiImpl"
    }

    override fun setBadgeNumber(number: Int) {
        Log.d(TAG, "setBadgeNumber: $number")
    }
}