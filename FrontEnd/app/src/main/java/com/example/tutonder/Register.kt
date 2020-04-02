package com.example.tutonder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.tutonder.databinding.FragmentRegisterBinding


class Register : Fragment() {
    private lateinit var viewModel:RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingRegister = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)
        return bindingRegister.root

        Log.i("RegisterViewModel", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        
    }
}
