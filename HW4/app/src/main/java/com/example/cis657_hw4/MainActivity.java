package com.example.cis657_hw4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText lat1 = (EditText) findViewById(R.id.lat1);
        EditText long1 = (EditText) findViewById(R.id.long1);
        EditText lat2 = (EditText) findViewById(R.id.lat2);
        EditText long2 = (EditText) findViewById(R.id.long2);

        Button CalculateButton = (Button) findViewById(R.id.CalculateButton);
        Button ClearButton = (Button) findViewById(R.id.ClearButton);

        CalculateButton.setOnClickListener(v -> {
            int flag = 0;
            String lat1str, lat2str, long1str, long2str;
            lat1str = lat1.getText().toString();
            lat2str = lat2.getText().toString();
            long1str = long1.getText().toString();
            long2str = long2.getText().toString();

            if ((lat1str.length() == 0) || (lat2str.length() == 0) ||
                    (long1str.length() == 0) || (long2str.length() == 0)) {
                Snackbar.make(CalculateButton, "One or more of the text fields is incomplete",
                        Snackbar.LENGTH_LONG).show();
            }

        });


    }

}
