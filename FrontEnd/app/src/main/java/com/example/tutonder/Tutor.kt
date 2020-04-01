package com.example.tutonder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tutonder.databinding.FragmentLoginBinding
import com.example.tutonder.databinding.FragmentTutorBinding

/**
 * A simple [Fragment] subclass.
 */
class Tutor : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingTutor = DataBindingUtil.inflate<FragmentTutorBinding>(inflater,
            R.layout.fragment_tutor,container,false)
        return bindingTutor.root
    }

}
