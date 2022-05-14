package uz.isystem.tictocktoegame

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import uz.isystem.tictocktoegame.databinding.ActivityAiBinding

class AiActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityAiBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAiBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onClick(p0: View?) {
    }
}


