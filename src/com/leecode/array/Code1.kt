package com.leecode.array

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
如何在一个1到100的整数数组中找到丢失的数字? google, Amazon,tencent
示例 1:
    输入: [0,1,3]
    输出: 2
示例 2:
    输入: [0,1,2]
    输出: 3
示例 3:
    输入: [0,1,2,3,4,5,6,7,9]
    输出: 8
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 */

/**
 *
 * 直接遍历
 */
fun missingNumber1(nums: IntArray): Int {
    var result: Int = 0
    for (i in nums) {
        if (i != result) {
            break
        }
        result++
    }
    return result
}

/**
 * 二手分查找法
 */
fun missingNumber2(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1
    if (nums[end] == end) {
        return end + 1
    }
    while (start < end) {
        val mid = (start + end) / 2
        if (nums[mid] != mid) {
            end = mid
        } else {
            start = mid + 1
        }
    }
    return start
}