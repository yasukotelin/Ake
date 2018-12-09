package tokyo.ysbrothersk.ake.document

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class JMADocument(private val document: Document) {

    val title: String
        get() = document.title()

    fun getTodayWeatherImgUrl(): String = document
        .select("table.forecast th.weather")
        .first()
        .select("img")
        .attr("abs:src")

    fun getTomorrowWeatherImgUrl(): String = document
        .select("table.forecast th.weather")[1]
        .select("img")
        .attr("abs:src")
}