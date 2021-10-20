package com.example.classycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calculateBtn(View view) {
        EditText etNumberOne = (EditText) findViewById(R.id.firstNumber);
        double firstNumber;
        if(TextUtils.isEmpty(etNumberOne.getText().toString())) {
            etNumberOne.setError("Please enter a number");
            return;
        } else {
            firstNumber = Double.parseDouble(etNumberOne.getText().toString());
        }

        EditText etNumberTwo = (EditText) findViewById(R.id.secondNumber);
        double secondNumber;
        if(TextUtils.isEmpty(etNumberTwo.getText().toString())) {
            etNumberTwo.setError("Please enter a number");
            return;
        } else {
            secondNumber = Double.parseDouble(etNumberTwo.getText().toString());
        }


        TextView finalValue = (TextView) findViewById(R.id.finalValue);

        finalValue.setText(
                firstNumber + " + " + secondNumber + " = " + add(firstNumber, secondNumber)
                        + "\n" + firstNumber + " - " + secondNumber + " = " + subtract(firstNumber, secondNumber)
                        + "\n" + firstNumber + " * " + secondNumber + " = " + multiply(firstNumber, secondNumber)
                        + "\n" + firstNumber + " / " + secondNumber + " = " + divide(firstNumber, secondNumber)
                        + "\n" + firstNumber + " % " + secondNumber + " = " + modulus(firstNumber, secondNumber));
    }

    public double add(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    public double subtract(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    public double multiply(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    public double divide(double numberOne, double numberTwo) {
        if(numberOne == 0 || numberTwo == 0) return -1;
        return numberOne / numberTwo;
    }

    public double modulus(double numberOne, double numberTwo) {
        return numberOne % numberTwo;
    }

    public void firstRandomNumberBtn(View view) {
        EditText firstNumber = (EditText) findViewById(R.id.firstNumber);
        firstNumber.setText(Double.toString(generateRandomNumber()));
    }

    public void secondRandomNumberBtn(View view) {
        EditText secondNumber = (EditText) findViewById(R.id.secondNumber);
        secondNumber.setText(Double.toString(generateRandomNumber()));
    }

    public double generateRandomNumber() {
        int max = 20;
        int min = 0;
        return Math.round((Math.random() * (max - min + 1) + min) * 100.0) / 100.0;
    }
}