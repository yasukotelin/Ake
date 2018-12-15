package tokyo.ysbrothersk.ake.ui.main


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.clothes_index_fragment.*
import tokyo.ysbrothersk.ake.R


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

        Glide
            .with(this)
            .load(viewModel.clothesIndexDocument.todayWeatherIconUrl)
            .into(clothes_index_fragment_img_today)
        clothes_index_fragment_txv_index_today.text = viewModel.clothesIndexDocument.todayWeatherIndex
        clothes_index_fragment_txv_message_today.text = viewModel.clothesIndexDocument.todayWeatherMessage

        Glide
            .with(this)
            .load(viewModel.clothesIndexDocument.tomorrowWeatherIconUrl)
            .into(clothes_index_fragment_img_tomorrow)
        clothes_index_fragment_txv_index_tomorrow.text = viewModel.clothesIndexDocument.tomorrowWeatherIndex
        clothes_index_fragment_txv_message_tomorrow.text = viewModel.clothesIndexDocument.tomorrowWeatherMessage
    }
}
