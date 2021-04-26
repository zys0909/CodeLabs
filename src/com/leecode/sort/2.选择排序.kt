package com.leecode.sort

fun main() {
    val arr = MakeArray.array
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