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
    ): View {
        val bindingListaTutores = DataBindingUtil.inflate<FragmentListaTutoresBinding>(
            inflater,
            R.layout.fragment_lista_tutores, container, false
        )

        viewModel = ViewModelProviders.of(this).get(ListaViewModel::class.java)
        val tutor: LiveData<List<User>> = viewModel.userResponse

        tutor.observe(viewLifecycleOwner, Observer {
            val tutors = tutor.value
        })

        bindingListaTutores.button2.setOnClickListener() {
            viewModel.getUser(bindingListaTutores.editText.text.toString())
            Toast.makeText(context, tutor.value.toString(), Toast.LENGTH_SHORT).show()

            if (tutor.value == null) {
                Toast.makeText(context, "No se ha encontrado al usuario :(", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(context, "Se encuentra el usuario :(", Toast.LENGTH_LONG).show()
            }
        }
        return bindingListaTutores.root
    }
}