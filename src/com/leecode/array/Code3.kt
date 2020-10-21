package com.leecode.array

/**
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
示例：
    输入：nums = [1,2,3,4]
    输出：[1,3,2,4]
    注：[3,1,2,4] 也是正确的答案之一。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 */
/**
 * 申请一个新数组，T(n) ,O(n)
 */
fun exchange1(nums: IntArray): IntArray {
    var start = 0
    var end = nums.size - 1
    val temp = IntArray(nums.size)
    for (i in nums.indices) {
        if (nums[i].and(1) == 1) {
            temp[start++] = nums[i]
        } else {
            temp[end--] = nums[i]
        }
    }
    return temp
}

/**
 * 双指针法，T(n2),O(1)
 * start 从前往后找第一个偶数，end从后往前找最后一个奇数，找到后交换位置
 */
fun exchange2(nums: IntArray): IntArray {
    var start = 0
    var end = nums.size - 1
    var temp: Int
    while (start < end) {
        while (start < end && nums[start].and(1) == 1) {
            start++
        }
        while (start < end && nums[end].and(1) == 0) {
            end--
        }
        if (start < end) {
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
        }
    }
    return nums
}

/**
 * 快慢指针
 */
fun exchange3(nums: IntArray): IntArray {
    var i = 0
    var j = 0
    var temp: Int
    while (i < nums.size) {
        if (nums[i].and(1) == 1) {
            if (i != j) {
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
            }
            j++
        }
        i++
    }
    return nums
}