package com.example.animals_with_tabs_kotlin.view.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import com.example.animals_with_tabs_kotlin.R
import com.example.animals_with_tabs_kotlin.data.Animal
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

        final val KEY_ANIMAL_BUNDLE: String = "key position"
        final val LIST_FRAGMENT_REQUEST_CODE: String = "pass_animal_request_code"

    @DrawableRes
    private val imageId: Int = R.drawable.parrot
    private var title = "Bird"
    private var description = "Birds are a group of warm-blooded vertebrates constituting " +
            "the class Aves /ˈeɪviːz/, characterized by feathers, toothless beaked jaws, " +
            "the laying of hard-shelled eggs, a high metabolic rate, a four-chambered heart, " +
            "and a strong yet lightweight skeleton. Birds live worldwide and range in size from the " +
            "5.5 cm (2.2 in) bee hummingbird to the 2.8 m (9 ft 2 in) ostrich. There are about ten " +
            "thousand living species, more than half of which are passerine, or \"perching\" birds. " +
            "Birds have wings whose development varies according to species; the only known groups " +
            "without wings are the extinct moa and elephant birds. Wings, which evolved from forelimbs, " +
            "gave birds the ability to fly, although further evolution has led to the loss of flight in some birds, " +
            "including ratites, penguins, and diverse endemic island species. The digestive and respiratory systems of " +
            "birds are also uniquely adapted for flight. Some bird species of aquatic environments, " +
            "particularly seabirds and some waterbirds, have further evolved for swimming."

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_details_title_text.text = title
        fragment_details_details_text.text = description
        fragment_details_image.setImageResource(imageId)

        parentFragmentManager.setFragmentResultListener(
            LIST_FRAGMENT_REQUEST_CODE,
            this,
            FragmentResultListener { requestKey, result ->
                val animal = result.getParcelable<Animal>(KEY_ANIMAL_BUNDLE)
                Log.d("MyApp", "Animal: $animal")
                animal?.run {
                    fragment_details_image.setImageResource(imageId)
                    fragment_details_title_text.text = name
                }
            })

//        parentFragmentManager.setFragmentResultListener(LIST_FRAGMENT_REQUEST_CODE,
//            this, object : FragmentResultListener{
//                override fun onFragmentResult(requestKey: String, result: Bundle) {
//                    val animal = result.getParcelable<Animal>(KEY_ANIMAL_BUNDLE)
//                    Log.d("MyApp", "Animal: $animal")
//                    animal?.run {
//                        fragment_details_image.setImageResource(imageId)
//                        fragment_details_title_text.text = name
//                    }
//                }
//            })

    }

}