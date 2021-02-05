package com.example.animals_with_tabs_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list_animal.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private var names = arrayOf("Main", "Details")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_activity_view_pager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(main_activity_tabs, main_activity_view_pager) { tab, position ->
            tab.text = names[position]
        }.attach()
    }

    fun scrollViewPager(position: Int = 1) {
    main_activity_view_pager.currentItem = position
    }
}