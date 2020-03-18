package org.ua.ilm.akka

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.Patterns
import akka.routing.BalancingPool
import akka.util.Timeout
import org.ua.ilm.entity.Channel

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object MainActor {

  def parallelCrawlerChannels(key: String, arrIdChannels: Array[String],
                              partChannels: Option[String], numberActors: Int): List[Channel] = {
    val system = ActorSystem("Crawler")
    val channelStorageActor = system.actorOf(Props(new ChannelStorageActor()), "storage")
    implicit val timeout: Timeout = Timeout(2 second)

    val poolParserActors: ActorRef =
      system.actorOf(BalancingPool(numberActors).props(Props(new ChannelParserActor(channelStorageActor))), "parseJson")
    val poolCrawlerActors: ActorRef =
      system.actorOf(BalancingPool(numberActors).props(Props(new ChannelCrawlerActor(key, poolParserActors))), "router")

    val batchActor = system.actorOf(Props(new BatchActor), "batch")
    batchActor ! BatchActor.Push(2, arrIdChannels)

    val cancellable = system.scheduler
      .scheduleWithFixedDelay(0 second, 2 second, batchActor, BatchActor.Flush(poolCrawlerActors, partChannels))

    Thread.sleep(5000)
    val listChannels = Patterns.ask(channelStorageActor, ChannelStorageActor.Flush, timeout).mapTo[List[Channel]].value.get.get
    cancellable.cancel()
    system.terminate()
    listChannels
  }

}