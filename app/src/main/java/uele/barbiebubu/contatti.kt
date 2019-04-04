package uele.barbiebubu

import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.irozon.alertview.AlertActionStyle
import com.irozon.alertview.AlertStyle
import com.irozon.alertview.AlertView
import com.irozon.alertview.objects.AlertAction

class contatti : AppCompatActivity() {

    lateinit var nome: EditText
    lateinit var mail: EditText
    lateinit var telefono: EditText
    lateinit var testoinfo: EditText
    lateinit var descrizione: EditText

    var check = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contatti)


        nome = findViewById(R.id.nome) as EditText
            mail = findViewById(R.id.mailtesto) as EditText
                telefono = findViewById(R.id.testotelefono) as EditText
        testoinfo = findViewById(R.id.infotesto) as EditText
            descrizione = findViewById(R.id.descrizione) as EditText




        val invia = findViewById(R.id.buttonInvio) as Button


        invia.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {




                if (nome.text.toString() == "") {


                    alert()



                }else if (nome.text.toString() == "") {

                    alert()


                } else if (check == false) {

                    alert()

                }else {

                    val stringa = "nome: " + nome.text.toString() + "\n" + "email: " + mail.text.toString() + "\n" + "telefono: " + telefono.text.toString() + "\n" + "dove ci hai conosciuto: " + testoinfo.text.toString() + "\n" + "descrizione: " + descrizione.text.toString()



                    val intentMail = Intent(Intent.ACTION_SEND)

                    intentMail.type = "text/html"

                    intentMail.putExtra(Intent.EXTRA_EMAIL,arrayOf<String>("barbiedario@gmail.com"))

                    intentMail.putExtra(Intent.EXTRA_SUBJECT, "Informazioni")

                    intentMail.putExtra(Intent.EXTRA_TEXT, stringa)

                    startActivity(intentMail)

                }







            }
        })




        val checkA = findViewById(R.id.buttonA) as ImageButton


        checkA.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {


                if (check === false) {

                    checkA.setImageResource(R.drawable.checkbox_on)

                    val rotate = ObjectAnimator.ofFloat(checkA, View.ROTATION, +360f, 0f)
                    rotate.setDuration(1000)
                    rotate.start()

                    check = true



                } else  {

                    checkA.setImageResource(R.drawable.checkbox_off)

                    val rotate = ObjectAnimator.ofFloat(checkA, View.ROTATION, -360f, 0f)
                    rotate.setDuration(1000)
                    rotate.start()

                    check = false
                }




            }
        })











        //pulsante back

        val close = findViewById(R.id.close) as ImageButton


        close.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                val rotate = ObjectAnimator.ofFloat(close, View.ROTATION, -360f, 0f)
                rotate.setDuration(1000)
                rotate.start()

                finish();
            }
        })

        val face = findViewById(R.id.faceButton) as ImageButton


        face.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                // https@ //www.sexyshopsottosopra.com

                web_page_open("https://www.facebook.com/barbiebubu.it")
            }
        })


    }



    fun alert(){
        val alert = AlertView("Attenzione !", "I cmapi con : (*) devono essere compilati !", AlertStyle.BOTTOM_SHEET)
        alert.addAction(AlertAction("Ok", AlertActionStyle.DEFAULT, { action ->
            // Action 1 callback
        }))


        alert.show(this@contatti)

    }
    //Apre browser esterno per lanciare il link di sottosopra
    fun web_page_open(urls: String) {

        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(urls)
        startActivity(i)


        URLUtil.isNetworkUrl(urls)
    }


}
