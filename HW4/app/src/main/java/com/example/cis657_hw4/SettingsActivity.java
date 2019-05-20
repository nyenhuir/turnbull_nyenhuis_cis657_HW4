package com.example.cis657_hw4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    String distUnit = "kilometers";
    String bearUnit = "degrees";
    String lat1,lat2,long1,long2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("distunits",distUnit);
                intent.putExtra("bearunits",bearUnit);
                intent.putExtra("lat1",lat1);
                intent.putExtra("lat2",lat2);
                intent.putExtra("long1",long1);
                intent.putExtra("long2",long2);
                setResult(MainActivity.DIST_UNIT,intent);
                finish();
            }
        });

        Intent receiveintent = getIntent();
        if(receiveintent.hasExtra("currdistunit")&&
                receiveintent.hasExtra("currbearunit")){
            distUnit = receiveintent.getStringExtra("currdistunit");
            bearUnit = receiveintent.getStringExtra("currbearunit");
            lat1 = receiveintent.getStringExtra("lat1");
            lat2 = receiveintent.getStringExtra("lat2");
            long1 = receiveintent.getStringExtra("long1");
            long2 = receiveintent.getStringExtra("long2");

//            TextView distanceunitid = (TextView) findViewById(R.id.distanceunitid);
//            distanceunitid.setText("WORKED"+distUnit);

        }

        Spinner distunitspinner = (Spinner) findViewById(R.id.distancespinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.distUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distunitspinner.setAdapter(adapter);
        distunitspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?>adapterView, View view, int i, long l) {
                distUnit = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });

        Spinner bearunitspinner = (Spinner) findViewById(R.id.bearingspinner);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.bearUnits, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bearunitspinner.setAdapter(adapter1);
        bearunitspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?>adapterView, View view, int i, long l) {
                bearUnit = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
