package org.ua.ilm.akka

import akka.actor.{Actor, ActorRef, Props}
import org.ua.ilm.datamining.crawlers.youtube.CrawlerChannels

class CrawlerChannelsActor(APIKey: String, actorRef: ActorRef) extends Actor {

  override def receive: Receive = {
    case (string: String, part: Option[String]) =>
      val parseJson = context.actorOf(Props(new ChannelParserActor(actorRef)), name = "parseJson")
      val crawlerChannels = new CrawlerChannels(APIKey, string, part).channelListRequest().getItems
      parseJson ! crawlerChannels.get(0).toPrettyString
    case _ =>
      println("Error ChannelActor")
  }
}
