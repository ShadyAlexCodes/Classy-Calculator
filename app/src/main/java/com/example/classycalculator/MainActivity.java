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
        // Grab the EditText value
        EditText etNumberOne = (EditText) findViewById(R.id.firstNumber);
        double firstNumber;

        // Check if the text box is empty
        if (TextUtils.isEmpty(etNumberOne.getText().toString())) {
            // Define the error
            etNumberOne.setError("Please enter a number");
            return;
        } else {
            // Otherwise grab the number and parse it into a double
            firstNumber = Double.parseDouble(etNumberOne.getText().toString());
            // Remove the error message
            etNumberOne.setError(null);
        }


        // Grab the EditText value
        EditText etNumberTwo = (EditText) findViewById(R.id.secondNumber);
        double secondNumber;

        // Check if the text input box is empty
        if (TextUtils.isEmpty(etNumberTwo.getText().toString())) {
            // Define the error
            etNumberTwo.setError("Please enter a number");
            return;
        } else {
            // Grab the number and parse it as a double
            secondNumber = Double.parseDouble(etNumberTwo.getText().toString());
            // Remove the error message
            etNumberTwo.setError(null);
        }

        // Grab the final value text view
        TextView finalValue = (TextView) findViewById(R.id.finalValue);

        // Output the text input based on the functions defined below
        finalValue.setText(
                firstNumber + " + " + secondNumber + " = " + add(firstNumber, secondNumber)
                        + "\n" + firstNumber + " - " + secondNumber + " = " + subtract(firstNumber, secondNumber)
                        + "\n" + firstNumber + " * " + secondNumber + " = " + multiply(firstNumber, secondNumber)
                        + "\n" + firstNumber + " / " + secondNumber + " = " + divide(firstNumber, secondNumber)
                        + "\n" + firstNumber + " % " + secondNumber + " = " + modulus(firstNumber, secondNumber));
    }

    // Definition of the addition function
    public double add(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    // Definition of the subtraction function
    public double subtract(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    // Definition of the multiplication function
    public double multiply(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    // Definition of the divide function.
    public double divide(double numberOne, double numberTwo) {
        // Check if either number is equal to zero
        if (numberOne == 0 || numberTwo == 0) return -1;
        return numberOne / numberTwo;
    }

    // Definition of the modulus function
    public double modulus(double numberOne, double numberTwo) {
        return numberOne % numberTwo;
    }

    // Create a button for the first random number generation
    public void firstRandomNumberBtn(View view) {
        EditText firstNumber = (EditText) findViewById(R.id.firstNumber);
        // Convert the random number to a string through the double.
        firstNumber.setText(Double.toString(generateRandomNumber()));
    }

    // Create a second button for the second random number generation.
    public void secondRandomNumberBtn(View view) {
        EditText secondNumber = (EditText) findViewById(R.id.secondNumber);
        // Convert the random number to a string through the double.
        secondNumber.setText(Double.toString(generateRandomNumber()));
    }

    // Generate a random number
    public double generateRandomNumber() {
        int max = 20;
        int min = 0;
        // Generating a random number in the exclusivity range of 0 and 20. Multiplying and diving by 100 to allow for decimal point implementation.
        return Math.round((Math.random() * (max - min + 1) + min) * 100.0) / 100.0;
    }
}