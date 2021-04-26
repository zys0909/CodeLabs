package com.leecode.sort

fun main() {
    val arr = MakeArray.array
    bubbleSort3(arr)
    println(arr.joinToString())
}


/**
 * 冒泡排序
 */
private fun bubbleSort(array: IntArray) {
    if (array.isEmpty()) {
        return
    }
    val len = array.size    //确定排序趟数
    for (i in 0 until len) {
        for (j in 0 until len - 1 - i) {    //确定比较次数
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

/**
 * 优化一，增加标识位，对于已经有序的数据，无需再排序
 * 例如：{1,2,3,4,5,6,7,8,10,9}这组数据
 */
private fun bubbleSort1(array: IntArray) {
    if (array.isEmpty()) {
        return
    }
    val len = array.size
    for (i in 0 until len) {
        var flag = true
        for (j in 0 until len - 1 - i) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
                flag = false
            }
        }
        if (flag) {//如果没有交换过元素，则已经有序
            break
        }
    }
}

/**
 * 优化二，记下最后一次交换的位置，后边没有交换，必然是有序的，然后下一次排序从第一个比较到上次记录的位置结束即可。
 */
private fun bubbleSort2(array: IntArray) {
    if (array.isEmpty()) {
        return
    }
    val len = array.size
    var flag: Boolean
    var k = len - 1
    var pos = 0     //用来记录最后一次交换的位置
    for (i in 0 until len) {
        flag = true
        for (j in 0 until k) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
                flag = false
                pos = j //交换元素后，记录最后一次交换的位置
            }
        }
        if (flag) {     //如果没有交换过元素，则已经有序
            break
        }
        k = pos     //下一次比较到记录位置即可
    }
}

/**
 * 优化三，大致思想就是一次排序可以确定两个值，正向扫描找到最大值交换到最后，反向扫描找到最小值交换到最前面
 */
private fun bubbleSort3(array: IntArray) {
    if (array.isEmpty()) {
        return
    }
    val len = array.size
    var k = len - 1
    var pos: Int     //用来记录最后一次交换的位置
    var flag: Boolean
    for (i in 0 until len - 1) {
        pos = 0
        flag = true
        //正向寻找最大值
        for (j in i until k) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
                flag = false
                pos = j
            }
        }
        if (flag) {//如果没有交换过元素，则已经有序,直接结束
            break
        }
        k = pos
        //反向寻找最小值
        for (j in k downTo i + 1) {
            if (array[j] < array[j - 1]) {
                val temp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = temp
                flag = false
            }
        }
        if (flag) {//如果没有交换过元素，则已经有序,直接结束
            break
        }
    }
}