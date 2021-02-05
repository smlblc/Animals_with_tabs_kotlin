package com.example.animals_with_tabs_kotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.animals_with_tabs_kotlin.view.details.DetailsFragment
import com.example.animals_with_tabs_kotlin.view.list.ListFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ListFragment()
            else -> DetailsFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}