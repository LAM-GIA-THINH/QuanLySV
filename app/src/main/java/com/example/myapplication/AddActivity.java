package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    EditText name,email,turl;
    Button btnAdd,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = (EditText) findViewById(R.id.txtName);
        email = (EditText) findViewById(R.id.txtDetail);
        turl = (EditText) findViewById(R.id.txtImageUrl);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void insertData()
        {
        Map<String,Object> map = new HashMap<>();
        map.put("NameSV",name.getText().toString());
        map.put("EmailSV",email.getText().toString());
        map.put("turl",turl.getText().toString());
            FirebaseDatabase.getInstance().getReference().child("Students").push()
                    .setValue(map)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(AddActivity.this,"Thêm dữ liệu thành công.",Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddActivity.this,"Thêm dữ liệu thất bại.",Toast.LENGTH_SHORT).show();
                        }
                    });

    };
    private void clearAll(){
        name.setText("");
        email.setText("");
        turl.setText("");
    }
}