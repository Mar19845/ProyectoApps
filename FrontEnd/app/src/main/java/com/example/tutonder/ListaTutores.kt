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
import androidx.recyclerview.widget.RecyclerView
import com.example.tutonder.databinding.FragmentListaTutoresBinding
import com.example.tutonder.databinding.FragmentLoginBinding
import com.example.tutonder.network.User

/**
 * A simple [Fragment] subclass.
 */
class ListaTutores : Fragment() {
    private lateinit var viewModel: ListaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingListaTutores = DataBindingUtil.inflate<FragmentListaTutoresBinding>(inflater,
            R.layout.fragment_lista_tutores,container,false)



        viewModel = ViewModelProviders.of(this).get(ListaViewModel::class.java)
        val usuario: LiveData<List<User>> = viewModel.userResponse

        bindingListaTutores.button2.setOnClickListener(){
            viewModel.getUser(bindingListaTutores.editText.text.toString())
            usuario.observe(viewLifecycleOwner, Observer {
                Toast.makeText(context, usuario.value.toString(), Toast.LENGTH_SHORT).show()
                if(usuario.value == null){
                    Toast.makeText(context,"No se ha encontrado al usuario :(", Toast.LENGTH_LONG).show()
                }else{
                    if(usuario.value!!.password ==  bindingListaTutores.Contrasena.text.toString()){bindingListaTutores
                        Toast.makeText(context,"Logged :)", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"Parece que tu contrasena es incorrecta...", Toast.LENGTH_LONG).show()
                    }
                }
            })
        }




















        return bindingListaTutores.root
    }
}
