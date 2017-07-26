package com.ifzhou.akkaserver.config

import org.apache.spark.{SparkConf, SparkContext}
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.stereotype.Component

/**
  * Created by zhouyifu on 2017/7/25.
  */
@Configuration
class SparkConfig {

  @Bean
  def scConfig={
     new SparkConf().setAppName("wordcount").setMaster("local");
  }


  @Bean
  def scObject={
     new SparkContext(scConfig)
  }
}
