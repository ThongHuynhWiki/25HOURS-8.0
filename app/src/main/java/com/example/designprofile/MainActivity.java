package com.example.designprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.designprofile.profile.menuprofile.account.AccountActivity;
import com.example.designprofile.profile.menuprofile.MenuProfileFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.image26).setOnClickListener(this);
        findViewById(R.id.image22).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.image26:
                intent = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(intent);
                break;

            case R.id.image22:

                openMenuAccountProfile();
                break;
        }
    }

    private void openMenuAccountProfile() {
        MenuProfileFragment menuProfileFragment = new MenuProfileFragment();
        menuProfileFragment.show(getSupportFragmentManager(), menuProfileFragment.getTag());

    }

}