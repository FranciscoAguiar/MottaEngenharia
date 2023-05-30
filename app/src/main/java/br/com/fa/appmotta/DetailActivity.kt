package br.com.fa.appmotta

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fa.appmotta.model.Model

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val model = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("model", Model::class.java)
        } else {
            intent.getParcelableExtra<Model>("model")
        }
        if (model != null) {
            System.out.println("Teste----------1"+ model.title)
            supportActionBar?.setTitle(model.title)
        }
    }
}