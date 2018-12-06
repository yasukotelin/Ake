package tokyo.ysbrothersk.ake.ui.main

import android.arch.lifecycle.ViewModel
import android.graphics.Bitmap
import tokyo.ysbrothersk.ake.document.ClothesIndexDocument

class MainViewModel : ViewModel() {

    lateinit var todayWeatherIndexIcon: Bitmap
    lateinit var todayWeatherIndex: String
    lateinit var todayWeatherIndexMessage: String

    lateinit var tomorrowWeatherIndexIcon: Bitmap
    lateinit var tomorrowWeatherIndex: String
    lateinit var tomorrowWeatherIndexMessage: String
}
