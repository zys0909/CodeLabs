package com.leecode.link

/**
一个数组插入删除查找和链表的效率对比?如果一个数组要反复插入删除怎么优化降低时间复杂度?
(一开始 没想到，面试官提示其实就是垃圾回收的算法 原理就是“标记-查找”。
每次删除的时候元素不是真的被删除了， 而是先标记，最后统一移动数组元素，减少移动次数)
 */