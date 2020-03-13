package org.ua.ilm.datastore.io.config.reader

import com.typesafe.config.ConfigFactory
import org.ua.ilm.datastore.io.config.ConfigurationFile

class ConfigurationFileReader(part:String) extends ConfigurationFile(part){
  def paramConfig(name:String): String ={
    config.getString(name)
  }
}
