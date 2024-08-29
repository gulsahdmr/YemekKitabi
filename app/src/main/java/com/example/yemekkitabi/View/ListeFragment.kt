package com.example.yemekkitabi.View
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.yemekkitabi.Adapter.tarifAdapter
import com.example.yemekkitabi.Model.Tarif
import com.example.yemekkitabi.Roomdb.TarifDAO
import com.example.yemekkitabi.Roomdb.TarifDataBase
import com.example.yemekkitabi.databinding.FragmentListe2Binding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ListeFragment : Fragment() {

    private var _binding: FragmentListe2Binding? = null
    private val binding get() = _binding!!
    private  lateinit var db : TarifDataBase
    private lateinit var tarifdao: TarifDAO
    private val mDisposable =CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room.databaseBuilder(requireContext(), TarifDataBase::class.java,"Tarifler").build()
        tarifdao=db.tarifdao()



    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListe2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener{ (addNew(it)) }
        binding.RecyclerView.layoutManager=LinearLayoutManager(requireContext())
    verilerial()
    }
    private fun verilerial(){
        mDisposable.add(
            tarifdao.getall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResponse)
        )
    }
    private fun handleResponse (tarifler:List<Tarif>){
        val adapter=tarifAdapter(tarifler)
        binding.RecyclerView.adapter=adapter
        }

    }

    fun addNew(view: View) {
        val action = ListeFragmentDirections.actionListeFragmentToTarifFragment(bilgi = "yeni", id = 1)
        Navigation.findNavController(view).navigate(action)
    }


