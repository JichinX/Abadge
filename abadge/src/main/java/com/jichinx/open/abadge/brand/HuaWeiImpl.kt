package com.jichinx.open.abadge.brand

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.jichinx.open.abadge.BadgeManager


class HuaWeiImpl(private val context: Context) : BadgeManager.IMPL {
    companion object {
        private const val TAG = "BadgeManager-HuaWeiImpl"
    }

    override fun setBadgeNumber(number: Int) {
        Log.d(TAG, "setBadgeNumber: $number")
        try {
            val useNumber =
                if (number < 0) {
                    0
                } else {
                    number
                }
            val bundle = Bundle()
            bundle.putString("package", context.packageName)
            val launchClassName = context.packageManager.getLaunchIntentForPackage(context.packageName)!!
                .component!!.className
            bundle.putString("class", launchClassName)
            bundle.putInt("badgenumber", useNumber)
            context.contentResolver.call(
                Uri.parse("content://com.huawei.android.launcher.settings/badge/"),
                "change_badge",
                null,
                bundle
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}