package com.leecode.big_sort

import kotlin.random.Random


private fun writeData() {
    val size = big_size
    val random = Random.Default
    val num = IntArray(size)
    //生成1千万哥数
    for (n in 1..size) {
        num[n - 1] = n
    }
    //随机打乱顺序
    var i: Int
    var j: Int
    for (n in 0 until size) {
        i = random.nextInt(Int.MAX_VALUE) % size
        j = random.nextInt(Int.MAX_VALUE) % size
        swap1(num, i, j)
    }
    //写入文件
    val fw = FileUtil.newFileWriter(fileName)
    FileUtil.write(fw, num, num.size)
    fw.close()
}

private fun readData(fileName: String, size: Int) {
    val fr = FileUtil.newBufferReader(fileName)
    var line = 0
    var s: String
    while (line <= size) {
        s = fr.readLine()
        if (s.isEmpty()) {
            break
        } else {
            println(s)
        }
        line++
    }
}

private const val fileName = "data.txt"
private const val big_size = 1000 * 10000

fun main() {
    val start = System.currentTimeMillis()
    writeData()


//    readData(fileName, 10)

    val end = System.currentTimeMillis()
    println("\n耗时：${(end - start) / 1000f}ms")
}