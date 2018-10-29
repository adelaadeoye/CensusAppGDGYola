package com.adeoyeadela.censusappgdgyola;

import android.support.annotation.NonNull;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
     ImageViewCompat takePic;
     Button uploadBtn, saveBtn;
     EditText fullnameEdx, dobEdx,lgaEdx,homeEdx,tribeEdx;

     private FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseFirestore = FirebaseFirestore.getInstance();

        //Reference The Layouts used ***Button***
        uploadBtn= findViewById(R.id.uploadPicture);
        saveBtn= findViewById(R.id.saveData);

        //Reference the Layouts used ***TextEdit***

        fullnameEdx= findViewById(R.id.name);
        dobEdx= findViewById(R.id.dob);
        lgaEdx=findViewById(R.id.lga);
        homeEdx=findViewById(R.id.address);
        tribeEdx=findViewById(R.id.tribe);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fullnameEdx.getText().toString();
                String dob = dobEdx.getText().toString();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(dob)) {

                    Toast.makeText(MainActivity.this, "Please check the fields", Toast.LENGTH_LONG).show();
                }

                else {

                    Map<Object, String> pushData = new HashMap<>();

                    pushData.put("FullName", name);
                    pushData.put("DateOfBirth", dob);

                    firebaseFirestore.collection("CensusData")
                            .add(pushData)
                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentReference> task) {

                                    if (task.isSuccessful()) {

                                        Toast.makeText(MainActivity.this, "Pushed to DB", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });




    }
}
