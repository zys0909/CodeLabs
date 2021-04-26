package com.leecode.sort

import com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY
import kotlin.random.Random


object MakeArray {
    private const val ArrayLength = 40000
    const val MinSize = 40

    fun makeArray(length: Int): IntArray {
        val array = IntArray(length)
        val default = Random.Default
        for (i in 0 until length) {
            array[i] = default.nextInt(length * 3)
        }
        return array;
    }

    val array = intArrayOf(66, 11, 57, 3, 45, 63, 28, 29, 4, 2, 15, 40, 42, 46, 52, 55, 57, 63)
}

fun main() {
    var a = 1
    val b = 16
//    while (a < b) {
//        a = a.shl(1)
//    }
    a= tableSizeFor(16)
    println("a = $a")
}

/**
 * HashMap 根据cap计算数组长度的方法
 * 数组长度始终是最接近cap的2的冥
 */
fun tableSizeFor(cap: Int): Int {
    var n = cap - 1
    n = n or (n ushr 1) //无符号右移
    n = n or (n ushr 2)
    n = n or (n ushr 4)
    n = n or (n ushr 8)
    n = n or (n ushr 16)
    return if (n < 0) 1 else if (n >= MAXIMUM_CAPACITY) MAXIMUM_CAPACITY else n + 1
}
/**
 * 分析：cap = 11
 * n = cap - 1 = 10
 * n = n or (n ushr 1)
 *          0000 0000 0000 0000 0000 0000 0000 1010
 *  n>>>1   0000 0000 0000 0000 0000 0000 0000 0101
 *  or      0000 0000 0000 0000 0000 0000 0000 1111
 *
 * >>>2     0000 0000 0000 0000 0000 0000 0000 0011
 * or       0000 0000 0000 0000 0000 0000 0000 1111
 *
 * ....
 *
 * 最终得到 0000 0000 0000 0000 0000 0000 0000 1111
 *  n = 15
 *
 *  n = n + 1 = 16
 */