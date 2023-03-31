package br.com.fa.appmotta.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fa.appmotta.R


/**
 * A simple [Fragment] subclass.
 * Use the [CompanyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompanyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company, container, false)
    }


}