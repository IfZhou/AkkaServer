package com.ifzhou.akkaserver.service

import org.apache.spark.SparkContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by zhouyifu on 2017/7/26.
  */
@Service
class WordCountService  @Autowired() (private  val scObject : SparkContext){


  def test():String={
    return this.scObject.getClass.toString;
  }

  def wordtest():String ={
    val textFile = this.scObject.textFile("README.md")
    return textFile.count().toString;
  }
}
