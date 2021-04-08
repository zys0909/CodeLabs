package com.leecode

/**
 * 计算执行时间
 */
inline fun <T> printTime(crossinline block: () -> T): T {
    val start = System.currentTimeMillis()
    val invoke = block.invoke()
    val end = System.currentTimeMillis()
    println("执行时间 === ${(end - start) / 1000f}s")
    return invoke
}