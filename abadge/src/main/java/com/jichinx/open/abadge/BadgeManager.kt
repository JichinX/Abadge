package com.jichinx.open.abadge

import android.content.Context
import android.os.Build
import android.util.Log
import com.jichinx.open.abadge.brand.HuaWeiImpl
import com.jichinx.open.abadge.brand.OppoImpl
import com.jichinx.open.abadge.brand.VivoImpl
import com.jichinx.open.abadge.brand.XiaoMiImpl

object BadgeManager {

    private val TAG: String = "BadgeManager"

    interface IMPL {
        fun setBadgeNumber(number: Int = 0)
    }

    fun from(context: Context): IMPL {
        return when (Build.MANUFACTURER.lowercase()) {
            MobileBrand.HUAWEI.lowercase() -> HuaWeiImpl(context)
            MobileBrand.XIAOMI.lowercase() -> XiaoMiImpl(context)
            MobileBrand.VIVO.lowercase() -> VivoImpl(context)
            MobileBrand.OPPO.lowercase() -> OppoImpl(context)
            else -> BaseImpl()
        }
    }

    class BaseImpl : IMPL {
        override fun setBadgeNumber(number: Int) {
            // 。。。
            Log.d(TAG, "setBadgeNumber: from brand ${Build.MANUFACTURER}")
        }
    }
}