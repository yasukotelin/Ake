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

        // Tomorrow
        jma_fragment_txv_tomorrow_weather_title.text = viewModel.jmaDocument.getTomorrowWeatherTitle()
        Glide.with(this).load(viewModel.jmaDocument.getTomorrowWeatherImgUrl()).into(jma_fragment_tomorrow_weather)
    }
}
