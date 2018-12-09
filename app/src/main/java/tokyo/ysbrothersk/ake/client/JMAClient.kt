package tokyo.ysbrothersk.ake.client

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.jsoup.Jsoup
import tokyo.ysbrothersk.ake.document.JMADocument

/**
 * JMA(Japan Meteorological Agency: 気象庁）
 */
class JMAClient {

    private val url = "https://www.jma.go.jp/jp/yoho/319.html"

    suspend fun getDocumentAsync(): Deferred<JMADocument> = coroutineScope {
        async { JMADocument(Jsoup.connect(url).get()) }
    }
}