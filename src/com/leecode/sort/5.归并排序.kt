package com.leecode.sort


/**
 * 归并排序
 */

fun main() {
    val start = System.currentTimeMillis()
    val result=  mergeSort1(MakeArray.makeArray(4000),10)
    val end = System.currentTimeMillis()

    println(result.joinToString())
    println("执行时间 === ${(end - start) / 1000f}s")
}

/**
 * 二路归并
 */
private fun mergeSort(array: IntArray): IntArray {
    return if (array.size < 2) {
        array
    } else {
        val mid = array.size / 2
        val left = array.copyOfRange(0, mid)
        val right = array.copyOfRange(mid, array.size)
        merge(mergeSort(left), mergeSort(right))
    }
}

/**
 * 多路归并
 */
private fun mergeSort1(array: IntArray, minSize: Int): IntArray {
    return if (array.size <= minSize) {
        insertSort(array)
    } else {
        val mid = array.size / 2
        val left = array.copyOfRange(0, mid)
        val right = array.copyOfRange(mid, array.size)
        merge(mergeSort(left), mergeSort(right))
    }
}

/**
 * 归并排序：将两段排序好的数组，合成一个排序数组
 */
fun merge(left: IntArray, right: IntArray): IntArray {
    val result = IntArray(left.size + right.size)
    var index = 0
    var i = 0
    var j = 0
    while (index < result.size) {
        when {
            i >= left.size -> result[index] = right[j++]
            j >= right.size -> result[index] = left[i++]
            left[i] > right[j] -> result[index] = right[j++]
            else -> result[index] = left[i++]
        }
        index++
    }
    return result
}

/**
 * 简单插入排序（升序）
 */
private fun insertSort(arr: IntArray): IntArray {
    if (arr.isEmpty()) {
        return arr
    }
    //当前待排序数据，该元素之前的数据都已经被排序过
    var curValue: Int
    val len = arr.size
    for (i in 1 until len) {
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
    return arr
}