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
        

        Log.i("RegisterViewModel", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        bindingRegister.button3.setOnClickListener {
            var nom = bindingRegister.editTextNombre.text.toString()
            var id = bindingRegister.editTextCarne.text.toString()
            var carr = bindingRegister.editTextCarrera.text.toString()
            var cont = bindingRegister.editTextContacto.text.toString()
            var pass1 = bindingRegister.editTextPassword.text.toString()
            var pass2 = bindingRegister.editTextPassword2.text.toString()
            viewModel.getText(id,nom,carr,cont,pass1,pass2)
        }

        return bindingRegister.root
    }
}
