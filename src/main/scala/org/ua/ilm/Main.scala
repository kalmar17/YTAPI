package org.ua.ilm

import java.io.{File, FileNotFoundException}

import org.ua.ilm.datamining.crawlers.youtube.ParallelCrawlerChannels
import org.ua.ilm.entity.parse.ParallelYouTubeChannelParser
import org.ua.ilm.datastore.io.config.reader.ConfigurationFileReader
import org.ua.ilm.datastore.io.reader.FileReader
import org.ua.ilm.datastore.io.writer.FileWriter

import scala.util.{Failure, Success, Try}

object Main {
  def main(args: Array[String]): Unit = {
    val partConfigFile = "application.conf"
    val key = args.headOption
    val pathSaveResult = args.lift(1)
    val partChannels = args.lift(2)
    val idChannels = args.lift(3)
    val numberOfThreads = args.lift(4)
    if (key.isDefined) {

      val config = new ConfigurationFileReader(partConfigFile)

      val pathOutFile = new File(pathSaveResult.getOrElse(config.paramConfig("channelResultPath")))
      val channelIds = new File(idChannels.getOrElse(config.paramConfig("channelsId")))

      val channelIdsReader = new FileReader(channelIds).readFileWithSeparator()
      val channelIdsArr = channelIdsReader.split(',')

      val crawler = new ParallelCrawlerChannels(key.get, channelIdsArr, partChannels, numberOfThreads.get.toInt)
      val channelJsons = crawler.getChannelJsons

      val writer = new FileWriter(pathOutFile)
      val result = Try(writer.writeFile(channelJsons))
      result match {
        case Success(value) => println("It`s OK!")
        case Failure(exception: FileNotFoundException) => println("No such file: " + exception)
        case Failure(ex) => println(ex)
      }
      val channelList = new ParallelYouTubeChannelParser(numberOfThreads.get.toInt).getChannels(channelJsons)
      channelList.foreach(println)
    }
    else
      println("key is empty")
  }

}
