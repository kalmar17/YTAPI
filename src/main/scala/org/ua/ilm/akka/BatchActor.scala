package org.ua.ilm.akka

import akka.actor.{Actor, ActorRef}

import scala.collection.mutable.ListBuffer

object BatchActor {

  case class Push(sizePool: Int, arr: Array[String])

  case class Flush(actorRef: ActorRef,part: Option[String])

}

class BatchActor extends Actor {
  val listBuffer: ListBuffer[Array[String]] = ListBuffer.empty

  override def receive: Receive = {
    case BatchActor.Push(num, arr) =>
      arr.grouped(num).foreach(listBuffer.addOne)

    case BatchActor.Flush(actorRef,part) =>
      actorRef ! (listBuffer.remove(0),part)
    case _ =>
      println("Error BatchActor")
  }
}
