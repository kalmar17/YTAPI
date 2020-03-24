package org.ua.ilm.datamining.crawlers.youtube

import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.http.{HttpRequest, HttpRequestInitializer}
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.{YouTube, YouTubeRequestInitializer}

class Crawler(private val key: String) {
  private val appName = "YTApi"
   def createYT(): YouTube = {
    val transport = new NetHttpTransport()
    val factory = new JacksonFactory()
    val httpRequestInit = new HttpRequestInitializer {
      override def initialize(re: HttpRequest): Unit = {}
    }
    new YouTube.Builder(transport, factory, httpRequestInit)
      .setApplicationName(appName).setYouTubeRequestInitializer(new YouTubeRequestInitializer(key)).build()
  }
}
