package org.ua.ilm.Entity

class JsonParsTest extends org.scalatest.FunSuite {
  test("JsonPars.parsJsonToChannel") {
    val title = "NBA"
    val keywords = "NBA \"Full Game Recaps\" \"Full Game Highlights\""
    val subscriberCount = 13500000
    val viewCount = 6686975235L
    val description = "National Basketball Association.  Official home of the most compelling basketball action from the NBA"
    val channelTest = Channel(title, keywords, subscriberCount, viewCount, description)
    val json = "{\n    \"brandingSettings\" : {\n      \"channel\" : {\n        \"country\" : \"US\",\n        \"defaultTab\" : \"Featured\",\n        \"description\" : \"National Basketball Association.  Official home of the most compelling basketball action from the NBA\",\n        \"featuredChannelsTitle\" : \"Featured Channels\",\n        \"featuredChannelsUrls\" : [ \"UCpGimyrbwRtrcJ-CIiRDXbA\", \"UCO9a_ryN_l7DIDS-VIt-zmw\", \"UCM5uQEGUy9b1hKUknvBa50A\", \"UC4h5koEDpJzOg0QtkukfLbw\", \"UCk3-3xJydA7m_pZt2ncCEXQ\", \"UCVSSpcmZD2PwPBqb8yKQKBA\", \"UCU7iRrk3xfpUk0R6VdyC1Ow\", \"UCiWLfSweyRNmLpgEHekhoAg\", \"UC63iLYfl0uIZjYCnvalQM6g\" ],\n        \"keywords\" : \"NBA \\\"Full Game Recaps\\\" \\\"Full Game Highlights\\\"\",\n        \"profileColor\" : \"#000000\",\n        \"showBrowseView\" : true,\n        \"showRelatedChannels\" : true,\n        \"title\" : \"NBA\",\n        \"trackingAnalyticsAccountId\" : \"UA-8570491-1\",\n        \"unsubscribedTrailer\" : \"spll56K7ZNg\"\n      },\n      \"hints\" : [ {\n        \"property\" : \"channel.banner.mobile.medium.image.url\",\n        \"value\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w640-fcrop64=1,32b75a57cd48a5a8-k-c0xffffffff-no-nd-rj\"\n      }, {\n        \"property\" : \"channel.featured_tab.template.string\",\n        \"value\" : \"Everything\"\n      }, {\n        \"property\" : \"channel.modules.show_comments.bool\",\n        \"value\" : \"True\"\n      } ],\n      \"image\" : {\n        \"bannerImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w1060-fcrop64=1,00005a57ffffa5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerMobileExtraHdImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w1440-fcrop64=1,32b75a57cd48a5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerMobileHdImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w1280-fcrop64=1,32b75a57cd48a5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerMobileImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w640-fcrop64=1,32b75a57cd48a5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerMobileLowImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w320-fcrop64=1,32b75a57cd48a5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerMobileMediumHdImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w960-fcrop64=1,32b75a57cd48a5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerTabletExtraHdImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w2560-fcrop64=1,00005a57ffffa5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerTabletHdImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w2276-fcrop64=1,00005a57ffffa5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerTabletImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w1707-fcrop64=1,00005a57ffffa5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerTabletLowImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w1138-fcrop64=1,00005a57ffffa5a8-k-c0xffffffff-no-nd-rj\",\n        \"bannerTvHighImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w1920-fcrop64=1,00000000ffffffff-k-c0xffffffff-no-nd-rj\",\n        \"bannerTvImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w2120-fcrop64=1,00000000ffffffff-k-c0xffffffff-no-nd-rj\",\n        \"bannerTvLowImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w854-fcrop64=1,00000000ffffffff-k-c0xffffffff-no-nd-rj\",\n        \"bannerTvMediumImageUrl\" : \"https://yt3.ggpht.com/gw4o0PM4aVTT0QSmB0GgeEOtuno6VnUy35bPxiW9WoiYuEtfYD04r-Bujb00sEAkRAjrxuNu=w1280-fcrop64=1,00000000ffffffff-k-c0xffffffff-no-nd-rj\"\n      }\n    },\n    \"contentDetails\" : {\n      \"relatedPlaylists\" : {\n        \"uploads\" : \"UUWJ2lWNubArHWmf3FIHbfcQ\",\n        \"watchHistory\" : \"HL\",\n        \"watchLater\" : \"WL\"\n      }\n    },\n    \"etag\" : \"\\\"SJZWTG6xR0eGuCOh2bX6w3s4F94/i4sXDQKNUva5-5LiX2zaF_NYGkM\\\"\",\n    \"id\" : \"UCWJ2lWNubArHWmf3FIHbfcQ\",\n    \"kind\" : \"youtube#channel\",\n    \"snippet\" : {\n      \"country\" : \"US\",\n      \"customUrl\" : \"nba\",\n      \"description\" : \"National Basketball Association.  Official home of the most compelling basketball action from the NBA\",\n      \"localized\" : {\n        \"description\" : \"National Basketball Association.  Official home of the most compelling basketball action from the NBA\",\n        \"title\" : \"NBA\"\n      },\n      \"publishedAt\" : \"2005-11-21T01:20:33.000Z\",\n      \"thumbnails\" : {\n        \"default\" : {\n          \"height\" : 88,\n          \"url\" : \"https://yt3.ggpht.com/a/AATXAJxSG6sly40OTN4ISS_upNzKWMQ6xnrPdRya=s88-c-k-c0xffffffff-no-rj-mo\",\n          \"width\" : 88\n        },\n        \"high\" : {\n          \"height\" : 800,\n          \"url\" : \"https://yt3.ggpht.com/a/AATXAJxSG6sly40OTN4ISS_upNzKWMQ6xnrPdRya=s800-c-k-c0xffffffff-no-rj-mo\",\n          \"width\" : 800\n        },\n        \"medium\" : {\n          \"height\" : 240,\n          \"url\" : \"https://yt3.ggpht.com/a/AATXAJxSG6sly40OTN4ISS_upNzKWMQ6xnrPdRya=s240-c-k-c0xffffffff-no-rj-mo\",\n          \"width\" : 240\n        }\n      },\n      \"title\" : \"NBA\"\n    },\n    \"statistics\" : {\n      \"commentCount\" : \"0\",\n      \"hiddenSubscriberCount\" : false,\n      \"subscriberCount\" : \"13500000\",\n      \"videoCount\" : \"33261\",\n      \"viewCount\" : \"6686975235\"\n    },\n    \"status\" : {\n      \"isLinked\" : true,\n      \"longUploadsStatus\" : \"longUploadsUnspecified\",\n      \"privacyStatus\" : \"public\"\n    },\n    \"topicDetails\" : {\n      \"topicCategories\" : [ \"https://en.wikipedia.org/wiki/Sport\", \"https://en.wikipedia.org/wiki/Basketball\" ],\n      \"topicIds\" : [ \"/m/018w8\", \"/m/06ntj\", \"/m/018w8\" ]\n    }\n  }"
    val jsonPars = JsonPars

    val result = jsonPars.parsJsonToChannel(json)
    assert(result == channelTest)
  }
}
