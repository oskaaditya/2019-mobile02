package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //  TODO: deklarasikan variabel di sini
    private EditText number_input;
    int angka_random = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: bind layout di sini
        number_input = (EditText) findViewById(R.id.number_input);
        initRandomNumber();
    }

    // TODO: generate angka random di sini
    private void initRandomNumber() {
        Random r = new Random();
        if (angka_random == 0) {
            angka_random = r.nextInt(100);
        } else {
            angka_random = angka_random;
        }
    }

    public void handleGuess(View view) {
        // TODO: Tambahkan logika untuk melakukan pengecekan angka
        initRandomNumber();
        if (number_input.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Isikan Tebakan Angka Anda!!", Toast.LENGTH_SHORT).show();
        } else {
            if (angka_random == Integer.parseInt(number_input.getText().toString().trim())) {
                Toast.makeText(this,"Tebakan Anda Benar",Toast.LENGTH_SHORT).show();
                number_input.setText("");
            } else if (angka_random < Integer.parseInt(number_input.getText().toString().trim())) {
                Toast.makeText(this,"Tebakan Anda Terlalu Besar",Toast.LENGTH_SHORT).show();
                number_input.setText("");
            } else if (angka_random > Integer.parseInt(number_input.getText().toString().trim())) {
                Toast.makeText(this, "Tebakan Anda Terlalu Kecil",Toast.LENGTH_SHORT).show();
                number_input.setText("");
            }
        }
    }

    public void handleReset(View view) {
        // TODO: Reset tampilan
        angka_random = 0;
        initRandomNumber();
        number_input.setText("");
        Toast.makeText(this,"Berhasil Direset",Toast.LENGTH_SHORT).show();

    }
}
