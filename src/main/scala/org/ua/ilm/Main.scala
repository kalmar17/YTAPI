package org.ua.ilm

import java.io.{File, FileNotFoundException}

import com.fasterxml.jackson.core.{JsonFactory, JsonParser}
import org.ua.ilm.Entity.{Channel, JsonPars}
import org.ua.ilm.datamining.crawlers.youtube.CrawlerChannels
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

    if (key.isDefined) {
      val config = new ConfigurationFileReader(partConfigFile)

      val pathOutFile = new File(pathSaveResult.getOrElse(config.paramConfig("channelResultPath")))
      val idChannelsFile = new File(idChannels.getOrElse(config.paramConfig("channelsId")))

      val idChannelsReader = new FileReader(idChannelsFile).readFileWithSeparator()
      val youTubeCrawlerChannels = new CrawlerChannels(key.get, idChannelsReader, partChannels)
      val youTubeRequestStr = youTubeCrawlerChannels.channelListRequest()

      val writer = new FileWriter(pathOutFile)
      val result = Try(writer.writeFile(youTubeRequestStr.toPrettyString))
      result match {
        case Success(value) => println("It`s OK!")
        case Failure(exception: FileNotFoundException) => println("No such file: " + exception)
        case Failure(ex) => println(ex)
      }
      val list = for {y <- youTubeRequestStr.getItems.toArray} yield JsonPars.parsJsonToChannel(y.toString)
      list.foreach(println)
    }
    else
      println("key is empty")
  }

}
