package tokyo.ysbrothersk.ake.document

import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class ClothesIndexDocument(private val document: Document) {

    val title: String
        get() = document.title()

    private val todayWeather: Elements = document.select("section.today-weather")

    fun getTodayWeatherIndex(): String =
        todayWeather.select("span.indexes-telop-0").first().text()
}