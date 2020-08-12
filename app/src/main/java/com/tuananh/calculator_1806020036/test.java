package com.tuananh.calculator_1806020036;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.TextView;

public class test extends AppCompatActivity {

    private boolean isOpPressed = false;
    private double firstNumber = 0;
    private int secondNumberIndex = 0;
    private char currentOp = 0;
    private  boolean isDot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        final TextView inputAndShow = findViewById(R.id.inputAndShow);
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button dot = findViewById(R.id.dot);
        final Button backspace = findViewById(R.id.backspace);
        final Button delete = findViewById(R.id.delete);
        final Button cong = findViewById(R.id.cong);
        final Button tru = findViewById(R.id.tru);
        final Button nhan = findViewById(R.id.nhan);
        final Button chia = findViewById(R.id.chia);
        final Button ketqua = findViewById(R.id.ketqua);

        final View.OnClickListener maytinh_langnghesukien = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int id = view.getId();
                switch (id) {
                    case R.id.n0:
                        inputAndShow.append("0");
                        break;
                    case R.id.n1:
                        inputAndShow.append("1");
                        break;
                    case R.id.n2:
                        inputAndShow.append("2");
                        break;
                    case R.id.n3:
                        inputAndShow.append("3");
                        break;
                    case R.id.n4:
                        inputAndShow.append("4");
                        break;
                    case R.id.n5:
                        inputAndShow.append("5");
                        break;
                    case R.id.n6:
                        inputAndShow.append("6");
                        break;
                    case R.id.n7:
                        inputAndShow.append("7");
                        break;
                    case R.id.n8:
                        inputAndShow.append("8");
                        break;
                    case R.id.n9:
                        inputAndShow.append("9");
                        break;
                    case R.id.dot:
                        if (! isDot)
                        inputAndShow.append(".");
                        isDot = true;
                        break;
                    case R.id.backspace:
                        break;
                    case R.id.delete:
                        break;
                    case R.id.cong:
                        String screenContent = inputAndShow.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(screenContent);
                        inputAndShow.append("+");
                        currentOp = '+';
                        isDot = false;
                        isOpPressed = true;
                        break;
                    case R.id.tru:
                        screenContent = inputAndShow.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(screenContent);
                        inputAndShow.append("-");
                        currentOp = '-';
                        isDot = false;
                        isOpPressed = true;
                        break;
                    case R.id.nhan:
                        screenContent = inputAndShow.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(screenContent);
                        inputAndShow.append("*");
                        currentOp = '*';
                        isDot = false;
                        isOpPressed = true;
                        break;
                    case R.id.chia:
                        screenContent = inputAndShow.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(screenContent);
                        inputAndShow.append("/");
                        currentOp = '/';
                        isDot = false;
                        isOpPressed = true;
                        break;
                    case R.id.ketqua:
                        if (isOpPressed) {
                            isOpPressed =false;
                            screenContent = inputAndShow.getText().toString();
                            String secondNumberString = screenContent.substring(secondNumberIndex, screenContent.length());
                            double secondNumber = Double.parseDouble(secondNumberString);

                            if (currentOp == '+') {
                                secondNumber += firstNumber;
                            } else if (currentOp == '-') {
                                secondNumber = firstNumber - secondNumber;
                            }else if (currentOp == '*') {
                                secondNumber *= firstNumber;
                            }else if (currentOp == '/') {
                                if (secondNumber == 0){
                                    return;
                                }
                                secondNumber = firstNumber / secondNumber;
                            }

                            String result = String.valueOf(secondNumber);
                            if (result.endsWith(".0")) {
                                result = result.substring(0, result.length() - 2);
                            }
                            inputAndShow.setText(result);
                        }
                        break;
                }
            }
        };
        n0.setOnClickListener(maytinh_langnghesukien);
        n1.setOnClickListener(maytinh_langnghesukien);
        n2.setOnClickListener(maytinh_langnghesukien);
        n3.setOnClickListener(maytinh_langnghesukien);
        n4.setOnClickListener(maytinh_langnghesukien);
        n5.setOnClickListener(maytinh_langnghesukien);
        n6.setOnClickListener(maytinh_langnghesukien);
        n7.setOnClickListener(maytinh_langnghesukien);
        n8.setOnClickListener(maytinh_langnghesukien);
        n9.setOnClickListener(maytinh_langnghesukien);
        dot.setOnClickListener(maytinh_langnghesukien);
        backspace.setOnClickListener(maytinh_langnghesukien);
        delete.setOnClickListener(maytinh_langnghesukien);
        cong.setOnClickListener(maytinh_langnghesukien);
        tru.setOnClickListener(maytinh_langnghesukien);
        nhan.setOnClickListener(maytinh_langnghesukien);
        chia.setOnClickListener(maytinh_langnghesukien);
        ketqua.setOnClickListener(maytinh_langnghesukien);

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dispeElements = inputAndShow.getText().toString();
                int lenght = dispeElements.length();
                if (lenght > 0) {
                    dispeElements = dispeElements.substring(0, lenght - 1);
                    inputAndShow.setText(dispeElements);
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputAndShow.setText("");
                isOpPressed = false;
                isDot = false;
            }
        });
    }
}