package org.ua.ilm.entity.parse

import java.util.concurrent.{Callable, ExecutorService, Executors}

import org.ua.ilm.entity.Channel

class ParallelYouTubeChannelParser(numberOfThreads: Int) extends YouTubeChannelParser {

 def getChannels(channelJsons: Array[String]): Array[Channel] = {
    val poolThreads: ExecutorService = Executors.newFixedThreadPool(numberOfThreads)
    val callableArr = for {item <- channelJsons} yield new Callable[Channel]() {
      override def call(): Channel = new YouTubeChannelParser().parse(item)
    }
    val channels = for {callable <- callableArr} yield poolThreads.submit(callable).get()
    poolThreads.shutdown()
    channels
  }

}
