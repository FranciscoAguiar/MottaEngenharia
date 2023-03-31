package br.com.fa.appmotta

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.fa.appmotta.adapter.ItemAdapter
import br.com.fa.appmotta.data.Datasource
import br.com.fa.appmotta.databinding.ActivityMainBinding

import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val adapter = ViewPageAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.adapter = adapter;

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab,position ->
            when(position){
                0->{
                    tab.text = "Serviços"

                }
                1->{
                    tab.text = "Empresa"

                }
            }
        }.attach()



    }
}