package tokyo.ysbrothersk.ake.client

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.jsoup.Jsoup
import tokyo.ysbrothersk.ake.document.ClothesIndexDocument

class ClothesIndexClient {

    private val url = "https://tenki.jp/indexes/dress/3/16/4410/"

    suspend fun getDocumentAsync(): Deferred<ClothesIndexDocument> = coroutineScope {
        async { ClothesIndexDocument(Jsoup.connect(url).get()) }
    }
}