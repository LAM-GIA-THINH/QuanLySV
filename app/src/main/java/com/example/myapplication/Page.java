package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityPageBinding;

public class Page extends AppCompatActivity {



    ActivityPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ListFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
        switch (item.getItemId()){
            case R.id.home:
                replaceFragment(new ListFragment());
                break;
            case R.id.profile:
                replaceFragment(new ProfileFragment());
                break;
            case R.id.setting:
                replaceFragment(new SettingFragment());
                break;



        }



            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}