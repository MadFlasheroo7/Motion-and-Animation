package com.example.motionandanimation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {
    private var productlist = ArrayList<Products>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productlist.add(
            Products(
                "OnePlus 8T pro",
                R.drawable.oneplus,
                "Lead With Speed..",
                "One the best device i have ever seen in my life",
                "₹49,000"))
        productlist.add(
            Products(
                "Asus ROG 3",
                R.drawable.rog,
                "Coz that's wat Gamers do",
                "Gaming go brrrrrrr",
                "₹55,999"))
        productlist.add(
            Products(
                "iPhone 11 Pro Max",
                R.drawable.iphone,
                "Forever out of your Budget",
                "Sold my house for it :-)",
                "₹1,49,000")
        )
        productlist.add(
            Products(
                "Asus ROG 3"
                , R.drawable.rog,
                "Coz that's wat Gamers do",
                "Gaming go brrrrrrr",
                "₹55,999"))
        val productAdapter = ProductAdapter(productlist)

        viewPager.adapter = productAdapter
        viewPager.clipToPadding = true
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
//        compositePageTransformer.addTransformer { page, position ->
//            val r:Float = 1 - abs(position)
//            page.scaleY = 0.85f + r * 0.15f
//        }
        viewPager.setPageTransformer(SliderTransformer(3))
//        viewPager.setPageTransformer(compositePageTransformer)

        /*
            setting up recycler view
         */
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        recyclerView.setHasFixedSize(true)
        val suggestionAdapter = SuggestionAdapter(productlist)
        recyclerView.adapter = suggestionAdapter
        recyclerView.layoutManager = GridLayoutManager(this,2)
    }
}