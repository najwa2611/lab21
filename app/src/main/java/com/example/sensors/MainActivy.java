package com.example.sensors;

import android.hardware.Sensor;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;
import com.example.sensors.fragments.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SensorsListFragment())
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_sensors) {
            openFragment(new SensorsListFragment());
        } else if (id == R.id.nav_temperature) {
            openFragment(SensorGraphFragment.newInstance(Sensor.TYPE_AMBIENT_TEMPERATURE, "Temperature", "FIRST_VALUE"));
        } else if (id == R.id.nav_humidity) {
            openFragment(SensorGraphFragment.newInstance(Sensor.TYPE_RELATIVE_HUMIDITY, "Humidite", "FIRST_VALUE"));
        } else if (id == R.id.nav_proximity) {
            openFragment(SensorGraphFragment.newInstance(Sensor.TYPE_PROXIMITY, "Proximite", "FIRST_VALUE"));
        } else if (id == R.id.nav_magnetic) {
            openFragment(SensorGraphFragment.newInstance(Sensor.TYPE_MAGNETIC_FIELD, "Champ Magnetique", "MAGNITUDE"));
        } else if (id == R.id.nav_accelerometer) {
            openFragment(MotionSensorFragment.newInstance(Sensor.TYPE_ACCELEROMETER, "Accelerometre"));
        } else if (id == R.id.nav_gravity) {
            openFragment(MotionSensorFragment.newInstance(Sensor.TYPE_GRAVITY, "Gravite"));
        } else if (id == R.id.nav_gyroscope) {
            openFragment(MotionSensorFragment.newInstance(Sensor.TYPE_GYROSCOPE, "Gyroscope"));
        } else if (id == R.id.nav_steps) {
            openFragment(new StepCounterFragment());
        } else if (id == R.id.nav_compass) {
            openFragment(new CompassFragment());
        } else if (id == R.id.nav_activity) {
            openFragment(new ActivityRecognitionFragment());
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}