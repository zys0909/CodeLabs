package com.leecode.sort

import kotlin.random.Random

const val ArrayLength = 40000
const val MinSize = 40

fun makeArray(): IntArray {
    val array = IntArray(ArrayLength)
    val default = Random.Default
    for (i in 0 until ArrayLength) {
        array[i] = default.nextInt(ArrayLength * 3)
    }
    return array;
}