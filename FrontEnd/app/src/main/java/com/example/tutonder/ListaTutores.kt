package com.example.tutonder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tutonder.databinding.FragmentListaTutoresBinding
import com.example.tutonder.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 */
class ListaTutores : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingListaTutores = DataBindingUtil.inflate<FragmentListaTutoresBinding>(inflater,
            R.layout.fragment_lista_tutores,container,false)
        return bindingListaTutores.root
    }

}
