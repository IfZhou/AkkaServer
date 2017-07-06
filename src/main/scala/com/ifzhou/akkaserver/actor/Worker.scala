package com.ifzhou.akkaserver.actor

/**
  * Created by zhouyifu on 2017/7/6.
  */
import akka.actor.Actor
import com.ifzhou.akkaserver.config.BeanFactory
import com.ifzhou.akkaserver.controller.UserController
import com.ifzhou.akkaserver.ob.Message
import org.slf4j.LoggerFactory


class Worker extends Actor {

  val logger = LoggerFactory.getLogger(getClass)

  lazy val demainService = BeanFactory.buildFactory().getBean(classOf[UserController])

  def receive = {
    case x: String => {
      logger.info("{}", x);
      sender ! new Message.TextMessage(demainService.handle)
    }
  }
}
