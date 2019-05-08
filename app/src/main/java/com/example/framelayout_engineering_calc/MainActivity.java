package com.example.framelayout_engineering_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button engineeringCalc;
    private EditText textResult;
    Double result = null;
    Double number = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = findViewById(R.id.text_result);
        engineeringCalc = findViewById(R.id.btn_engineering_calc);
        LinearLayout layoutSimpleCalc = findViewById(R.id.buttons_simple_calc);
        LinearLayout layoutEngineeringCalc = findViewById(R.id.buttons_engineering_calc);
        LinearLayout layoutEngineeringCalc2 = findViewById(R.id.buttons_engineering_calc_2);


    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        textResult.append(button.getText().toString());

        if (textResult.getText().toString().contains(".")) {
            Button btn = (Button) findViewById(R.id.btn_decimal_point);
            btn.setEnabled(false);
        }

    }

    public void onChangeCalc(View view) {
        Button button = (Button) view;
        LinearLayout layoutSimpleCalc = findViewById(R.id.buttons_simple_calc);
        LinearLayout layoutEngineeringCalc = findViewById(R.id.buttons_engineering_calc);
        LinearLayout layoutEngineeringCalc2 = findViewById(R.id.buttons_engineering_calc_2);

        if (layoutSimpleCalc.getVisibility() == View.GONE) {
            layoutSimpleCalc.setVisibility(View.VISIBLE);
            layoutEngineeringCalc.setVisibility(View.GONE);
            layoutEngineeringCalc2.setVisibility(View.GONE);
        } else {
            layoutEngineeringCalc.setVisibility(View.VISIBLE);
            layoutEngineeringCalc2.setVisibility(View.VISIBLE);
            layoutSimpleCalc.setVisibility(View.GONE);
        }
    }


    public void onOperationClick(View view) {
        Button button = (Button) view;
        number = Double.parseDouble(textResult.getText().toString());
        if (result == null) {
            result = number;
        }
        switch (view.getId()) {
            case R.id.btn_plus:
                textResult.setText(null);
                result += number;
                break;
            case R.id.btn_minus:
                textResult.setText(null);
                result -= number;
                break;
            case R.id.btn_X:
                textResult.setText(null);
                result *= number;
                break;
            case R.id.btn_div:
                textResult.setText(null);
                if (number != 0) {
                    result /= number;
                } else {
                    Toast.makeText(MainActivity.this, "На ноль делить нельзя", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_C:
                textResult.setText(null);
                result = null;
                number = null;
                break;

            case R.id.btn_sign:
                number = number * -1;
                textResult.setText(Double.toString(number));
                break;
            case R.id.btn_percent:
                number = number / 100;
                textResult.setText(Double.toString(number));
                break;
            case R.id.btn_equals:
                textResult.setText(null);
                textResult.setText(Double.toString(result));
                number = null;
                result = null;
                break;
            default:
                Toast.makeText(MainActivity.this, "Ошибка", Toast.LENGTH_LONG).show();
                break;


        }
    }
}