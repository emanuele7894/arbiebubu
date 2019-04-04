package uele.barbiebubu

import android.animation.ObjectAnimator
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ImageButton
import android.opengl.ETC1.getWidth
import android.content.Context.WINDOW_SERVICE
import android.graphics.Bitmap
import android.view.WindowManager
import android.view.Display
import android.webkit.WebResourceRequest
import android.webkit.WebViewClient
import android.widget.ProgressBar


class prossime : AppCompatActivity() {

    internal lateinit var webview: WebView
    internal lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prossime)

        progressBar = findViewById(R.id.progressBar) as ProgressBar
        webview = findViewById(R.id.webView) as WebView

        webview.webViewClient = myWebClient()
            webview.settings.javaScriptEnabled = true
                webview.settings.builtInZoomControls = true
                    webview.settings.displayZoomControls = false
                        webview.settings.loadWithOverviewMode = true
                            webview.settings.useWideViewPort = true

        webview.loadUrl("http://www.barbiebubu.it/eventi")





        val close = findViewById(R.id.close) as ImageButton


        close.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val rotate = ObjectAnimator.ofFloat(close, View.ROTATION, -360f, 0f)
                    rotate.setDuration(1000)
                        rotate.start()

                finish();
            }
        })

        val back = findViewById(R.id.back) as ImageButton


        back.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val rotate = ObjectAnimator.ofFloat(back, View.ROTATION, -360f, 0f)
                rotate.setDuration(500)
                rotate.start()

                if (webview.canGoBack()) {
                    webview.goBack();
                }


            }
        })



        val next = findViewById(R.id.next) as ImageButton


        next.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val rotate = ObjectAnimator.ofFloat(next, View.ROTATION, -360f, 0f)
                rotate.setDuration(500)
                rotate.start()

                if(webview.canGoForward()){
                    webview.goForward();
                }

            }
        })

    }


    inner class myWebClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            progressBar.setVisibility(View.VISIBLE);

            return super.shouldOverrideUrlLoading(view, request)
        }



        override fun onPageFinished(view: WebView, url: String) {

            super.onPageFinished(view, url)
            progressBar.setVisibility(View.GONE);
        }

    }


}
