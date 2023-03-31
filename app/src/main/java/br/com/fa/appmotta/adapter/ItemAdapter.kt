package br.com.fa.appmotta.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fa.appmotta.R
import br.com.fa.appmotta.model.Model
import kotlinx.android.synthetic.main.row.view.*


class ItemAdapter(val arrayList: ArrayList<Model>, val context: Context):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view:View): RecyclerView.ViewHolder(view){


        fun bindItems(model: Model){
            val textView: TextView = view.findViewById(R.id.titleTv)
            val description: TextView = view.findViewById(R.id.descriptionTv)
            val imageIv: ImageView = view.findViewById(R.id.imageIv)

            textView.text = model.title
            description.text = model.des
            imageIv.setImageResource(model.image)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = arrayList[position]
        holder.bindItems(item)
    }
}