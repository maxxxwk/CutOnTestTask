package com.maxxxwk.testtask.common.result

@Suppress("TooGenericExceptionCaught")
suspend inline fun <T> wrapResult(crossinline action: suspend () -> T): Result<T> = try {
    Result.success(action())
} catch (t: Throwable) {
    Result.failure(t)
}
