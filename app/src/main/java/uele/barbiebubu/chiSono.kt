package uele.barbiebubu

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageButton
import android.os.Environment.getExternalStorageDirectory
import java.io.File
import java.io.InputStream
import uele.barbiebubu.R.id.webView




class chiSono : AppCompatActivity() {

    internal lateinit var webview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_sono)

        webview = findViewById(R.id.webView) as WebView


       webview.loadUrl("file:///android_asset/chi.html");



        val close = findViewById(R.id.close) as ImageButton


        close.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                val rotate = ObjectAnimator.ofFloat(close, View.ROTATION, -360f, 0f)
                    rotate.setDuration(1000)
                        rotate.start()

                finish();
            }
        })


    }




}
