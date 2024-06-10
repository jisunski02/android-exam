package dev.jaysonguillen.personapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nyxsys.personapp.databinding.ActivityPersonBinding
import dagger.hilt.android.AndroidEntryPoint
import dev.jaysonguillen.personapp.presentation.adapter.PersonAdapter
import dev.jaysonguillen.personapp.presentation.viewmodel.PersonLocalViewModel
import dev.jaysonguillen.personapp.presentation.viewmodel.PersonRemoteViewModel
import dev.jaysonguillen.personapp.presentation.viewmodel.factory.PersonLocalViewModelFactory
import dev.jaysonguillen.personapp.presentation.viewmodel.factory.PersonRemoteViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class PersonActivity : AppCompatActivity() {
    @Inject
    lateinit var personRemoteViewModelFactory: PersonRemoteViewModelFactory
    @Inject
    lateinit var personLocalViewModelFactory: PersonLocalViewModelFactory
    @Inject
    lateinit var personAdapter: PersonAdapter

    lateinit var personRemoteViewModel: PersonRemoteViewModel
    lateinit var personLocalViewModel: PersonLocalViewModel

    private lateinit var binding: ActivityPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personRemoteViewModel = ViewModelProvider(this,  personRemoteViewModelFactory)[PersonRemoteViewModel::class.java]
        personLocalViewModel  = ViewModelProvider(this,  personLocalViewModelFactory)[PersonLocalViewModel::class.java]

    }

}