package com.cssweb.trade.client

import akka.actor.Actor
import com.cssweb.trade.common.{Message, Start}


/**
 * Created by chenhf on 2015/1/25.
 */
class LocalActor extends Actor{
  //akka.tcp://Remote端ActorSystem的名字@Remote端配置的IP:Remote端配置的端口号/user/Remote端的Actor名字
  val remoteActor = context.actorFor("akka.tcp://HelloRemoteSystem@127.0.0.1:5150/user/RemoteActor")

  var counter = 0

  def receive = {
    case Start => remoteActor ! Message("msg from local")
    case Message(msg) =>
      println(s"received msg is '$msg'")
      if (counter < 5) {
        sender ! Message("back")
        counter += 1
      }
    case _ => println("______")

  }

}
