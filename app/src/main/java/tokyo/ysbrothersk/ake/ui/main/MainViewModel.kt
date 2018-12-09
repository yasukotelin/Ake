package tokyo.ysbrothersk.ake.ui.main

import android.arch.lifecycle.ViewModel
import tokyo.ysbrothersk.ake.document.ClothesIndexDocument
import tokyo.ysbrothersk.ake.document.JMADocument

class MainViewModel : ViewModel() {

    lateinit var jmaDocument: JMADocument

    lateinit var clothesIndexDocument: ClothesIndexDocument
}
