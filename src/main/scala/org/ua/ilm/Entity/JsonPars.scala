package org.ua.ilm.Entity

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

object JsonPars {
  val mapper = new ObjectMapper() with ScalaObjectMapper

  def parsJson(json: String, key: String): Unit = {
    val jsonNode = mapper.readTree(json)
    println(jsonNode.findValue(key))
  }

  def parsJsonToChannel(string: String): Channel = {
    val jsonNode = mapper.readTree(string)
    val title = jsonNode.findValue("title").asText()
    val keywords = jsonNode.findValue("keywords").asText()
    val subscriberCount = jsonNode.findValue("subscriberCount").asLong()
    val viewCount = jsonNode.findValue("viewCount").asLong()
    val description = jsonNode.findValue("description").asText()
    Channel(title, keywords, subscriberCount, viewCount, description)
  }
}