package org.ua.ilm.datamining.crawlers.youtube

import org.scalatest.{BeforeAndAfterAllConfigMap, ConfigMap}

class CrawlerChannelsTest extends org.scalatest.FunSuite with BeforeAndAfterAllConfigMap {
  private var testConfig: Option[String] = None
  private var testIdChannels: Option[String] = None

  test("CrawlerChannels.getChannelListRequest(The number of Channels ids before and after the request should be the same.)") {
    val key = testConfig.get
    val idChannels = testIdChannels.toList.toArray
    val actualSizeListChannels = idChannels.count(_ == ',') + 1
    val crawlerChannels = new CrawlerChannels(key, idChannels, None)
    val expectedSizeListChannels = crawlerChannels.getChannelJsons.length
    assert(expectedSizeListChannels == actualSizeListChannels)
  }

  override protected def beforeAll(configMap: ConfigMap): Unit = {
    testConfig = configMap.getOptional[String]("key")
    testIdChannels = configMap.getOptional[String]("idChannels")
    assert(testConfig.isDefined)
    assert(testIdChannels.isDefined)
  }
}