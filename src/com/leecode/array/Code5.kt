package com.leecode.array

/**
一个巨大无序数组中，查找一个不连续的自然数的节点，例如1，2，3，5，6，7...第一个不连续自然数的节点 是4
 */

fun main() {
    val arr = intArrayOf(1, 2, 3, 5, 6, 7)
    println(missingNum(arr))
}

fun missingNum(nums: IntArray): Int {
    for (i in 1 until nums.size) {
        if (nums[i] == nums[i - 1] + 1) {
            continue
        } else {
            return nums[i - 1] + 1
        }
    }
    return 0;
}
