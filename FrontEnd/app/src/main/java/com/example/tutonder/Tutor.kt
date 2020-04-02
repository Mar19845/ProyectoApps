package com.example.tutonder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tutonder.databinding.FragmentLoginBinding
import com.example.tutonder.databinding.FragmentTutorBinding
import com.example.tutonder.network.User

/**
 * A simple [Fragment] subclass.
 */
class Tutor : Fragment() {
    private lateinit var viewModel: TutorViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingTutor = DataBindingUtil.inflate<FragmentTutorBinding>(inflater,
            R.layout.fragment_tutor,container,false)

        viewModel = ViewModelProviders.of(this).get(TutorViewModel::class.java)
        val usuario: LiveData<User> = viewModel.userResponse

        bindingTutor.botonIngresar.setOnClickListener(){
            viewModel.getUser(bindingTutor.Usuario.text.toString())
            usuario.observe(viewLifecycleOwner, Observer {
                Toast.makeText(context, usuario.value.toString(), Toast.LENGTH_SHORT).show()
                if(usuario.value == null){
                    Toast.makeText(context,"No se ha encontrado al usuario :(", Toast.LENGTH_LONG).show()
                }else{
                    if(usuario.value!!.password == bindingTutor.Contrasena.text.toString()){
                        Toast.makeText(context,"Logged :)", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"Parece que tu contrasena es incorrecta...", Toast.LENGTH_LONG).show()
                    }
                }
            })
        }

















        return bindingTutor.root
    }
}
