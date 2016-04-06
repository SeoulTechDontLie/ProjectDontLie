package com.example.jeongyoonkim.startwithcamera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button1;
    Button surfaceviewbutton;
    Button brightness;
    Button trylight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        surfaceviewbutton = (Button) findViewById(R.id.surfaceviewbutton);
        surfaceviewbutton.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     Intent intent2 = new Intent(MainActivity.this, CameraSurfaceview.class);
                                                     startActivity(intent2);
                                                 }

                                             }

        );

        brightness = (Button) findViewById(R.id.brightness);
        brightness.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     Intent intent3 = new Intent(MainActivity.this, CameraBrightness.class);
                                                     startActivity(intent3);
                                                 }

                                             }

        );

        trylight = (Button) findViewById(R.id.trylight);
        trylight.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent intent4 = new Intent(MainActivity.this, TryLightSensor.class);
                                              startActivity(intent4);
                                          }

                                      }

        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClick02(View v)
    {

        Intent intent2 = new Intent(MainActivity.this, CameraSurfaceview.class);
        startActivity(intent2);
    }

    public void onClick03(View v)
    {

        Intent intent3 = new Intent(MainActivity.this, CameraBrightness.class);
        startActivity(intent3);
    }

    public void onClick_light(View v)
    {

        Intent intent4 = new Intent(MainActivity.this, TryLightSensor.class);
        startActivity(intent4);
    }


}

