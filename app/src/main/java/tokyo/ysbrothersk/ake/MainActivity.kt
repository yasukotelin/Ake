package tokyo.ysbrothersk.ake

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import tokyo.ysbrothersk.ake.ui.main.LoadingFragment
import tokyo.ysbrothersk.ake.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity_container, LoadingFragment.newInstance())
                .commitNow()
        }
    }
}
