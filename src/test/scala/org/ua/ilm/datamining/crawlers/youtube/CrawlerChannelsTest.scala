package org.ua.ilm.datamining.crawlers.youtube

import org.scalatest.{BeforeAndAfterAllConfigMap, ConfigMap}

class CrawlerChannelsTest extends org.scalatest.FunSuite with BeforeAndAfterAllConfigMap {
  private var testConfig: Option[String] = None
  private var testIdChannels: Option[String] = None

  test("CrawlerChannels.channelListRequest") {
    val key = testConfig.get
    val idChannels = testIdChannels.get
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