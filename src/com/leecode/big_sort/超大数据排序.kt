package com.leecode.big_sort

import com.leecode.printTime
import java.util.*

private const val memory_size = 250000


private fun newFileName(i: Int) = "data$i.txt"

/**
 * 交换两个值，异或法
 */
@Suppress("NOTHING_TO_INLINE")
private inline fun swap(arr: IntArray, x: Int, y: Int) {
    arr[x] = arr[x] xor arr[y]
    arr[y] = arr[x] xor arr[y]
    arr[x] = arr[x] xor arr[y]
}

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
                index = i
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

    for (file in fileArray) {
        file.deleteOnExit()
    }
    fw.close()
}

fun main() {

    val fileNum = printTime {
        memorySort()
    }

    printTime {
        mergeSort(fileNum)
    }

}

private fun delete(fileNum: Int) {
    val fileArray = Array(fileNum) {
        FileUtil.newFile(newFileName(it + 1))
    }
    for (file in fileArray) {
        file.deleteOnExit()
    }
}
