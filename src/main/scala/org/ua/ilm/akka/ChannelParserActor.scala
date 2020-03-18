package org.ua.ilm.akka

import akka.actor.{Actor, ActorRef}
import org.ua.ilm.Entity.YoutubeChannelParser

class ChannelParserActor(actorRef: ActorRef) extends Actor {
  override def receive: Receive = {
    case string: String =>
      val parseItem = YoutubeChannelParser.parse(string)
      actorRef!parseItem
    case _ =>
      println("Error ParserActor")
  }
}
