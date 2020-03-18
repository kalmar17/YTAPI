package org.ua.ilm.akka

import akka.actor.Actor
import org.ua.ilm.entity.Channel

import scala.collection.mutable.ListBuffer

object ChannelStorageActor {

  final case class Add(channel: Channel)

  final case class AddAll(channels: Array[Channel])

  final case class Flush()

}

class ChannelStorageActor extends Actor {
  val channelListBuffer: ListBuffer[Channel] = ListBuffer.empty

  override def receive: Receive = {
    case ChannelStorageActor.Add(channel: Channel) =>
      channelListBuffer.addOne(channel)
    case ChannelStorageActor.AddAll(channels: Array[Channel]) =>
      channelListBuffer.addAll(channels)
    case ChannelStorageActor.Flush =>
      sender() ! channelListBuffer.toList
      channelListBuffer.empty
    case _ =>
      println("Error ChannelStorageActor")
  }
}
