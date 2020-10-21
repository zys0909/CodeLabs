package com.leecode.array

/**
如何在未排序整数数组中找到最大值和最小值?
 */

fun main(args: Array<String>) {
    function(intArrayOf(3, 4, 67, 8, 99, 0, 2, 45, 2, 322, 5, 55, 22, 745, 6667))
}

fun function(nums: IntArray) {
    if (nums.isEmpty()) return
    var min = nums[0]
    var max = nums[0]
    for (i in nums) {
        if (i < min) {
            min = i
        }
        if (i > max) {
            max = i
        }
    }
    println("min = $min , max = $max ")
}
