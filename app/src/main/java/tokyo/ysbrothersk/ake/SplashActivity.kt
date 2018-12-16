package tokyo.ysbrothersk.ake

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import tokyo.ysbrothersk.ake.ui.splash.SplashFragment

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.splash_activity_frame_container, SplashFragment.newInstance())
                .commitNow()
        }
    }

}
