package com.example.proyecto;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.navegacion);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Fragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){

                        case R.id.nave_registros:
                            selectedFragment = new Fragment_registros();
                            break;
                        case R.id.nave_inicio:
                            selectedFragment = new Fragment_inicio();
                            break;
                        case R.id.nave_formulario:
                            selectedFragment = new Fragment_formulario();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment,
                            selectedFragment).commit();

                    return true;
                }
            };

}
