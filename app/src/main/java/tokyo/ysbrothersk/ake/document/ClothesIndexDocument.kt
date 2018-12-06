package tokyo.ysbrothersk.ake.document

import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class ClothesIndexDocument(private val document: Document) {

    val title: String
        get() = document.title()

    private val todayWeather: Elements = document.select("section.today-weather")
    private val tomorrowWeather: Elements = document.select("section.tomorrow-weather")

    val todayWeatherIconUrl: String = todayWeather.select("div.indexes-icon-box > img").attr("src")

    val todayWeatherIndex: String = todayWeather.select("span.indexes-telop-0").first().text()

    val todayWeatherMessage: String = todayWeather.select("p.indexes-telop-1").first().text()

    val tomorrowWeatherIconUrl: String = tomorrowWeather.select("div.indexes-icon-box > img").attr("src")

    val tomorrowWeatherIndex: String = tomorrowWeather.select("span.indexes-telop-0").first().text()

    val tomorrowWeatherMessage: String = tomorrowWeather.select("p.indexes-telop-1").first().text()

}