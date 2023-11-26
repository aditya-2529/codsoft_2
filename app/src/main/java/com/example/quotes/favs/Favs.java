package com.example.quotes.favs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.quotes.R;
import com.example.quotes.adapter.favsAdapter;
import com.example.quotes.utils.FavsData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Favs extends AppCompatActivity {
    static String TAG = "FIREBASE";
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favs);
        List<FavsData> l = new ArrayList<>();
        l=getData();
        favsAdapter favsAdapter = new favsAdapter(l);
        rv = findViewById(R.id.favto);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(favsAdapter);

    }
    static String str;
    static List<FavsData> getData(){
        List<FavsData> l =new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("quotes").document("allquotes");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        str = (String) document.get(String.valueOf(1));
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        l.add(new FavsData(str));
        return l;
    }
}