package com.bogtech.core.data

import com.bogtech.core.data.network.FinanceApis
import com.bogtech.core.data.network.InsightApis
import com.bogtech.core.data.network.ScreenerApis

class ServiceManager {

    val financeApis: FinanceApis = FinanceApis()
    val screenerApis: ScreenerApis = ScreenerApis()
    val insightApis: InsightApis = InsightApis()

    class Holder {
        fun getInstance(): ServiceManager {
            return Holder.INSTANCE
        }

        private object Holder {
            val INSTANCE by lazy { ServiceManager() }
        }
    }

}