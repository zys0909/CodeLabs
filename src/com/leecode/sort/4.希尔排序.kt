package com.leecode.sort

fun main() {
    val arr = intArrayOf(66, 11,57, 3, 45, 63, 28, 29, 4, 2, 15, 40, 42, 46, 52, 55, 57,  63)
    shellSort(arr)
    println(arr.joinToString())
}

private fun shellSort(array: IntArray){
    if (array.isEmpty()){
        return
    }

}