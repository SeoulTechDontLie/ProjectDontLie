package com.example.jeongyoonkim.startwithcamera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by JeongyoonKim on 2016-04-04.
 */
public class CameraBrightness extends Activity implements SensorEventListener{

    private SensorManager sensorManager;
    TextView tVMaxValue, tVCurrentLight;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness);
        tVMaxValue = (TextView)findViewById(R.id.tVMaxValue);
        tVCurrentLight = (TextView)findViewById(R.id.tVCurrentLight);
        //create instance of sensor manager and get system service to interact with Sensor
        sensorManager= (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensor= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor == null){
            Toast.makeText(CameraBrightness.this,"No Light Sensor Found! ",Toast.LENGTH_LONG).show();
        }else{ float max =  lightSensor.getMaximumRange();
            //Get Maximum Value From Light sensor
            tVMaxValue.setText("Max Range: " + String.valueOf(max));
            sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the lightSensor
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    // called when sensor value have changed
    @Override
    public void onSensorChanged(SensorEvent event) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        if(event.sensor.getType()==Sensor.TYPE_LIGHT){
            float currentLight = event.values[0];
            if(currentLight<1){tVCurrentLight.setText("Current light: " + "no Light");}
            else if(currentLight<5){tVCurrentLight.setText("Current light is Dim:" + String.valueOf(currentLight));}
            else if(currentLight<10){tVCurrentLight.setText("Current light is Normal:" + String.valueOf(currentLight));}
            else if(currentLight<100){tVCurrentLight.setText("Current light is Bright(Room):" + String.valueOf(currentLight));}
            else tVCurrentLight.setText("Current light is Bright(Sun):" + String.valueOf(currentLight));
        }}
}
