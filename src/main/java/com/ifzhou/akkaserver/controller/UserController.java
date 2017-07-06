package com.ifzhou.akkaserver.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.ifzhou.akkaserver.ob.Message.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import akka.actor.ActorSelection;
import akka.pattern.Patterns;
import akka.util.Timeout;
import org.springframework.web.bind.annotation.RestController;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * Created by zhouyifu on 2017/7/6.
 */
@RestController
@RequestMapping(value={"/users"})
public class UserController {

    @Autowired
    private ActorSelection worker;

    @SuppressWarnings({"rawtypes","unchecked"})
    @RequestMapping(value={"/find"})
    public String find(String id) throws Exception {

        String uuid = UUID.randomUUID().toString();
        Future future = Patterns.ask(worker, uuid, Timeout.apply(10L, TimeUnit.SECONDS));
        TextMessage o = (TextMessage)Await.result(future,Duration.create(10L,TimeUnit.SECONDS));
        return o.msg();
    }
}
