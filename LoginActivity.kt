package www.studytask.ptbr.ceara

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val nameInput = findViewById<EditText>(R.id.name_input)
        val checkButton = findViewById<Button>(R.id.check_button)

        // Nome cadastrado no sistema Aluno Online
        val registeredName = "João da Silva"

        checkButton.setOnClickListener {
            val enteredName = nameInput.text.toString().trim()

            if (enteredName.isNotEmpty()) {
                if (enteredName.equals(registeredName, ignoreCase = true)) {
                    // Nome autorizado
                    Toast.makeText(
                        this,
                        "Acesso autorizado pelo Aluno Online",
                        Toast.LENGTH_LONG
                    ).show()

                    // Redirecionar para MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Nome não autorizado
                    Toast.makeText(
                        this,
                        "Acesso Negado. Verifique com a SEDUC se possui Cadastro no Aluno Online",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                // Campo vazio
                Toast.makeText(this, "Por favor, digite seu nome.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
