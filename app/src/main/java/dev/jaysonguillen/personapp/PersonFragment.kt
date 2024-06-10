package dev.jaysonguillen.personapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nyxsys.personapp.R
import com.nyxsys.personapp.databinding.FragmentPersonBinding
import dev.jaysonguillen.personapp.data.model.PersonLocal
import dev.jaysonguillen.personapp.data.util.Resource
import dev.jaysonguillen.personapp.presentation.adapter.PersonAdapter
import dev.jaysonguillen.personapp.presentation.viewmodel.PersonLocalViewModel
import dev.jaysonguillen.personapp.presentation.viewmodel.PersonRemoteViewModel
import kotlinx.coroutines.launch

class PersonFragment : Fragment() {

    private lateinit var binding: FragmentPersonBinding
    private lateinit var personRemoteViewModel: PersonRemoteViewModel
    private lateinit var personLocalViewModel: PersonLocalViewModel
    private lateinit var personAdapter: PersonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPersonBinding.bind(view)

        personRemoteViewModel = (activity as PersonActivity).personRemoteViewModel
        personLocalViewModel = (activity as PersonActivity).personLocalViewModel
        personAdapter = (activity as PersonActivity).personAdapter

        binding.rvPerson.apply {
            adapter = personAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        getPersonListOnLocalDb()

        binding.swipeRefreshLayout.setOnRefreshListener {
            getPersonListOnSwipeRefresh()
        }


        personAdapter.setOnItemClickLister {
            val bundle = Bundle().apply {
                putSerializable("selected_person", it)
            }

            findNavController().navigate(
                R.id.action_personFragment_to_personDetailsFragment, bundle
            )
        }
    }

    private fun getPersonListOnLocalDb(){

        viewLifecycleOwner.lifecycleScope.launch {
            // Repeat this coroutine as long as the lifecycle is in the CREATED state
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {

                personLocalViewModel.getPersonLocalData().collect{
                    if(it.isEmpty()){
                        Log.e("isEmpty", "Yes")
                        getPersonListOnSwipeRefresh()
                    }

                    else{
                        Log.e("isEmpty", "No")
                        binding.pbPerson.visibility = View.GONE
                       personLocalViewModel.getPersonLocalData().collect{ personLocal->
                           personAdapter.differ.submitList(personLocal)
                       }
                    }
                }

            }

            }
    }

    private fun getPersonListOnSwipeRefresh(){
        personRemoteViewModel.getPersonRemote("20")

        viewLifecycleOwner.lifecycleScope.launch {
            // Repeat this coroutine as long as the lifecycle is in the CREATED state
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                personRemoteViewModel.personStateFlow.collect{resource->

                    when(resource){

                        is Resource.Loading->{

                        }

                        is Resource.Success->{
                            binding.pbPerson.visibility = View.GONE
                            //Toast.makeText(activity, "Successfully loaded", Toast.LENGTH_LONG).show()
                            resource.data.let {person->

                                person?.personResponse?.forEach { personRemote ->
                                    val personLocal = PersonLocal(
                                        mobileNumber = personRemote.cell,
                                        dateOfBirth = personRemote.dob.date,
                                        email = personRemote.email,
                                        gender = personRemote.gender,
                                        location = "${personRemote.location.city} ${personRemote.location.state} ${personRemote.location.country}",
                                        fullName = "${personRemote.name.title} ${personRemote.name.first} ${personRemote.name.last}",
                                        age = personRemote.dob.age.toString(),
                                        phone = personRemote.phone,
                                        urlPicture = personRemote.picture.large
                                    )

                                    personLocalViewModel.insertPersonLocalData(personLocal)
                                }

                                // Once all objects are inserted, update the UI
                                personLocalViewModel.getPersonLocalData().collect {
                                    binding.swipeRefreshLayout.isRefreshing = false
                                    personAdapter.differ.submitList(it)
                                }



                            }
                        }

                        is Resource.Error->{
                            Toast.makeText(activity, "Failed to load data", Toast.LENGTH_LONG).show()
                            binding.swipeRefreshLayout.isRefreshing = false
                        }

                    }
                }

            }


        }
    }
}