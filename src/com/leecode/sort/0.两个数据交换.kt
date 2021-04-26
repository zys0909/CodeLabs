package com.leecode.sort

/**
 * 1.引入临时变量
 */
fun swap1(arr: IntArray, x: Int, y: Int) {
    val temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp
}

/**
 * 2.用加减法，会产生数值溢出
 * 无需引入临时变量
 */
fun swap2(arr: IntArray, x: Int, y: Int) {
    arr[x] = arr[x] + arr[y]
    arr[y] = arr[x] - arr[y]
    arr[x] = arr[x] - arr[y]
}

/**
 * 3.用异或操作符
 * 无需引入临时变量
 */
fun swap3(arr: IntArray, x: Int, y: Int) {
    arr[x] = arr[x] xor arr[y]
    arr[y] = arr[x] xor arr[y]
    arr[x] = arr[x] xor arr[y]
}

/**
 * 无需引入临时变量
 */
fun swap4(arr: IntArray, x: Int, y: Int) {
//    arr[x].toLong().shl(32).or(arr[y])
//    arr[y] = (arr[x]+arr[y]) - (arr[x] = arr[y])
}

fun main() {
    val arr = intArrayOf(Int.MAX_VALUE, 16)
    println("初始值：arr[0] = ${arr[0]} , arr[1] = ${arr[1]}")
    swap1(arr, 0, 1)
    println("中间值交换：arr[0] = ${arr[0]} , arr[1] = ${arr[1]}")
    swap2(arr, 0, 1)
    println("加减法交换：arr[0] = ${arr[0]} , arr[1] = ${arr[1]}")
    swap3(arr, 0, 1)
    println("异或法交换：arr[0] = ${arr[0]} , arr[1] = ${arr[1]}")
}