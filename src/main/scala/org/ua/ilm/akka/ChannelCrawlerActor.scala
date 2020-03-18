package org.ua.ilm.akka

import akka.actor.{Actor, ActorRef}
import org.ua.ilm.datamining.crawlers.youtube.CrawlerChannels

class ChannelCrawlerActor(APIKey: String, actorRef: ActorRef) extends Actor {

  override def receive: Receive = {
    case (string: String, part: Option[String]) =>
      val channelJsons = new CrawlerChannels(APIKey, string, part).getChannelJsons
      actorRef ! channelJsons
    case (channels: Array[String], part: Option[String]) =>
      val channelsJsons = new CrawlerChannels(APIKey, channels, part).getChannelJsons
      actorRef ! channelsJsons
    case _ =>
      println("Error ChannelActor")
  }
}
