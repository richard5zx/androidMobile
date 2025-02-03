package com.example.p01_calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Variables
    private EditText etA, etB;
    private TextView tvOper, tvResult;
    private Button[] btns = new Button[6];
    private int[] btnIds = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv, R.id.btnCal, R.id.btnReset};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();

    }

    private void initView() {
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        tvOper = findViewById(R.id.tvOper);
        tvResult = findViewById(R.id.tvResult);
        for (int i = 0; i < btns.length; i++) {
            btns[i] = findViewById(btnIds[i]);
        }
    }

    public void onClick(View view) {

    }

}