package tokyo.ysbrothersk.ake.ui.main


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.jma_fragment.*

import tokyo.ysbrothersk.ake.R

class JMAFragment : Fragment() {

    companion object {
        fun newInstance() = JMAFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.jma_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        // Today
        jma_fragment_txv_today_weather_title.text = viewModel.jmaDocument.getTodayWeatherTitle()
        Glide.with(this).load(viewModel.jmaDocument.getTodayWeatherImgUrl()).into(jma_fragment_img_today_weather)

        val todayRainyPercentList = viewModel.jmaDocument.getTodayRainyPercent()
        jma_fragment_txv_today_00_06_rainy_percent.text =
                resources.getString(R.string.rainy_percent, todayRainyPercentList[0])
        jma_fragment_txv_today_06_12_rainy_percent.text =
                resources.getString(R.string.rainy_percent, todayRainyPercentList[1])
        jma_fragment_txv_today_12_18_rainy_percent.text =
                resources.getString(R.string.rainy_percent, todayRainyPercentList[2])
        jma_fragment_txv_today_18_24_rainy_percent.text =
                resources.getString(R.string.rainy_percent, todayRainyPercentList[3])

        // Tomorrow
        jma_fragment_txv_tomorrow_weather_title.text = viewModel.jmaDocument.getTomorrowWeatherTitle()
        Glide.with(this).load(viewModel.jmaDocument.getTomorrowWeatherImgUrl()).into(jma_fragment_tomorrow_weather)

        val tomorrowRainyPercentList = viewModel.jmaDocument.getTomorrowRainyPercent()
        jma_fragment_txv_tomorrow_00_06_rainy_percent.text =
                resources.getString(R.string.rainy_percent, tomorrowRainyPercentList[0])
        jma_fragment_txv_tomorrow_06_12_rainy_percent.text =
                resources.getString(R.string.rainy_percent, tomorrowRainyPercentList[1])
        jma_fragment_txv_tomorrow_12_18_rainy_percent.text =
                resources.getString(R.string.rainy_percent, tomorrowRainyPercentList[2])
        jma_fragment_txv_tomorrow_18_24_rainy_percent.text =
                resources.getString(R.string.rainy_percent, tomorrowRainyPercentList[3])
    }
}
