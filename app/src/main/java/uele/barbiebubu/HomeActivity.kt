package uele.barbiebubu

import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.BounceInterpolator
import android.webkit.URLUtil
import java.util.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.text.method.ScrollingMovementMethod
import android.widget.*
import java.net.URL
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest




class HomeActivity : AppCompatActivity() {
    internal lateinit var sfondo1: ImageView
    internal lateinit var menu: ScrollView
    internal lateinit var infoTxt: TextView
    internal lateinit var titP: TextView
    internal lateinit var mAdView: AdView
    var timer = Timer()
    var countTime = 1


    internal var visible = "invisible"
    internal var visible2 = "invisible"
    val testo = "E' dal periodo della Lira che esercito questa follia, rinforzandola ogni qual volta che ci sono nuove sfide da affrontare migliorando sempre più. In questo scorcio di web troverai un po di me, un po è inteso come vita da artista sono un ragazzo camuffato da donna, faccio questo non per cercare occasioni sessuali, e se ci fossero crederei che il messaggio che mando con il mio corpo è sbagliato o è feticista di clown. Mi trasformo in questo personaggio per creare una comicità che ha molto impatto sul pubblico, nella fantasia di un mondo comico e surreale, e le pagine ti racconteranno come ho costruito questa nuova identità, dove mi sono esibito, i miei progetti e dove mi potrai vedere, per non dimenticare come regalarmi. In tutte le situazioni riesco ad essere molto Camaleonte, mi ha persino detto il mio regista che riuscirei a celebrare un funerale con sobrietà, per ora ho condotto Un Matrimonio a Madrid  che ha davvero rafforzato il mio amore in ciò che faccio e farò. Ma non voglio rubarvi altro tempo: buon viaggio nel mondo di BarbieBubu.it"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        menu = findViewById(R.id.scroll) as ScrollView
        sfondo1 = findViewById(R.id.sfondo1) as ImageView
        infoTxt =  findViewById(R.id.testoInfo) as TextView
        titP =  findViewById(R.id.titoloPros) as TextView

        infoTxt.setText(testo)
            infoTxt.movementMethod = ScrollingMovementMethod()





        val datePros = findViewById(R.id.datePros) as ImageButton

        //Assegno l'immagine all'imageview
        DownLoadImageTask(datePros)
                .execute("http://www.barbiebubu.it/images/prossima.jpg")

        titP.alpha = 0.0f
            datePros.alpha = 0.0f





        datePros.setOnClickListener(object : View.OnClickListener {


            override fun onClick(v: View?) {
                var k: Intent = Intent(this@HomeActivity, uele.barbiebubu.prossima::class.java)



                startActivity(k);
            }
        })




        val mInterstitialAd: InterstitialAd






        //pulsante menuButton
        val menuButton = findViewById(R.id.menuButton) as ImageButton



            datePros.visibility = View.VISIBLE

            val fade = ObjectAnimator.ofFloat(datePros, View.ALPHA, 0.0f, 1.0f)
            fade.setDuration(1000)
            fade.start()

            val fade1 = ObjectAnimator.ofFloat(titP, View.ALPHA, 0.0f, 1.0f)
            fade1.setDuration(1000)
            fade1.start()

            fadeIn()





        menuButton.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                menu.visibility = View.VISIBLE


                if (visible === "invisible") {
                    menu.visibility = View.VISIBLE
                    visible = "visible"


                    val fade = ObjectAnimator.ofFloat(menu, View.TRANSLATION_X, 1000f, 0f)
                        fade.setDuration(1000)
                            fade.interpolator = BounceInterpolator()
                                fade.start()

                    val rotate = ObjectAnimator.ofFloat(menuButton, View.ROTATION, -360f, 0f)
                        rotate.setDuration(1000)
                             rotate.start()
                    Handler().postDelayed({

                        menuButton.setImageResource(R.drawable.close)


                    }, 500)

                } else if (visible === "visible") {




                    val fade = ObjectAnimator.ofFloat(menu, View.TRANSLATION_X, 0f, 1000f)
                        fade.setDuration(1000)
                            fade.interpolator = BounceInterpolator()
                                fade.start()

                    val rotate = ObjectAnimator.ofFloat(menuButton, View.ROTATION, +360f, 0f)
                        rotate.setDuration(1000)
                            rotate.start()


                    Handler().postDelayed({

                        menuButton.setImageResource(R.drawable.menu)


                    }, 500)

                    Handler().postDelayed({

                        menu.visibility = View.INVISIBLE
                        visible = "invisible"

                    }, 1000)


                }



            }
        })

        //pulsante pubblicità Sottosopra
        val sottoSopra = findViewById(R.id.sottosopraButton) as ImageButton


        sottoSopra.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

               // https@ //www.sexyshopsottosopra.com

                web_page_open("https://www.sexyshopsottosopra.com")
            }
        })



        //Admob pubblicità

        mInterstitialAd =  InterstitialAd(this);
             mInterstitialAd.setAdUnitId("ca-app-pub-1084610005673175/7794237265");


        Handler().postDelayed({

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                //Begin Game, continue with app
            }


        }, 15000)





        val buttonMod = findViewById(R.id.buttonMob) as Button


        buttonMod.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    mInterstitialAd.show();
                }

            }
        })



        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {

                //Begin Game, continue with app
            }
        }

        val mAdView = findViewById(R.id.adView) as AdView
            val adRequest = AdRequest.Builder().build()
                 mAdView.loadAd(adRequest)
                         mInterstitialAd.loadAd(adRequest)

        buttonMod.visibility = View.VISIBLE
        mAdView.visibility = View.VISIBLE

        Handler().postDelayed({

            buttonMod.visibility = View.INVISIBLE
            mAdView.visibility = View.INVISIBLE
         sottoSopra.visibility = View.VISIBLE


        }, 30000)

        //Fine pubblicità





        //pulsante informazioni
        val infoButton = findViewById(R.id.infoButton) as ImageButton


        infoButton.setOnClickListener(object : View.OnClickListener {



            override fun onClick(v: View?) {

                if (visible2 === "invisible") {

                    infoTxt.visibility = View.VISIBLE
                        visible2 = "visible"


                    val fade = ObjectAnimator.ofFloat(infoTxt, View.ALPHA, 0.0f, 1.0f)
                        fade.setDuration(1000)
                            fade.start()


                    val rotate = ObjectAnimator.ofFloat(infoButton, View.ROTATION, +360f, 0f)
                        rotate.setDuration(1000)
                            rotate.start()

                    Handler().postDelayed({

                        infoButton.setImageResource(R.drawable.close2)


                    }, 500)


                }else if (visible2 === "visible") {

                    val fade = ObjectAnimator.ofFloat(infoTxt, View.ALPHA, 1.0f, 0.0f)
                        fade.setDuration(1000)
                            fade.start()

                        visible2 = "invisible"


                    Handler().postDelayed({
                        infoTxt.visibility = View.INVISIBLE
                    }, 1000)

                    val rotate = ObjectAnimator.ofFloat(infoButton, View.ROTATION, -360f, 0f)
                        rotate.setDuration(1000)
                            rotate.start()

                    Handler().postDelayed({

                        infoButton.setImageResource(R.drawable.info)


                    }, 500)



                }


            }
        })



        val chisono = findViewById(R.id.chisono) as Button


        chisono.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                var k: Intent = Intent(this@HomeActivity, uele.barbiebubu.chiSono::class.java)

                startActivity(k);

            }
        })




        val foto = findViewById(R.id.foto) as Button


        foto.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                var k: Intent = Intent(this@HomeActivity, uele.barbiebubu.foto::class.java)

                startActivity(k);

            }
        })


        val video = findViewById(R.id.video) as Button


        video.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                var k: Intent = Intent(this@HomeActivity, uele.barbiebubu.video::class.java)

                startActivity(k);

            }
        })

        val prossime = findViewById(R.id.prossime) as Button


        prossime.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                var k: Intent = Intent(this@HomeActivity, uele.barbiebubu.prossime::class.java)

                startActivity(k);

            }
        })



        val archivio = findViewById(R.id.archivio) as Button


        archivio.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                var k: Intent = Intent(this@HomeActivity, uele.barbiebubu.archivio::class.java)

                startActivity(k);

            }
        })



        val contatti = findViewById(R.id.contatti) as Button


        contatti.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                var k: Intent = Intent(this@HomeActivity, uele.barbiebubu.contatti::class.java)

                startActivity(k);

            }
        })





    }

//Apre browser esterno per lanciare il link di sottosopra
    fun web_page_open(urls: String) {

    val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(urls)
            startActivity(i)


    URLUtil.isNetworkUrl(urls)
}






//Inizio Animazione sfondo
    fun fadeIn(){

        val fade = ObjectAnimator.ofFloat(sfondo1, View.ALPHA, 1.0f, 0.0f)
         fade.setDuration(1000)
            fade.start()



        Handler().postDelayed({

            fadeOut()
        }, 1000)



    }


    fun fadeOut() {

        if (countTime == 0){

            sfondo1.setImageResource(R.drawable.sf1)
                countTime = 1

        }else if (countTime == 1){

            sfondo1.setImageResource(R.drawable.sf2)
                countTime = 2

        }else if (countTime == 2){

            sfondo1.setImageResource(R.drawable.sf3)
                countTime = 3

        }else if (countTime == 3){

            sfondo1.setImageResource(R.drawable.sf4)
                countTime = 0

        }



        val fade3 = ObjectAnimator.ofFloat(sfondo1, View.ALPHA, 0.0f, 1.0f)
        fade3.setDuration(1000)
        fade3.start()

        Handler().postDelayed({

            fadeIn()
        }, 30000)

    }
//Fine Animazione sfondo




}



private class DownLoadImageTask(internal val imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {

    override fun doInBackground(vararg urls: String): Bitmap? {
        val urlOfImage = urls[0]
        return try {
            val inputStream = URL(urlOfImage).openStream()
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) { // Catch the download exception
            e.printStackTrace()
            null
        }
    }
    override fun onPostExecute(result: Bitmap?) {

        if(result!=null){
            // Display the downloaded image into image view

            imageView.setImageBitmap(result)



        }else{

        }
    }
}