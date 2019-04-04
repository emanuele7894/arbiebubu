package uele.barbiebubu

import android.animation.ObjectAnimator
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView

class splash : AppCompatActivity() {

    private var splashLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)







        if (!splashLoaded) {




            setContentView(R.layout.activity_splash)
            val secondsDelayed = 1
            Handler().postDelayed({
                startActivity(Intent(this@splash, HomeActivity::class.java))
                finish()
            }, (secondsDelayed * 4000).toLong())

            splashLoaded = true


        } else {
            val goToMainActivity = Intent(this@splash, HomeActivity::class.java)
            goToMainActivity.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(goToMainActivity)
            finish()
        }
    }
}
