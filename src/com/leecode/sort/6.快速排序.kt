package com.leecode.sort


fun main() {
    val arr = MakeArray.array

    quickSort(arr, 0, arr.size - 1)
    println(arr.joinToString())
}

/**
 * 快速排序
 */
private fun quickSort(array: IntArray, start: Int, end: Int) {
    if (array.isEmpty() || start < 0 || end >= array.size || start > end) {
        return
    }
    val pivot = array[start]
    var i = start
    var j = end
    while (i < j) {
        // 从右向左找第一个小于pivot的数
        while (i < j && array[j] >= pivot) j--

        if (i < j) {
            array[i] = array[j]
            i++
        }
        // 从左向右找第一个大于等于pivot的数
        while (i < j && array[i] < pivot) i++
        if (i < j) {
            array[j] = array[i]
            j--
        }
    }
    array[i] = pivot
    //递归调用
    quickSort(array, start, i - 1)
    quickSort(array, i + 1, end)
}