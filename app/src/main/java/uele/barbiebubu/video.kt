package uele.barbiebubu

import android.animation.ObjectAnimator
import android.content.ActivityNotFoundException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.content.Intent
import android.net.Uri
import android.widget.Button


class video : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)


        val close = findViewById(R.id.close) as ImageButton




        close.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                val rotate = ObjectAnimator.ofFloat(close, View.ROTATION, -360f, 0f)
                rotate.setDuration(1000)
                rotate.start()

                finish();
            }
        })


        //Video1

        val video1 = findViewById(R.id.video1) as ImageButton


        video1.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                openYoutubeLink("g1tE1prKAJc")
            }
        })

        //Video2

        val video2 = findViewById(R.id.video2) as ImageButton


        video2.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                openYoutubeLink("4zrNj_x4YME")
            }
        })

        //Video3

        val video3 = findViewById(R.id.video3) as ImageButton


        video3.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                openYoutubeLink("dCMYYgYu4VY")
            }
        })

        //Video4

        val video4 = findViewById(R.id.video4) as ImageButton


        video4.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                openYoutubeLink("j7yjJFJiobs")
            }
        })
        //Video5

        val video5 = findViewById(R.id.video5) as ImageButton


        video5.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                openYoutubeLink("eqzr8RhaZCg")
            }
        })
        //Video6

        val video6 = findViewById(R.id.video6) as ImageButton


        video6.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                openYoutubeLink("EkA6dp1ily0")
            }
        })


        //Video7

        val video7 = findViewById(R.id.video7) as ImageButton


        video7.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                openYoutubeLink("du1ryj3Qqwc")
            }
        })



    }


    fun openYoutubeLink(youtubeID: String) {
        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youtubeID))
        val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + youtubeID))
        try {
            this.startActivity(intentApp)
        } catch (ex: ActivityNotFoundException) {
            this.startActivity(intentBrowser)
        }

    }


}
