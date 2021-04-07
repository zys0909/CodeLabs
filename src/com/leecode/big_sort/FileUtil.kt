package com.leecode.big_sort

import java.io.*


object FileUtil {
    private val pmName = FileUtil::class.java.`package`.name.replace(".", File.separator)
    private val ROOT_PATH = System.getProperty("user.dir")
    private val BASE_DIR = File(ROOT_PATH, "src/$pmName/file")

    fun newFile(fileName: String): File {
        if (!BASE_DIR.exists()) {
            BASE_DIR.mkdirs()
        }
        return File(BASE_DIR, fileName)
    }

    fun newFileWriter(file: File) = FileWriter(file)

    fun newFileWriter(fileName: String) = FileWriter(newFile(fileName))

    fun newBufferReader(file: File): BufferedReader {
        return BufferedReader(InputStreamReader(FileInputStream(file)))
    }

    fun newBufferReader(fileName: String): BufferedReader {
        return BufferedReader(InputStreamReader(FileInputStream(newFile(fileName))))
    }

    fun write(fw: FileWriter, array: IntArray, num: Int) {
        for (i in 0 until num) {
            fw.appendln(array[i].toString())
        }
        fw.flush()
    }

    fun read(br: BufferedReader, array: IntArray): Int {
        var s: String?
        var index = 0
        for (i in array.indices) {
            s = br.readLine()
            if (s.isNullOrEmpty()) {
                break
            } else {
                array[i] = s.toInt()
                index++
            }
        }
        return index
    }

    fun readLine(br: BufferedReader): Int {
        val s: String? = br.readLine()
        return try {
            s?.toInt() ?: -1
        } catch (e: Exception) {
            -1
        }
    }

    fun writeLine(fw: FileWriter, value: Int) {
        fw.appendln(value.toString())
    }
}

fun main() {
    val fw = FileUtil.newFileWriter("test.txt")
    val arr = intArrayOf(11, 33, 66, 99)
    FileUtil.write(fw, arr, arr.size)
    fw.close()

    val br = FileUtil.newBufferReader("test.txt")
    for (i in arr.indices) {
        println(FileUtil.readLine(br))
    }
}