package tokyo.ysbrothersk.ake.ui.main


import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.clothes_index_fragment.*

import tokyo.ysbrothersk.ake.R
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL


class ClothesIndexFragment : Fragment() {

    companion object {
        fun newInstance() = ClothesIndexFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.clothes_index_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        clothes_index_fragment_img_today.setImageBitmap(viewModel.todayWeatherIndexIcon)
        clothes_index_fragment_txv_index_today.text = viewModel.todayWeatherIndex
        clothes_index_fragment_txv_message_today.text = viewModel.todayWeatherIndexMessage

        clothes_index_fragment_img_tomorrow.setImageBitmap(viewModel.tomorrowWeatherIndexIcon)
        clothes_index_fragment_txv_index_tomorrow.text = viewModel.tomorrowWeatherIndex
        clothes_index_fragment_txv_message_tomorrow.text = viewModel.tomorrowWeatherIndexMessage
    }
}
