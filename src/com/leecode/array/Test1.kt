package com.leecode.array

/**
 */

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 7, 8, 9)

    println(binarySearch(arr, arr.size, 6))

    println(Integer.toBinaryString(5))
    println(Integer.toBinaryString(-6))
}


/**
 * 二分查找
 */
fun binarySearch(array: IntArray, size: Int, value: Int): Int {
    var lo = 0
    var hi = size - 1
    while (lo <= hi) {
        val mid = lo + hi ushr 1
        val midVal = array[mid]
        when {
            midVal < value -> {
                lo = mid + 1
            }
            midVal > value -> {
                hi = mid - 1
            }
            else -> {
                return mid // value found
            }
        }
    }
    return lo.inv() // value not present
}