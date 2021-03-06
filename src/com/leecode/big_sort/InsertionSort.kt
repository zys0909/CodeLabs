package com.leecode.big_sort


object InsertionSort {

    /**
     * 简单插入排序（升序）
     */
    fun sort(arr: IntArray): IntArray {
        if (arr.isEmpty()) {
            return arr
        }
        //当前待排序数据，该元素之前的数据都已经被排序过
        var curValue: Int
        for (i in 0 until arr.size - 1) {
            //已被排序数据的索引
            var preIndex = i
            curValue = arr[preIndex + 1]
            //在已排序过数据中，倒序寻找合适的位置，
            //如果当前待排序数据比要比较的数据小，将比较的元素后移一位
            while (preIndex >= 0 && curValue < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex]
                preIndex--
            }
            //while循环结束时，说明已经找到了合适的位置
            arr[preIndex + 1] = curValue
        }
        return arr
    }
}