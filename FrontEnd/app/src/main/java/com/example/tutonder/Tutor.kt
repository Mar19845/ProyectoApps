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
        val bindingTutor = DataBindingUtil.inflate<FragmentTutorBinding>(
            inflater,
            R.layout.fragment_tutor, container, false
        )

        viewModel = ViewModelProviders.of(this).get(TutorViewModel::class.java)
        val tutor: LiveData<User> = viewModel.userResponse


        viewModel.getUser("aqui necesita saber el nombre que escogio el ususario antes")
        tutor.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, tutor.value.toString(), Toast.LENGTH_SHORT).show()
            if (tutor.value == null) {
                Toast.makeText(context, "No se ha encontrado al tutor seleccionado :(", Toast.LENGTH_LONG)
                    .show()
            } else {
                bindingTutor.NombreTutor.setText(tutor.value!!.nombre)
                bindingTutor.InfoTutor.setText(tutor.value!!.detalles)
                val rate = bindingTutor.RateTutor.rating
                bindingTutor.TutorNombre.setText(tutor.value!!.nombre)
                bindingTutor.Carrera.setText(tutor.value!!.carrera)
                // como pongo el list del usuario aqui
                bindingTutor.Cursos.setText(tutor.value!!.cursos.toString())
                bindingTutor.Contacto.setText(tutor.value!!.contacto)
                bindingTutor.BotonGuardar.setOnClickListener(){
                    val comentario=bindingTutor.CajaComentarios.toString()
                    //tutor.value!!.comentarios= comentario

                }
            }
        })


















        return bindingTutor.root
    }
}
