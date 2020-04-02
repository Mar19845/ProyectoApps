package com.example.tutonder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tutonder.databinding.FragmentEditarTutorBinding
import com.example.tutonder.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 */
class editarTutor : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingeditarTutor = DataBindingUtil.inflate<FragmentEditarTutorBinding>(inflater,
            R.layout.fragment_editar_tutor,container,false)
        return bindingeditarTutor.root
    }

}
