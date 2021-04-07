package com.leecode.big_sort

/**
 * 1.引入临时变量
 */
inline fun swap1(arr: IntArray, x: Int, y: Int) {
    val temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp
}

/**
 * 2.用加减法，会产生数值溢出
 * 无需引入临时变量
 */
inline fun swap2(arr: IntArray, x: Int, y: Int) {
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
}

fun main() {
    var a: Int = Int.MAX_VALUE
    var b: Int = 16

    println("前： a = $a ,b = $b")
    a += b
    println("a+b=$a")
    b = a - b
    println("a-b=$b")
    a -= b
    println("后： a = $a ,b = $b")
}