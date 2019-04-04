package uele.barbiebubu

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.github.chrisbanes.photoview.PhotoView
import java.net.URL

class prossima : AppCompatActivity() {
    lateinit var prossima: PhotoView
    val pathImage = variabili()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prossima)

        prossima = findViewById(R.id.imgP) as PhotoView
        //Assegno l'immagine all'imageview
        DownLoadImageTask(prossima)
                .execute("http://www.barbiebubu.it/images/prossima.jpg")


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

            if (result != null) {
                // Display the downloaded image into image view

                imageView.setImageBitmap(result)

            } else {

            }
        }
    }
}
