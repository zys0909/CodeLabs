package com.leecode.sort

import com.leecode.big_sort.InsertionSort
import com.leecode.printTime
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ForkJoinTask
import java.util.concurrent.RecursiveTask

/**
 * JDK 内置的 ForkJoinTask
 */
object ForkJoin {
    private class SunTask(private val src: IntArray) : RecursiveTask<IntArray>() {
        companion object {
            private const val MIN_SIZE = 2
        }

        override fun compute(): IntArray {
            return if (src.size <= MIN_SIZE) {
                InsertionSort.sort(src)
            } else {
                val mid = src.size / 2
                val left = SunTask(src.copyOfRange(0, mid))
                val right = SunTask(src.copyOfRange(mid, src.size))
                ForkJoinTask.invokeAll(left, right)
                val joinLeft = left.join()
                val joinRight = right.join()
                merge(joinLeft, joinRight)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val pool = ForkJoinPool()
        val src = MakeArray.makeArray(40000)
        val result = printTime {
            pool.invoke(SunTask(src))
        }
        println(result.joinToString())
    }
}