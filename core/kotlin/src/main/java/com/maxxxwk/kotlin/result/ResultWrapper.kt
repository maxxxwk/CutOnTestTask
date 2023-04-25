package com.maxxxwk.kotlin.result

@Suppress("TooGenericExceptionCaught")
suspend inline fun <T> wrapResult(crossinline action: suspend () -> T): Result<T> = try {
    Result.success(action())
} catch (t: Throwable) {
    Result.failure(t)
}

suspend inline fun <T> wrapEmptyResult(crossinline action: suspend () -> T): Result<Unit> = try {
    action()
    Result.success(Unit)
} catch (t: Throwable) {
    Result.failure(t)
}
