package com.ifzhou.akkaserver.actor

/**
  * Created by zhouyifu on 2017/7/6.
  */
import java.util.concurrent.TimeUnit

import akka.actor.{Actor, Props}
import akka.pattern.ask
import akka.routing.RandomPool
import akka.util.Timeout
import org.slf4j.LoggerFactory

import scala.concurrent.Await

class ProcessManagers extends Actor {

  val logger = LoggerFactory.getLogger(getClass)

  val worker = context.actorOf(Props[Worker].withDispatcher("my-thread-pool-dispatcher").withRouter(RandomPool(4)), "worker")

  implicit val timeout = Timeout(60, TimeUnit.SECONDS)

  def receive = {
    case x: String =>
      logger.info("{}", x);
      sender ! Await.result(ask(worker, x), timeout.duration)
    case x: Int =>
      logger.info("{}", x)
  }
}