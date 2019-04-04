package uele.barbiebubu

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import com.github.chrisbanes.photoview.PhotoView


class PageView : PagerAdapter {

    var con: Context
    var path: IntArray
    lateinit var inflator: LayoutInflater

    constructor(con: Context, path: IntArray) : super() {
        this.con = con
        this.path = path
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view == `object` as RelativeLayout


    }

    override fun getCount(): Int {
        return path.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var img: PhotoView
        inflator = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var rv: View = inflator.inflate(R.layout.swipe_framgment, container,false)
        img = rv.findViewById(R.id.img) as PhotoView
        img.setImageResource(path[position])
        container!!.addView(rv)

        return rv

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container!!.removeView(`object` as RelativeLayout)
    }


}