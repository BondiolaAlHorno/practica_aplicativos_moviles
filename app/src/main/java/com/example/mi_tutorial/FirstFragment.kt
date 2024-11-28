package com.example.mi_tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mi_tutorial.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    var visib = 0

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.primerBoton.setOnClickListener {
          //  cambiarTexto()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.segundoBoton.setOnClickListener {
              cambiarTexto()
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun cambiarTexto(){
        if (binding.segundoBoton.text == "hola") {
            binding.segundoBoton.text = "chau"
            Toast.makeText(context, "hola", Toast.LENGTH_LONG).show()
            binding.segundoBoton.setBackgroundColor(0xffffff00.toInt())
        }
        else{
            binding.segundoBoton.text = "hola"
            Toast.makeText(context, "chau", Toast.LENGTH_LONG).show()
            binding.segundoBoton.setBackgroundColor(0xffffff00.toInt())
        }
        //if (binding.primerBoton.visibility == VISIBLE){binding.primerBoton.visibility == View.INVISIBLE}
        //binding.primerBoton.visibility=View.INVISIBLE
        /*if(binding.primerBoton.visibility == View.VISIBLE){
                binding.primerBoton.visibility == View.INVISIBLE
            }
        else{
                binding.primerBoton.visibility == View.VISIBLE
            }*/
        /*val visib =  binding.primerBoton.visibility
        binding.primerBoton.text = visib.toString()
        binding.primerBoton.setVisibility(View.VISIBLE) */
        if (visib == 0) {
            binding.primerBoton.visibility = View.INVISIBLE
            visib=1
            }
        else {
            binding.primerBoton.visibility = View.VISIBLE
            visib=0
            }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}