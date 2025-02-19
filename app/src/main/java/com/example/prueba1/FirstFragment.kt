package com.example.prueba1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prueba1.client.Clients
import com.example.prueba1.databinding.FragmentFirstBinding
import com.example.prueba1.model.Tarea
import com.example.prueba1.service.TareaService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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

        val api = Clients.instance(view.context).create(TareaService::class.java)
        api.getAll().enqueue(object : Callback<List<Tarea>> {
            override fun onResponse(call: Call<List<Tarea>>, response: Response<List<Tarea>>) {
                if (response.isSuccessful) {
                    response.body()?.let {tareas ->
                        for (tarea in tareas){
                            Log.d("Tarea","ID: ${tarea.id}, Nombre: ${tarea.nombre}")
                        }
                    }
                }
            }

            override fun onFailure(p0: Call<List<Tarea>>, t: Throwable) {
                Log.e("Error", "Error en el API: ${t.message}")
                }
            })

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}