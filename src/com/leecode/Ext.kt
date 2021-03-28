package com.leecode


inline fun <T> printTime(crossinline block: () -> T): T {
    val start = System.currentTimeMillis()
    val invoke = block.invoke()
    val end = System.currentTimeMillis()
    println("执行时间 === ${end - start}ms")
    return invoke
}