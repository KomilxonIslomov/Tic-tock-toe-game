package uz.isystem.tictocktoegame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import uz.isystem.tictocktoegame.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private var _binding: ActivityCategoryBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.friendsStart.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.aiStart.setOnClickListener {
            showAlert()
        }


    }

    private fun showAlert() {
        val view = View.inflate(this@CategoryActivity, R.layout.dialog_category, null)

        val builder = AlertDialog.Builder(this@CategoryActivity)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val exit = view.findViewById<TextView>(R.id.exit)
        exit.setOnClickListener {
            dialog.dismiss()
        }

    }
}