package com.leecode.sort

fun main() {
    val arr = intArrayOf(66, 11,57, 3, 45, 63, 28, 29, 4, 2, 15, 40, 42, 46, 52, 55, 57,  63)
    selectionSort(arr)
    println(arr.joinToString())
}

/**
 * 选择排序
 */
private fun selectionSort(array: IntArray) {
    if (array.isEmpty()) {
        return
    }
    val len = array.size
    var minIndex: Int
    for (i in 0 until len) {
        minIndex = i
        for (j in i until len) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }
        val temp = array[minIndex]
        array[minIndex] = array[i]
        array[i] = temp
    }
}