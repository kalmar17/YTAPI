package org.ua.ilm.datamining.crawlers.youtube

import com.google.api.services.youtube.model.ChannelListResponse

class CrawlerChannels(key: String, idChannels: String,
                      partChannels: Option[String] )extends Crawler(key) {

  private val part : String = partChannels.getOrElse("contentDetails,snippet,brandingSettings,contentOwnerDetails,localizations,statistics,status,topicDetails")
  private val listIdChannels = idChannels
  private val youtube = super.createYT()

  def channelListRequest(): ChannelListResponse = {
    youtube.channels.list(part).setId(listIdChannels).execute()
  }

}
