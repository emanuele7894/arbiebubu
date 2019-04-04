package uele.barbiebubu

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class slideImage : AppCompatActivity() {

    lateinit var  mPager: ViewPager
    val pathImage = variabili()
    var path =  intArrayOf()
    lateinit var numImageText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_image)

        intent = intent
        var numeroAlbum = intent.getStringExtra(".albumFoto");


        if (numeroAlbum == "0"){

            path = pathImage.foto1

        }else if (numeroAlbum == "1"){

            path = pathImage.foto2

        }else if (numeroAlbum == "2"){

            path = pathImage.foto3

        }else if (numeroAlbum == "3"){

            path = pathImage.foto4

        }



        mPager = findViewById(R.id.pager) as ViewPager
        numImageText = findViewById(R.id.textNum) as TextView
                var adapter: PagerAdapter = PageView(this, path)
                mPager.adapter = adapter

        val numImage2 = path.size
        numImageText.text = "1" + " - " + "$numImage2"

        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

                val numImage = path.size
                    var imageSelect = position + 1

                numImageText.text = "$imageSelect" + " - " + "$numImage"



            }
        })

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
