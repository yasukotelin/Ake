package tokyo.ysbrothersk.ake.document

import org.jsoup.nodes.Document

class JMADocument(private val document: Document) {

    val title: String
        get() = document.title()

    fun getTodayWeatherImgUrl(): String = document
        .select("table.forecast th.weather")
        .first()
        .select("img")
        .attr("abs:src")

    fun getTodayWeatherTitle(): String = document
        .select("table.forecast th.weather")
        .first()
        .select("img")
        .attr("title")

    fun getTodayRainyPercent() = document
        .select("table.forecast td.rain")
        .first()
        .select("td[align=right]")
        .map { it.text() }

    fun getTomorrowWeatherImgUrl(): String = document
        .select("table.forecast th.weather")[1]
        .select("img")
        .attr("abs:src")

    fun getTomorrowWeatherTitle(): String = document
        .select("table.forecast th.weather")[1]
        .select("img")
        .attr("title")

    fun getTomorrowRainyPercent(): List<String> = document
        .select("table.forecast td.rain")[1]
        .select("td[align=right]")
        .map { it.text() }
}