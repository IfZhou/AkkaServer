package com.ifzhou.akkaserver.actor

/**
  * Created by zhouyifu on 2017/7/6.
  */
import akka.actor.Actor
import com.ifzhou.akkaserver.config.BeanFactory
import com.ifzhou.akkaserver.ob.Message.TextMessage
import com.ifzhou.akkaserver.service.UserService
import org.slf4j.LoggerFactory


class Worker extends Actor {

  val logger = LoggerFactory.getLogger(getClass)

  lazy val domainService = BeanFactory.buildFactory().getBean(classOf[UserService])

  def receive = {
    case x: String => {
      logger.info("x:{}", x)
      val textMsg = new TextMessage(domainService.toUpper(x))
      sender ! textMsg
    }
  }
}
