package org.ua.ilm.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.routing.BalancingPool
import org.ua.ilm.Entity.Channel
import org.ua.ilm.akka.ParallelActorMain.listChannels

import scala.collection.mutable.ListBuffer

object ParallelActorMain {
  val listChannels: ListBuffer[Channel] = ListBuffer.empty

  def parallelCrawlerChannels(key: String, arrIdChannels: Array[String],
                              partChannels: Option[String], numberActors: Int): List[Channel] = {
    val system = ActorSystem("Crawler")
    val actorSystem = system.actorOf(Props(new ParallelActorMain()))
    val poolCrawlerActors: ActorRef =
      system.actorOf(BalancingPool(numberActors).props(Props(new CrawlerChannelsActor(key, actorSystem))), "router")
    arrIdChannels.foreach(item => poolCrawlerActors ! (item, partChannels))
    Thread.sleep(5000)
    system.terminate()
    listChannels.toList
  }
}

class ParallelActorMain extends Actor {
  override def receive: Receive = {
    case channel: Channel =>
      listChannels.addOne(channel)
    case _ =>
      println("Error ActorMain")
  }
}