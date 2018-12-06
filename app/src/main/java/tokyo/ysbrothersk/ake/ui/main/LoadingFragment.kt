package tokyo.ysbrothersk.ake.ui.main


import android.arch.lifecycle.ViewModelProviders
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

import tokyo.ysbrothersk.ake.R
import tokyo.ysbrothersk.ake.client.ClothesIndexClient
import java.net.URL

class LoadingFragment : Fragment() {

    companion object {
        fun newInstance() = LoadingFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.loading_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)


        // 1. 気象庁から東京の天気情報取得

        // 2. 東京の服装指数を取得
        GlobalScope.launch {
            val doc = ClothesIndexClient().getDocumentAsync().await()

            val todayIconUrl = URL(doc.todayWeatherIconUrl)
            val todayBmp = async {
                BitmapFactory.decodeStream(todayIconUrl.openConnection().getInputStream())
            }

            val tomorrowIconUrl = URL(doc.tomorrowWeatherIconUrl)
            val tomorrowBmp = async {
                BitmapFactory.decodeStream(tomorrowIconUrl.openConnection().getInputStream())
            }

            viewModel.todayWeatherIndexIcon = todayBmp.await()
            viewModel.tomorrowWeatherIndexIcon = tomorrowBmp.await()

            viewModel.todayWeatherIndex = doc.todayWeatherIndex
            viewModel.todayWeatherIndexMessage = doc.todayWeatherMessage

            viewModel.tomorrowWeatherIndex = doc.tomorrowWeatherIndex
            viewModel.tomorrowWeatherIndexMessage = doc.tomorrowWeatherMessage

            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_activity_container, MainFragment.newInstance())
                ?.commit()
        }
    }
}
