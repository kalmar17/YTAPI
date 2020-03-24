package org.ua.ilm.datamining.crawlers.youtube

import java.util.concurrent.{Callable, ExecutorService, Executors}

class ParallelCrawlerChannels(key: String, channelIds: Array[String], partChannels: Option[String], numberOfThreads: Int)
  extends CrawlerChannels(key, channelIds, partChannels) {

  override def getChannelJsons: Array[String] = {
    val poolThreads: ExecutorService = Executors.newFixedThreadPool(numberOfThreads)
    val callableArr = for {item <- channelIds} yield new Callable[String]() {
      override def call(): String = getChannelListRequest(item).getItems.get(0).toPrettyString
    }

    val channelJsons = for {callable <- callableArr} yield poolThreads.submit(callable).get()
    poolThreads.shutdown()
    channelJsons
  }
}

