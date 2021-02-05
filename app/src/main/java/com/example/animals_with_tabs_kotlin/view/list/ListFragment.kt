package com.example.animals_with_tabs_kotlin.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animals_with_tabs_kotlin.MainActivity
import com.example.animals_with_tabs_kotlin.R
import com.example.animals_with_tabs_kotlin.data.Animal

class ListFragment : Fragment() {

    var animalsList: ArrayList<Animal> = arrayListOf<Animal>()
    lateinit var recyclerView: RecyclerView
    lateinit var animalListAdapter: AnimalListAdapter

    companion object {
        val LIST_FRAGMENT_REQUEST_CODE: String = "pass_animal_request_code"
        val KEY_ANIMAL_BUNDLE: String = "key_position"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.list_fragment_recyclerView)
        populateAnimalsList()
        animalListAdapter = AnimalListAdapter(animalsList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = animalListAdapter

        animalListAdapter.itemViewClickListener = object : ItemViewClickListener {
            override fun onItemClick(position: Int) {
                val result = Bundle()
                result.putParcelable(KEY_ANIMAL_BUNDLE, animalsList.get(position))
                parentFragmentManager.setFragmentResult(LIST_FRAGMENT_REQUEST_CODE, result)

                (activity as MainActivity?)?.scrollViewPager(1)
            }
        }
    }

    fun populateAnimalsList() {
        val animals: Array<String> = resources.getStringArray(R.array.animals_english)
        val images: Array<String> = resources.getStringArray(R.array.pictures)

        for (i in animals.indices) {
            val imageId: Int = resources.getIdentifier(images[i], "drawable", activity?.packageName)
            animalsList.add(Animal(animals[i], imageId))
        }

    }
}