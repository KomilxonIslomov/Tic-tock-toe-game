package uz.isystem.tictocktoegame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import uz.isystem.tictocktoegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var player1 = 0
    var player2 = 1
    var ActivePlayer = player1
    lateinit var filtag: IntArray
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        EditName()

        binding.exit.setOnClickListener {
            onBackPressed()
        }



        filtag = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)


        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        var buttonClicked = findViewById<TextView>(p0!!.id)
//        var clickTag=Integer.parseInt(buttonClicked.tag.toString())
//
//        if (filtag[clickTag]!=-1)
//            return
//        filtag[clickTag]=ActivePlayer
        if (ActivePlayer == player1) {
            buttonClicked.text = "x"
            buttonClicked.isEnabled = false
            buttonClicked.setBackgroundResource(R.drawable.x_back)
            ActivePlayer = player2
            binding.player1.setBackgroundResource(R.drawable.shape2)
            binding.player2.setBackgroundResource(R.drawable.shape1)
        } else {
            buttonClicked.text = "o"
            buttonClicked.isEnabled = false
            ActivePlayer = player1
            buttonClicked.setBackgroundResource(R.drawable.o_back)
            binding.player2.setBackgroundResource(R.drawable.shape2)
            binding.player1.setBackgroundResource(R.drawable.shape1)
        }
        checkWin()


    }

    var a = 0

    private fun checkWin() {
        if (binding.btn1.text == "x" && binding.btn2.text == "x" && binding.btn3.text == "x"
            || binding.btn1.text == "x" && binding.btn4.text == "x" && binding.btn7.text == "x"
            || binding.btn1.text == "x" && binding.btn5.text == "x" && binding.btn9.text == "x"
            || binding.btn2.text == "x" && binding.btn5.text == "x" && binding.btn8.text == "x"
            || binding.btn3.text == "x" && binding.btn5.text == "x" && binding.btn7.text == "x"
            || binding.btn3.text == "x" && binding.btn6.text == "x" && binding.btn9.text == "x"
            || binding.btn4.text == "x" && binding.btn5.text == "x" && binding.btn6.text == "x"
            || binding.btn7.text == "x" && binding.btn8.text == "x" && binding.btn9.text == "x"
        ) {
            a = 1

        }
        if (binding.btn1.text == "o" && binding.btn2.text == "o" && binding.btn3.text == "o"
            || binding.btn1.text == "o" && binding.btn4.text == "o" && binding.btn7.text == "o"
            || binding.btn1.text == "o" && binding.btn5.text == "o" && binding.btn9.text == "o"
            || binding.btn2.text == "o" && binding.btn5.text == "o" && binding.btn8.text == "o"
            || binding.btn3.text == "o" && binding.btn5.text == "o" && binding.btn7.text == "o"
            || binding.btn3.text == "o" && binding.btn6.text == "o" && binding.btn9.text == "o"
            || binding.btn4.text == "o" && binding.btn5.text == "o" && binding.btn6.text == "o"
            || binding.btn7.text == "o" && binding.btn8.text == "o" && binding.btn9.text == "o"
        ) {
            a = 2

        }
        if (binding.btn1.text.length + binding.btn2.text.length + binding.btn3.text.length + binding.btn4.text.length +
            binding.btn5.text.length + binding.btn6.text.length + binding.btn7.text.length + binding.btn8.text.length +
            binding.btn9.text.length == 9 && a != 1 && a != 2
        ) {
            a = 3
        }
        if (a == 1) {
            showAlert("${binding.player1Name.text}" + "  yutdi\n Agar o'yinga ishtiyoq bo'lsa\n qayta o'ynang!")
        } else if (a == 2) {
            showAlert(
                "${binding.player2Name.text}" + "yutdi\n" +
                        " Agar o'yinga ishtiyoq bo'lsa\n" +
                        " qayta o'ynang!"
            )
        } else if (a == 3) {
            showAlert(
                "Hech kim yutmadi\n" +
                        " Agar o'yinga ishtiyoq bo'lsa\n" +
                        " qayta o'ynang!"
            )
        }

    }

    private fun showAlert(name1: String) {
        val view = View.inflate(this@MainActivity, R.layout.dialog_view, null)

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val restart = view.findViewById<Button>(R.id.retry)
        val exit = view.findViewById<TextView>(R.id.exit)
        var name = view.findViewById<TextView>(R.id.name)
        name.text = name1

        restart.setOnClickListener {
            dialog.dismiss()
            a = 0
            ActivePlayer = player1
            binding.btn1.text = ""
            binding.btn2.text = ""
            binding.btn3.text = ""
            binding.btn4.text = ""
            binding.btn5.text = ""
            binding.btn6.text = ""
            binding.btn7.text = ""
            binding.btn8.text = ""
            binding.btn9.text = ""
            binding.btn1.setBackgroundResource(R.drawable.shape)
            binding.btn2.setBackgroundResource(R.drawable.shape)
            binding.btn3.setBackgroundResource(R.drawable.shape)
            binding.btn4.setBackgroundResource(R.drawable.shape)
            binding.btn5.setBackgroundResource(R.drawable.shape)
            binding.btn6.setBackgroundResource(R.drawable.shape)
            binding.btn7.setBackgroundResource(R.drawable.shape)
            binding.btn8.setBackgroundResource(R.drawable.shape)
            binding.btn9.setBackgroundResource(R.drawable.shape)

            binding.btn1.isEnabled = true
            binding.btn2.isEnabled = true
            binding.btn3.isEnabled = true
            binding.btn4.isEnabled = true
            binding.btn5.isEnabled = true
            binding.btn6.isEnabled = true
            binding.btn7.isEnabled = true
            binding.btn8.isEnabled = true
            binding.btn9.isEnabled = true
            binding.player1.setBackgroundResource(R.drawable.shape1)
            binding.player2.setBackgroundResource(R.drawable.shape2)
        }
        exit.setOnClickListener {
            dialog.dismiss()
            finish()
        }

    }

    private fun EditName() {
        val view = View.inflate(this@MainActivity, R.layout.name_dialog, null)

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        var player1_name = view.findViewById<EditText>(R.id.player1_name)
        var player2_name = view.findViewById<EditText>(R.id.player2_name)
        var start = view.findViewById<Button>(R.id.start)
        start.setOnClickListener {
            binding.player1Name.text = player1_name.text
            binding.player2Name.text = player2_name.text
            dialog.dismiss()
        }
    }
}