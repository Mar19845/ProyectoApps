package com.example.tutonder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.tutonder.databinding.FragmentLoginBinding
import com.example.tutonder.network.User

class Login : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        val bindingLogin = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val usuario: LiveData<User> = viewModel.userResponse

        bindingLogin.botonIngresar.setOnClickListener(){
            viewModel.getUser(bindingLogin.Usuario.text.toString())
            Toast.makeText(context, usuario.value.toString(), Toast.LENGTH_SHORT).show()
            if(usuario.value == null){
            }else{
                if(usuario.value!!.password == bindingLogin.Contrasena.text.toString()){
                    Toast.makeText(context,"Logged :)", Toast.LENGTH_SHORT).show()
                    (activity as MainActivity?)?.saveData("logged", true)
                    this.findNavController().navigate(R.id.action_login_to_listaTutores)
                }else{
                    Toast.makeText(context,"Parece que tu contrasena es incorrecta...", Toast.LENGTH_LONG).show()
                }
            }
        }

        return bindingLogin.root
    }
/*
*
* Toast.makeText(context, usuario.value.toString(), Toast.LENGTH_SHORT).show()
* if(usuario.value == null){
                    Toast.makeText(context,"No se ha encontrado al usuario :(", Toast.LENGTH_LONG).show()
                }else{
                    if(usuario.value!!.password == bindingLogin.Contrasena.text.toString()){
                        Toast.makeText(context,"Logged :)", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"Parece que tu contrasena es incorrecta...", Toast.LENGTH_LONG).show()
                    }
                }*/

}
