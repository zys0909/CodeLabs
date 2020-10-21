package com.leecode.array

/**
找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
示例 1：
    输入：[2, 3, 1, 0, 2, 5, 3]
    输出：2 或 3
限制：2 <= n <= 100000
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */

/**
 * 用一个容器装已经确定的数
 */
fun findRepeatNumber1(nums: IntArray): Int {
    val map = mutableSetOf<Int>()
    for (i in nums) {
        if (map.contains(i)) {
            return i
        } else {
            map.add(i)
        }
    }
    return -1
}

/**
 * 先排序，再判断相邻的数是否相等
 */
fun findRepeatNumber2(nums: IntArray): Int {
    nums.sort()
    for (i in 1 until nums.size) {
        if (nums[i] == nums[i - 1]) {
            return nums[i]
        }
    }
    return -1
}

/**
 * 所有数字都在长度范围内，将每个数字放到对应的下标位置，判断当前数字是否与该位置的数字相等
 */
fun findRepeatNumber3(nums: IntArray): Int {
    for (i in nums.indices) {
        val n = nums[i]
        if (i != n) {
            if (nums[n] == n) {
                return n
            } else {
                nums[i] = nums[n]
                nums[n] = n
            }
        }
    }
    return -1
}