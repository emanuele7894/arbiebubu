package uele.barbiebubu

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.bumptech.glide.load.engine.Resource
import java.util.*

class foto : AppCompatActivity() {
    var currentPage = 1
    var currentPage1 = 1
    var currentPage2 = 1
    var currentPage3 = 1

    internal lateinit var album1: ImageView
    internal lateinit var album2: ImageView
    internal lateinit var album3: ImageView
    internal lateinit var album4: ImageView
    val swipeTimer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto)


        album1 = findViewById(R.id.albumImage) as ImageView
        album2 = findViewById(R.id.albumImage2) as ImageView
        album3 = findViewById(R.id.albumImage3) as ImageView
        album4 = findViewById(R.id.albumImage4) as ImageView

        val close = findViewById(R.id.close) as ImageButton



        close.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                val rotate = ObjectAnimator.ofFloat(close, View.ROTATION, -360f, 0f)
                rotate.setDuration(1000)
                rotate.start()
                swipeTimer.cancel()
                finish();
            }
        })

        val foto = findViewById(R.id.button) as Button


        foto.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val pathImage = variabili()




                var k: Intent = Intent(this@foto, uele.barbiebubu.slideImage::class.java)
                k.putExtra(".albumFoto", "0");


                startActivity(k);
            }
        })
        val foto2 = findViewById(R.id.button2) as Button


        foto2.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val pathImage = variabili()




                var k: Intent = Intent(this@foto, uele.barbiebubu.slideImage::class.java)
                k.putExtra(".albumFoto", "1");


                startActivity(k);
            }
        })

        val foto3 = findViewById(R.id.button3) as Button


        foto3.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val pathImage = variabili()




                var k: Intent = Intent(this@foto, uele.barbiebubu.slideImage::class.java)
                k.putExtra(".albumFoto", "2");


                startActivity(k);
            }
        })
        val foto4 = findViewById(R.id.button4) as Button


        foto4.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val pathImage = variabili()




                var k: Intent = Intent(this@foto, uele.barbiebubu.slideImage::class.java)
                k.putExtra(".albumFoto", "3");


                startActivity(k);
            }
        })

        fotoalbum1()


    }
    override fun onBackPressed() {
        super.onBackPressed()
        swipeTimer.cancel()


    }

     fun fotoalbum1(){
         val pathImage = variabili()
         var NUM_PAGES = 0
         NUM_PAGES = pathImage.foto1.size

         val pathImage2 = variabili()
         var NUM_PAGES2 = 0
         NUM_PAGES2 = pathImage2.foto2.size

         val pathImage3 = variabili()
         var NUM_PAGES3 = 0
         NUM_PAGES3 = pathImage2.foto3.size

         val pathImage4 = variabili()
         var NUM_PAGES4 = 0
         NUM_PAGES4 = pathImage2.foto4.size


         // Auto start of viewpager
         val handler = Handler()
         val Update = Runnable {

             //album1
             if (currentPage === NUM_PAGES) {
                 currentPage = 1
             }

             val mDrawableName = "img" + currentPage++
             val image = getResources().getIdentifier("$mDrawableName", "drawable", getPackageName())



             album1.setImageResource(image)


             //album2

             Handler().postDelayed({

                 if (currentPage1 === NUM_PAGES2) {
                     currentPage1 = 1
                 }

                 val mDrawableName2 = "imga" + currentPage1++
                 val image2 = getResources().getIdentifier("$mDrawableName2", "drawable", getPackageName())



                 album2.setImageResource(image2)

             }, 1000)


             //album3

             Handler().postDelayed({

                 if (currentPage2 === NUM_PAGES3) {
                     currentPage2 = 1
                 }

                 val mDrawableName3 = "imgb" + currentPage2++
                 val image3 = getResources().getIdentifier("$mDrawableName3", "drawable", getPackageName())



                 album3.setImageResource(image3)

             }, 2000)


             //album4

             Handler().postDelayed({

                 if (currentPage3 === NUM_PAGES4) {
                     currentPage3 = 1
                 }

                 val mDrawableName4 = "imgc" + currentPage3++
                 val image4 = getResources().getIdentifier("$mDrawableName4", "drawable", getPackageName())



                 album4.setImageResource(image4)

             }, 3000)



         }




         swipeTimer.schedule(object : TimerTask() {
             override fun run() {
                 handler.post(Update)
             }
         }, 500, 4000)
     }




}
