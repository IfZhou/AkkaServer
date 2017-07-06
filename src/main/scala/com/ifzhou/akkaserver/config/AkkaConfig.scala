package com.ifzhou.akkaserver.config

import akka.actor.{ActorSystem, Props}
import akka.routing.RandomPool
import com.ifzhou.akkaserver.actor.ProcessManagers
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

/**
  * Created by zhouyifu on 2017/7/6.
  */
@Component
class AkkaConfig {

  val system = ActorSystem("ReactiveEnterprise")

  val processManagersRef = system.actorOf(Props[ProcessManagers].withDispatcher("my-thread-pool-dispatcher").withRouter(RandomPool(2)),"processManagers")

  @Bean
  def processManagers = {
    processManagersRef
  }
}