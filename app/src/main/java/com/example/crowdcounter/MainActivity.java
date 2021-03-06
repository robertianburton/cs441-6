package com.example.crowdcounter;

import android.app.DownloadManager;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputEditText guessField = (TextInputEditText) findViewById(R.id.GuessField);
        final TextInputEditText nameField = (TextInputEditText) findViewById(R.id.NameField);
        final Button submitButton = (Button) findViewById(R.id.button);
        final TextView mainText = (TextView) findViewById(R.id.main);

        nameField.setHint("Name Here..");
        guessField.setHint("Guess Here..");

        final RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url ="http://cs.binghamton.edu/~rburton2/gettext.php";

        // Request a string response from the provided URL.
        /*
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.print(response);
                        int maxL = 500;
                        if(response.length()<500) {
                            maxL = response.length();
                        }

                        String result = response.substring(0,maxL);
                        if(){

                        }
                        mainText.setText();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mainText.setText("That didn't work!");
                System.out.println(error);
            }
        });

        // Add the request to the RequestQueue.
        //queue.add(stringRequest);
        */

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //setContentView(R.layout.answer);
                    final String guess = guessField.getText().toString();
                    int value = Integer.parseInt(guess);

                    String name = nameField.getText().toString().replaceAll(" ", "_");

                    if(name.equals("")){
                        name = "Anonymous";
                    }

                    String url ="http://cs.binghamton.edu/~rburton2/sendguess.php?guess=" + guess + "&name=" + name;

                    System.out.println(url);
                    //mainText.setText(url);

                    // Request a string response from the provided URL.
                    final StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Display the first 500 characters of the response string.
                                    System.out.print(response);
                                    int maxL = 500;
                                    if(response.length()<500) {
                                        maxL = response.length();
                                    }

                                    String result = response.substring(0,1);
                                    System.out.println(result);
                                    if(result.equals("0")){
                                        mainText.setText("Sorry, but " + guess + " is incorrect!");

                                    } else {
                                        setContentView(R.layout.answer);
                                    }
                                    //mainText.setText(response.substring(0,maxL));
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            mainText.setText("That didn't work!");
                            System.out.println(error);
                        }
                    });


                    queue.add(getRequest);
                    guessField.setHint(guess);

                } catch (Exception e){
                    guessField.setHint("numbers please...");

                }
            }
        });
        //check guess with server, behave accordingly.


    }
}
