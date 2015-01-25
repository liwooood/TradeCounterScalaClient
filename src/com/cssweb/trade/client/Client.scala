package com.cssweb.trade.client

import akka.actor.{Props, ActorSystem}
import com.cssweb.trade.common.Start


object Client extends App{
	//System.setProperty("akka.remote.netty.port", "5152")

	implicit  val actorSystem = ActorSystem("LocalSystem");

		val clientActor = actorSystem.actorOf(Props[LocalActor], name = "LocalActor")

	clientActor ! Start


}


