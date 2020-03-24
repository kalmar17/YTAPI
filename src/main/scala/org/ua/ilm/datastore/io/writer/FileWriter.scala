package org.ua.ilm.datastore.io.writer

import java.io.{BufferedWriter, File}

class FileWriter(val file: File) {
  val bw = new BufferedWriter(new java.io.FileWriter(file))
  def writeFile(str: String): Unit = {
    try bw.write(str)
    finally bw.close()
  }
  def writeFile(arr:Array[String]): Unit ={
    val s = arr.mkString("")
    try bw.write(s)
    finally bw.close()
  }
}
