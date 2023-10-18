package br.com.fa.appmotta

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.PhoneLookup
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.fa.appmotta.databinding.ActivityMainBinding
import br.com.fa.appmotta.model.Model
import com.google.android.material.textfield.TextInputEditText
import java.net.URLEncoder


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var modelObject : Model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val btn_orcamento = findViewById<Button>(R.id.calculate_button);
        btn_orcamento.setOnClickListener{sendProposal()}


        val model = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("model", Model::class.java)
        } else {
            intent.getParcelableExtra<Model>("model")
        }
        if (model != null) {
            modelObject = model
            supportActionBar?.setTitle(model.title)
        }
    }


    private fun sendProposal(){
        val qdteArEditText = findViewById<TextInputEditText>(R.id.qtde_ar_edit_text)
        val optionsplitCheckBox = findViewById<CheckBox>(R.id.option_split)
        val optionnormalCheckBox = findViewById<CheckBox>(R.id.option_normal)
        val optiontmocCheckBox = findViewById<CheckBox>(R.id.option_tmoc)

        var tipoSplit : String = ""
        var tipoNormal : String = ""
        var tipoTmoc : String = ""
        if (optionsplitCheckBox.isChecked){
            tipoSplit = "Split"
        }
        if (optionnormalCheckBox.isChecked){
            tipoNormal = "Normal"
        }
        if (optiontmocCheckBox.isChecked){
            tipoTmoc = "TMOC"
        }
        var tipoComplete : String = ""
        if (tipoSplit.length>0){
            tipoComplete =  tipoSplit;
        }
        if (tipoNormal.length>0){
            if (tipoComplete.length>0){
                tipoComplete += ", "+tipoNormal
            }else{
                tipoComplete = tipoNormal
            }
        }

        if (tipoTmoc.length>0){
            if (tipoComplete.length>0){
                tipoComplete += ", "+tipoTmoc
            }else{
                tipoComplete = tipoTmoc
            }
        }

        val url = "https://api.whatsapp.com/send?phone=+5592981002358"+"&text=" + URLEncoder.encode("Serviço:"+ modelObject.title + "\n Quantidade de Equipamentos:"+qdteArEditText.text.toString() + " \n Tipos: "+ tipoComplete, "UTF-8");
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)

    }





}