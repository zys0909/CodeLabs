package com.leecode.test

import java.util.*

/**
 *
 */
fun main() {
    val l1 = ListNode.convert(intArrayOf(7, 2, 4, 3))
    val l2 = ListNode.convert(intArrayOf(5, 6, 4))

    var head= addTwoNumbers(l1, l2)

    val sb = StringBuilder()
    while (head!=null){
        sb.append(head.`val`)
        head = head.next
    }
    println(sb.toString())
}

class ListNode(var `val`: Int = 0, var next: ListNode? = null) {
    companion object {
        fun convert(arr: IntArray?): ListNode? {
            if (arr == null || arr.isEmpty()) {
                return null
            }
            val ln: ListNode? = ListNode(arr[0])
            var l = ln
            val len = arr.size
            for (i in 1 until len) {
                l?.next = ListNode(arr[i])
                l = l?.next
            }
            return ln
        }
    }
}

fun addTwoNumbers(ln1: ListNode?, ln2: ListNode?): ListNode? {
    var l1 = ln1
    var l2 = ln2
    val s1 = Stack<Int>()
    val s2 = Stack<Int>()
    while (l1 != null) {
        s1.push(l1.`val`)
        l1 = l1.next
    }
    while (l2 != null) {
        s2.push(l2.`val`)
        l2 = l2.next
    }
    val s3 = Stack<Int>()
    var last = 0
    while (!(s1.isEmpty() && s2.isEmpty())) {
        if (s1.isEmpty()) {
            s1.push(0)
        }
        if (s2.isEmpty()) {
            s2.push(0)
        }
        val sun = s1.pop() + s2.pop() + last
        last = if (sun > 9) 1 else 0
        s3.push(sun % 10)
    }
    if (last == 1) {
        s3.push(1)
    }
    val ln3 = ListNode(s3.pop())
    var l3: ListNode? = ln3
    while (!s3.isEmpty()) {
        l3!!.next = ListNode(s3.pop())
        l3 = l3.next
    }
    return ln3
}