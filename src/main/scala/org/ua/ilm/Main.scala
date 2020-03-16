package org.ua.ilm

import java.io.{File, FileNotFoundException}
import java.util.concurrent.{Callable, Executors}

import org.ua.ilm.Entity.{Channel, YoutubeChannelParser}
import org.ua.ilm.datamining.crawlers.youtube.{CrawlerChannels, ThreadCrawlerChannels}
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
      val arrIdChannels = idChannelsReader.split(',')

      val listThreadsCrawler = new ThreadCrawlerChannels(key.get, arrIdChannels, partChannels)
      val listJSONChannels = listThreadsCrawler.parallelCrawlerChannels()

      val writer = new FileWriter(pathOutFile)
      val result = Try(writer.writeFile(listJSONChannels))
      result match {
        case Success(value) => println("It`s OK!")
        case Failure(exception: FileNotFoundException) => println("No such file: " + exception)
        case Failure(ex) => println(ex)
      }

      val listChannels = parallelParse(listJSONChannels)
      listChannels.foreach(println)
    }
    else
      println("key is empty")
  }

  def parallelParse(array: Array[String]): Array[Channel] = {
    val service = Executors.newFixedThreadPool(2)
    val futureListChannels = for {item <- array} yield new Callable[Channel]() {
      override def call() = YoutubeChannelParser.parse(item)
    }
    val listChannels = for {futureChannel <- futureListChannels} yield service.submit(futureChannel).get()
    service.shutdown()
    listChannels
  }
}
