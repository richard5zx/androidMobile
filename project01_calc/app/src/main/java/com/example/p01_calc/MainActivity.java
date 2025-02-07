package com.example.p01_calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private Double result;

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
        if (etA.length() == 0 || etB.length() == 0) { // When no entry
            System.out.println(tvOper.getText().toString());
            Toast.makeText(MainActivity.this, "Must enter two numbers", Toast.LENGTH_SHORT).show();
            return; // 中斷執行
        }

        String strA = etA.getText().toString(); // Type: Editable -> String
        String strB = etB.getText().toString(); // Type: Editable -> String
        Double a = Double.parseDouble(strA);
        Double b = Double.parseDouble(strB);

        int viewId = view.getId();

        if (viewId == btnIds[0]) {
            //System.out.println("add");
            tvOper.setText("➕");
            result = a + b;
        } else if (viewId == btnIds[1]) {
            //System.out.println("sub");
            tvOper.setText("➖");
            result = a - b;
        } else if (viewId == btnIds[2]) {
            //System.out.println("mul");
            tvOper.setText("✖\uFE0F");
            result = a * b;
        } else if (viewId == btnIds[3]) {
            //System.out.println("div");
            tvOper.setText("➗");
            result = a / b;
        } else if (viewId == btnIds[4]) {
            //System.out.println("cal");
            if (tvOper.getText().toString().equals("(Select Operator)")) {
                Toast.makeText(MainActivity.this, "Must enter operator", Toast.LENGTH_SHORT).show();
                return;
            }
            tvResult.setText(String.format("%.2f", result));
        } else if (viewId == btnIds[5]) {
            //System.out.println("reset");
            tvOper.setText("(Select Operator)");
            etA.setText("");
            etA.requestFocus(); // Move cursor back to etA textbox instead of staying in etB textbox
            etB.setText("");
            tvResult.setText("0.0");
        }
    }

}

// Unicode Symbols
// 加  '\u2795'   ➕
// 減  '\u2796'   ➖
// 乘  '\u2716'   ✖️
// 除  '\u2797'   ➗
// 等於  '\u003D'  🟰