package com.leecode.sort

import com.leecode.printTime


/**
 * 归并排序
 */

fun main() {
    val start = System.currentTimeMillis()
    val result = printTime {
        MergeSort.sort(makeArray())
    }
    print(result.joinToString())
}

object MergeSort {
    fun sort(array: IntArray): IntArray {
        return if (array.size <= MinSize) {
            InsertionSort.sort(array)
        } else {
            val mid = array.size / 2
            val left = array.copyOfRange(0, mid)
            val right = array.copyOfRange(mid, array.size)
            merge(InsertionSort.sort(left), InsertionSort.sort(right))
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
}