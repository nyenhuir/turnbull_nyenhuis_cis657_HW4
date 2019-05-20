package com.example.cis657_hw4;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    public static final int DIST_UNIT = 1;
    Location loc1 = new Location("GPS");
    Location loc2 = new Location("GPS");

    EditText lat1;
    EditText long1;
    EditText lat2;
    EditText long2;

    String lat1str, lat2str, long1str, long2str;

    TextView distanceresult;
    TextView bearingresult;

    Double distance;
    Double bearing;

    String DistUnit = "kilometers";
    String BearUnit = "degrees";

    Button CalculateButton;
    Button ClearButton;
    Button tempbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main_coordinatorlayout);


        lat1 = (EditText) findViewById(R.id.lat1);
        long1 = (EditText) findViewById(R.id.long1);
        lat2 = (EditText) findViewById(R.id.lat2);
        long2 = (EditText) findViewById(R.id.long2);
        distanceresult = (TextView) findViewById(R.id.distanceresult);
        bearingresult = (TextView) findViewById(R.id.bearingresult);

        CalculateButton = (Button) findViewById(R.id.CalculateButton);
        ClearButton = (Button) findViewById(R.id.ClearButton);

        CalculateButton.setOnClickListener(v -> {

            lat1str = lat1.getText().toString();
            lat2str = lat2.getText().toString();
            long1str = long1.getText().toString();
            long2str = long2.getText().toString();

            if ((lat1str.length() == 0) || (lat2str.length() == 0) ||
                    (long1str.length() == 0) || (long2str.length() == 0)) {
                Snackbar.make(CalculateButton, "One or more of the text fields is incomplete",
                        Snackbar.LENGTH_LONG).show();

            }

            else calcDistance();

        });

        ClearButton.setOnClickListener(y -> {
            lat1.setText("");
            lat2.setText("");
            long1.setText("");
            long2.setText("");
            distanceresult.setText("");
            bearingresult.setText("");
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }


    void calcDistance(){
        loc1.setLatitude(Double.parseDouble(lat1str));
        loc1.setLongitude(Double.parseDouble(long1str));
        loc2.setLatitude(Double.parseDouble(lat2str));
        loc2.setLongitude(Double.parseDouble(long2str));

        BigDecimal BDdist = new BigDecimal(Double.toString((loc1.distanceTo(loc2)/1000)));
        BDdist = BDdist.setScale(2, RoundingMode.HALF_UP);
        distance = BDdist.doubleValue();

        BigDecimal BDbear = new BigDecimal(Double.toString(loc1.bearingTo(loc2)));
        BDbear = BDbear.setScale(2, RoundingMode.HALF_UP);
        bearing = BDbear.doubleValue();


       distanceresult.setText(""+distance+" "+DistUnit);
       bearingresult.setText(""+bearing+" "+BearUnit);
    }

}
