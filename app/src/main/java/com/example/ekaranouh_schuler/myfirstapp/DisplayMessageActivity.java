package com.example.ekaranouh_schuler.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.ekaranouh_schuler.myfirstapp.R.id.textView2;

public class DisplayMessageActivity extends AppCompatActivity {

    public String primesToNiceString(List<Long> primes) {
        String stringOfPrimes = "";
        for(Long element : primes) {
            if (element == primes.get(primes.size() - 1)) {
                stringOfPrimes += element;
            } else {
                stringOfPrimes += element + ", ";
            }
        }
        return stringOfPrimes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        long upperLimit = Long.parseLong(message);

        List<Long> notPrime = new ArrayList<>();
        List<Long> primes = new ArrayList<>();

        for(long prime = 2; prime < upperLimit; prime++) {
            if(!notPrime.contains(prime)) {
                primes.add(prime);
                for(int multiplier = 2; (prime * multiplier) < upperLimit; multiplier++) {
                    notPrime.add(prime * multiplier);
                }
            }
        }

        String results = "The prime numbers between 1 and " + upperLimit + " are: 1, " + primesToNiceString(primes);

        TextView textView = findViewById(textView2);
        textView.setText(results);
    }
}
