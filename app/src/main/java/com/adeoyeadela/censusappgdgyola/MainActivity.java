package com.adeoyeadela.censusappgdgyola;

import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     ImageViewCompat takePic;
     Button uploadBtn, saveBtn;
     EditText fullnameEdx, dobEdx,lgaEdx,homeEdx,tribeEdx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference The Layouts used ***Button***
        uploadBtn= findViewById(R.id.uploadPicture);
        saveBtn= findViewById(R.id.saveData);

        //Reference the Layouts used ***TextEdit***

        fullnameEdx= findViewById(R.id.name);
        dobEdx= findViewById(R.id.dob);
        lgaEdx=findViewById(R.id.lga);
        homeEdx=findViewById(R.id.address);
        tribeEdx=findViewById(R.id.tribe);




    }
}
