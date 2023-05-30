package br.com.fa.appmotta.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fa.appmotta.DetailActivity
import br.com.fa.appmotta.R
import br.com.fa.appmotta.adapter.ItemAdapter
import br.com.fa.appmotta.data.Datasource
import kotlinx.android.synthetic.main.fragment_menu.*


/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val myDataset = Datasource().loadModels()
        var myAdapter = ItemAdapter(myDataset, requireContext())
        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter =  myAdapter
        }

        myAdapter.onItemClick = {
            System.out.println("----------------teste")

            val intent = Intent(requireContext(),DetailActivity::class.java)
            intent.putExtra("model", it)
            System.out.println("----------------teste"+it.title)

            startActivity(intent)


        }


    }


}