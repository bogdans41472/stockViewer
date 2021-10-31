package com.bogtech.core

import io.reactivex.rxjava3.core.Completable

class SdkImpl : Sdk {

    var serviceManager: ServiceManager

    override fun initializeWithToken(token: String): Completable {

    }

    companion object {
        fun getInstance(): SdkImpl {
            return Holder.INSTANCE
        }

        private object Holder {
            val INSTANCE by lazy { SdkImpl() }
        }
    }
}
