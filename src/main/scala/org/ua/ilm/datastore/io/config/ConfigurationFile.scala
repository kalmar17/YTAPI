package org.ua.ilm.datastore.io.config

import com.typesafe.config.ConfigFactory

class ConfigurationFile(part:String) {
  private val partFileName = part
  protected val config = ConfigFactory.load(partFileName)
}
