package org.ua.ilm

import java.io.File

import org.ua.ilm.akka.ParallelActorMain
import org.ua.ilm.datastore.io.config.reader.ConfigurationFileReader
import org.ua.ilm.datastore.io.reader.FileReader

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
      val arrIdChannels = idChannelsReader.split(',')
      val listChannels = ParallelActorMain.parallelCrawlerChannels(key.get, arrIdChannels, partChannels, 5)

      listChannels.foreach(println)
    }
    else
      println("key is empty")
  }
}
