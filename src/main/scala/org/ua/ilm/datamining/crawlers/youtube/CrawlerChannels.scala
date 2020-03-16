package org.ua.ilm.datamining.crawlers.youtube

import com.google.api.services.youtube.model.ChannelListResponse

class CrawlerChannels(key: String, channelIds: Array[String],
                      channelParts: Option[String]) extends Crawler(key) {
  private val part: String = channelParts.
    getOrElse("contentDetails,snippet,brandingSettings,contentOwnerDetails,localizations,statistics,status,topicDetails")
  private val channelIdsList = channelIds
  private val youtube = super.createYT()

  def this(key: String, idChannel: String,channelParts: Option[String]) {
    this(key, Array(idChannel), channelParts)
  }

  def getChannelListRequest(idChannel: String): ChannelListResponse = {
    youtube.channels.list(part).setId(idChannel).execute()
  }

  protected def getChannelListRequest: ChannelListResponse = {
    youtube.channels.list(part).setId(channelIdsList.mkString(",")).execute()
  }

  def getChannelJsons: Array[String] = {
    val channelJsons = for {item <- getChannelListRequest.getItems.toArray} yield item.toString
    channelJsons
  }
}