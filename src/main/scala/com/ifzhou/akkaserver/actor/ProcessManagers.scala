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

  val worker = context.actorOf(Props[Worker].withDispatcher("my-thread-pool-dispatcher"), "worker")

  def receive = {
    case x: Any =>
  }
}