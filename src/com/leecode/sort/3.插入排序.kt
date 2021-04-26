package com.leecode.sort

fun main() {
    val arr = MakeArray.array
    insertSort(arr)
    println(arr.joinToString())
}

/**
 * 简单插入排序（升序）
 */
private fun insertSort(arr: IntArray) {
    if (arr.isEmpty()) {
        return
    }
    //当前待排序数据，该元素之前的数据都已经被排序过
    var curValue: Int
    for (i in 1 until arr.size) {
        //已被排序数据的索引
        var preIndex = i
        curValue = arr[preIndex]
        //在已排序过数据中，倒序寻找合适的位置，
        //如果当前待排序数据比要比较的数据小，将比较的元素后移一位
        while (preIndex > 0 && curValue < arr[preIndex - 1]) {
            arr[preIndex] = arr[preIndex - 1]
            preIndex--
        }
        //while循环结束时，说明已经找到了合适的位置
        if (preIndex != i) {
            arr[preIndex] = curValue
        }
    }
}