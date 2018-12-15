package tokyo.ysbrothersk.ake.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import tokyo.ysbrothersk.ake.R
import tokyo.ysbrothersk.ake.client.ClothesIndexClient
import tokyo.ysbrothersk.ake.client.JMAClient

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

        GlobalScope.launch {
            // 気象庁のデータを取得
            val jmaDeferred = JMAClient().getDocumentAsync()

            // 東京の服装指数を取得
            val clothesIndexDeferred = ClothesIndexClient().getDocumentAsync()

            viewModel.jmaDocument = jmaDeferred.await()
            viewModel.clothesIndexDocument = clothesIndexDeferred.await()

            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_activity_container, MainFragment.newInstance())
                ?.commit()
        }
    }
}
