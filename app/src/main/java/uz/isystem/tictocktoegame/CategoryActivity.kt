package uz.isystem.tictocktoegame

import android.content.Intent
import android.os.Bundle
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


    }
}