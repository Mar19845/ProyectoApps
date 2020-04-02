package com.example.tutonder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tutonder.databinding.FragmentLoginBinding
import com.example.tutonder.databinding.FragmentRegisterBinding


class Register : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingRegister = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)
        return bindingRegister.root
    }
}
