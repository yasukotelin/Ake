package tokyo.ysbrothersk.ake.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import tokyo.ysbrothersk.ake.R

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
            val doc = Jsoup.connect("https://tenki.jp/indexes/dress/3/16/4410/").get()
            println(doc.title())
        }

        // 非同期で実行後、awaitで取得できたことを確認したらfragmentに表示する
    }
}
