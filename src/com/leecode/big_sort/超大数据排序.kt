package com.leecode.big_sort

import java.util.*

private const val memory_size = 250000


private fun newFileName(i: Int) = "data$i.txt"

/**
 * 内存中排序，每次排序250000
 */
private fun memorySort(): Int {
    val br = FileUtil.newBufferReader("data.txt")
    var counter = 0
    while (true) {
        val space = IntArray(memory_size)
        val num = FileUtil.read(br, space)
        if (num == 0) {
            break
        }
        Arrays.sort(space)
        val newFileName = newFileName(++counter)
        val writer = FileUtil.newFileWriter(newFileName)
        FileUtil.write(writer, space, num)
        writer.close()
    }
    br.close()
    return counter
}

/**
 * 合并排序
 */
private fun mergeSort(fileNum: Int) {
    if (fileNum <= 0) return
    val fw = FileUtil.newFileWriter("result.txt")
    val fileArray = Array(fileNum) {
        FileUtil.newFile(newFileName(it + 1))
    }
    val brArray = Array(fileNum) {
        FileUtil.newBufferReader(fileArray[it])
    }

    val firstData = IntArray(fileNum) { FileUtil.readLine(brArray[it]) }
    val finish = BooleanArray(fileNum) { false }

    while (true) {

        var index = 0
        while (index < fileNum && finish[index]) {
            index++
        }
        if (index >= fileNum) {
            break
        }
        var minValue = firstData[index]

        for (i in index + 1 until fileNum) {
            if (minValue > firstData[i] && !finish[i]) {
                minValue = firstData[i]
            }
        }
        FileUtil.writeLine(fw, minValue)
        val readLine = FileUtil.readLine(brArray[index])
        if (readLine != -1) {
            firstData[index] = readLine
        } else {
            finish[index] = true
        }
    }
    for (br in brArray) {
        br.close()
    }

    for (file in fileArray){
        file.deleteOnExit()
    }
    fw.close()
}

fun main() {
    val start1 = System.currentTimeMillis()
    val fileNum = memorySort()
    val end1 = System.currentTimeMillis()
    println("\n耗时：${(end1 - start1) / 1000f}ms")

    val start2 = System.currentTimeMillis()
    mergeSort(fileNum)
    val end2 = System.currentTimeMillis()
    println("\n耗时：${(end2 - start2) / 1000f}ms")

}

private fun delete(){
    val fileArray = Array(40) {
        FileUtil.newFile(newFileName(it + 1))
    }
    for (file in fileArray){
        file.deleteOnExit()
    }
}
