package com.leecode.array

import kotlin.math.pow

/**
给定一个二进制数据位数，输出所有2进制数所对应的所有的自然数，要求时间复杂度优先
 */
fun main() {
    println(allBinary1(3).joinToString())
}

fun allBinary1(binarySize: Int): Array<String?> {
    val max = 2.0.pow(binarySize.toDouble()).toInt()
    val arr = arrayOfNulls<String>(max)
    for (i in 0 until max) {
        arr[i] = decTBinary(i, binarySize)
    }
    return arr
}

fun Int.decTBinaryForJdk(): String = Integer.toBinaryString(this)

/**
 * 将一个整数转为一个指定位数的二进制数
 */
fun decTBinary(number: Int, byteSize: Int): String {
    val result = StringBuilder()
    for (i in byteSize - 1 downTo 0) {
        val mask = number.and(1 shl i)
        result.append(if (mask != 0) "1" else "0")
    }
    return result.toString()
}