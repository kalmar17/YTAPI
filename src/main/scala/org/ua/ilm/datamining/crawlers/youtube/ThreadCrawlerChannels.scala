package org.ua.ilm.datamining.crawlers.youtube

import java.util.concurrent.{Callable, Executors}

import com.google.api.services.youtube.model.Channel

class ThreadCrawlerChannels(key: String, arrIdChannels: Array[String],
                            partChannels: Option[String]) {

  val service = Executors.newFixedThreadPool(5)


  def parallelCrawlerChannels(): Array[String] = {
    val listCallable = for {idChannels <- arrIdChannels} yield new Callable[Channel]() {
      override def call(): Channel = new CrawlerChannels(key, idChannels, partChannels).channelListRequest().getItems.get(0)
    }
    val listChannels = for {callable <- listCallable} yield service.submit(callable).get().toPrettyString
    service.shutdown()
    listChannels
  }
}

