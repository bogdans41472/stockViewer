package com.bogtech.core

import io.reactivex.rxjava3.core.Completable

interface Sdk {

    fun initializeWithToken(token: String): Completable

    companion object {
        fun getInstance(): Sdk {
            return SdkImpl.getInstance()
        }
    }
}