package edu.uph.m23si3.erikaapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculatorActivity extends AppCompatActivity {

    EditText inputA, inputB;
    Button btnTambah, btnKali, btnBagi;
    TextView txvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        btnTambah = findViewById(R.id.btnTambah);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        txvHasil = findViewById(R.id.txvHasil);

        btnTambah.setOnClickListener(v -> {
            if (cekInput()) {
                double a = Double.parseDouble(inputA.getText().toString());
                double b = Double.parseDouble(inputB.getText().toString());
                double hasil = a + b;
                if (hasil == (int) hasil) {
                    txvHasil.setText(String.valueOf((int) hasil));
                } else {
                    txvHasil.setText(String.valueOf(hasil));
                }
            }
        });

        btnKali.setOnClickListener(v -> {
            if (cekInput()) {
                double a = Double.parseDouble(inputA.getText().toString());
                double b = Double.parseDouble(inputB.getText().toString());
                double hasil = a * b;
                if (hasil == (int) hasil) {
                    txvHasil.setText(String.valueOf((int) hasil));
                } else {
                    txvHasil.setText(String.valueOf(hasil));
                }
            }
        });

        btnBagi.setOnClickListener(v -> {
            if (cekInput()) {
                double a = Double.parseDouble(inputA.getText().toString());
                double b = Double.parseDouble(inputB.getText().toString());

                if (b == 0) {
                    Toast.makeText(this, "Tidak bisa dibagi nol", Toast.LENGTH_SHORT).show();
                } else {
                    double hasil = a / b;
                    if (hasil == (int) hasil) {
                        txvHasil.setText(String.valueOf((int) hasil));
                    } else {
                        txvHasil.setText(String.valueOf(hasil));
                    }
                }
            }
        });
    }

    private boolean cekInput() {
        if (inputA.getText().toString().isEmpty() || inputB.getText().toString().isEmpty()) {
            Toast.makeText(this, "Mohon isi kedua nilai terlebih dahulu", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}