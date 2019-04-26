package com.example.crowdcounter;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputEditText guessField = (TextInputEditText) findViewById(R.id.GuessField);
        final Button submitButton = (Button) findViewById(R.id.button);

        guessField.setHint("Guess Here..");

        guessField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    String guess = guessField.getText().toString();
                    int value = Integer.parseInt(guess);
                    guessField.setHint(guess);

                } catch (Exception e){
                    guessField.setHint("numbers please...");

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String guess = guessField.getText().toString();
                    int value = Integer.parseInt(guess);
                    guessField.setHint(guess);

                } catch (Exception e){
                    guessField.setHint("numbers please...");

                }
            }
        });
        //check guess with server, behave accordingly.


    }
}
