package com.dilip.accelerometersensordemo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager!=null){

            Sensor acceleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (acceleroSensor!=null){
                sensorManager.registerListener(this, acceleroSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }

        } else {
            Toast.makeText(this, "Sensor service not found in your device", Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event)

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}