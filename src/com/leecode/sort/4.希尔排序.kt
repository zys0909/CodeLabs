package com.leecode.sort

fun main() {
    val arr = MakeArray.array
    shellSort(arr)
    println(arr.joinToString())
}

/**
 * 希尔排序
 */
private fun shellSort(array: IntArray) {
    if (array.isEmpty()) {
        return
    }
    val len = array.size
    var gap = len / 2
    var temp: Int
    while (gap > 0) {
        for (i in gap until len) {
            temp = array[i]
            var preIndex = i - gap
            while (preIndex >= 0 && array[preIndex] > temp) {
                array[preIndex + gap] = array[preIndex]
                preIndex -= gap
            }
            array[preIndex + gap] = temp
        }
        gap /= 2
    }
}