package com.example.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {
    Float var1, var2;
    String operator, stemp = "";
    EditText edtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] idButton = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btnSubmit,
                R.id.btn8, R.id.btn9, R.id.btnSum, R.id.btnSub, R.id.btnMul, R.id.btnDiv, R.id.btnDelete, R.id.btnAC, R.id.btnDot};
        for (int id : idButton) {
            View v = (View) findViewById(id);
            v.setOnClickListener(this);
        }
        edtResult = findViewById(R.id.edtResult);
    }

    private void operatorClicked() {
        var1 = Float.parseFloat(edtResult.getText().toString());
        stemp = "";
        edtResult.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAC:
                var1 = 0f;
                var2 = 0f;
                stemp = "";
                edtResult.setText("");
                break;
            case R.id.btnDelete:
                stemp = stemp.substring(0, stemp.length() - 1);
                edtResult.setText(stemp);
                break;
            case R.id.btnSum:
                operator = "+";
                operatorClicked();
                break;
            case R.id.btnSub:
                operator = "-";
                operatorClicked();
                break;
            case R.id.btnMul:
                operator = "*";
                operatorClicked();
                break;
            case R.id.btnDiv:
                operator = "/";
                operatorClicked();
                break;
            case R.id.btnSubmit:
                Float Ans = 0f;
                var2 = Float.parseFloat(edtResult.getText().toString());
                switch (operator) {
                    case "+":
                        Ans = var1 + var2;
                        break;
                    case "-":
                        Ans = var1 - var2;
                        break;
                    case "*":
                        Ans = var1 * var2;
                        break;
                    case "/":
                        Ans = var1 / var2;
                        break;
                }
                Log.d("result: ", "" + Ans);
                var1 = Ans;
                if (Ans == Math.round(Ans)) {
                    String ss = Ans.toString().substring(0,Ans.toString().length()-2);
                    edtResult.setText(ss);
                } else
                    edtResult.setText(Ans.toString());
                break;
            default:
                stemp += ((Button) v).getText().toString();
                edtResult.setText(stemp);
        }
    }
}
