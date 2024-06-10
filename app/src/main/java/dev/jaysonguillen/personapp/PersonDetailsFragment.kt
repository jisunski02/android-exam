package dev.jaysonguillen.personapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nyxsys.personapp.PersonNavGraphArgs
import com.nyxsys.personapp.R
import com.nyxsys.personapp.databinding.FragmentPersonBinding
import com.nyxsys.personapp.databinding.FragmentPersonDetailsBinding
import dev.jaysonguillen.personapp.presentation.viewmodel.PersonLocalViewModel


class PersonDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPersonDetailsBinding
    private lateinit var personLocalViewModel: PersonLocalViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPersonDetailsBinding.bind(view)

        personLocalViewModel = (activity as PersonActivity).personLocalViewModel

        val args : PersonNavGraphArgs by navArgs()
        val persons = args.selectedPerson

       Glide.with(binding.profileImage.context)
            .load(persons.urlPicture)
            .into(binding.profileImage)

        binding.fullName.text = persons.fullName
        binding.phoneNumber.text = persons.phone
        binding.mobileNumber.text = persons.mobileNumber
        binding.location.text = persons.location
        binding.gender.text = persons.gender
        binding.email.text = persons.email
        binding.dateOfBirth.text = persons.dateOfBirth


    }
}