package org.ua.ilm.datastore.io.writer

import java.io.{BufferedWriter, File}

class FileWriter(val file: File) {
  val bw = new BufferedWriter(new java.io.FileWriter(file))
  def writeFile(s: String): Unit = {

    try bw.write(s)
    finally bw.close()
  }
  def writeFile(list:Array[String]): Unit ={
    val s = list.mkString("")
    try bw.write(s)
    finally bw.close()
  }
}
