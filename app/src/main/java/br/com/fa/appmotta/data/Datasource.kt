package br.com.fa.appmotta.data

import android.view.Display.Mode
import br.com.fa.appmotta.R
import br.com.fa.appmotta.model.Model

class Datasource {

    fun loadModels(): ArrayList<Model>{
        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Limpeza","Limpeza de Ar Condicionado", R.drawable.ic_house_2))
        arrayList.add(Model("Manutenção","Manutenção de Ar Condicionado", R.drawable.ic_house_2))
        arrayList.add(Model("Manutenção e Limpeza","Manutenção e Limpeza de Ar Condicionado", R.drawable.ic_house_2))
        arrayList.add(Model("Manutenção Periódica","Serviços realizados a cada período de tempo", R.drawable.ic_house_2))
        return arrayList
    }
}