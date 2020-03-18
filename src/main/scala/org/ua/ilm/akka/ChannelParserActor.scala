package org.ua.ilm.akka

import akka.actor.{Actor, ActorRef}
import org.ua.ilm.entity.parse.YouTubeChannelParser

class ChannelParserActor(actorRef: ActorRef) extends Actor {
  override def receive: Receive = {
    case channelJsons: Array[String] =>
      val channels = for {item <- channelJsons} yield new YouTubeChannelParser().parse(item)
      actorRef ! ChannelStorageActor.AddAll(channels)
    case _ =>
      println("Error ParserActor")
  }
}
