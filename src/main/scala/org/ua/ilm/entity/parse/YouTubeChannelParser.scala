package org.ua.ilm.entity.parse

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.ua.ilm.entity.Channel

class YouTubeChannelParser {
  val mapper = new ObjectMapper() with ScalaObjectMapper

  def parse(channelJson: String): Channel = {
    val jsonNode = mapper.readTree(channelJson)
    val title = jsonNode.findValue("title").asText()
    val keywords = jsonNode.findValue("keywords").asText()
    val subscriberCount = jsonNode.findValue("subscriberCount").asLong()
    val viewCount = jsonNode.findValue("viewCount").asLong()
    val description = jsonNode.findValue("description").asText()
    Channel(title, keywords, subscriberCount, viewCount, description)
  }
}