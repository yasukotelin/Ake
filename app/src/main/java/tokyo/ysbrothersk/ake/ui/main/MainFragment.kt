package tokyo.ysbrothersk.ake.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tokyo.ysbrothersk.ake.R
import tokyo.ysbrothersk.ake.client.ClothesIndexClient

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)


        // 1. 気象庁から東京の天気情報取得

        // 2. 東京の服装指数を取得
        GlobalScope.launch {
            val doc = ClothesIndexClient().getDocumentAsync()

            launch(Dispatchers.Main) {
                main_fragment_txv_test.text = "今日の服装指数: ${doc.await().getTodayWeatherIndex()}"
            }
        }

        // 非同期で実行後、awaitで取得できたことを確認したらfragmentに表示する
    }
}
