package com.ifzhou.akkaserver.service

import java.util.concurrent.TimeUnit

import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout
import com.ifzhou.akkaserver.ob.Message.TextMessage
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.concurrent.Await

/**
  * Created by zhouyifu on 2017/7/6.
  */
@Service
class UserService {

  val logger = LoggerFactory.getLogger(getClass)

  def toUpper(x: String) : String= {
    return x.toUpperCase
  }
}
