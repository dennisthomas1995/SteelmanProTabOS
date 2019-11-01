package com.example.steelmanprotabos.home;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steelmanprotabos.R;
import com.example.steelmanprotabos.updatescreen.UpdateScreen;
import com.example.steelmanprotabos.updatescreen.softwareupdate.SoftwareUpdateFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView titleImage,chasisEarImage,trailerTesterImage,videoscopeImage,tireGaugeImage;
    TextView menuText,exitText,updateCounttText,updateText,chasisEarText,trailerTesterText,videoscopeText,tireGaugeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        titleImage=findViewById(R.id.title_image);
        chasisEarImage=findViewById(R.id.chasis_ear_image);
        trailerTesterImage=findViewById(R.id.trailer_tester_image);
        videoscopeImage=findViewById(R.id.videoscope_image);
        tireGaugeImage=findViewById(R.id.tire_guage_image);
        menuText=findViewById(R.id.menu_text);
        exitText=findViewById(R.id.exit_text);
        updateCounttText=findViewById(R.id.update_count_text);
        updateText=findViewById(R.id.update_text);
        chasisEarText=findViewById(R.id.chasis_ear_text);
        trailerTesterText=findViewById(R.id.trailer_tester_text);
        videoscopeText=findViewById(R.id.videoscope_text);
        tireGaugeText=findViewById(R.id.tire_guage_text);
        menuText.setOnClickListener(this);
        exitText.setOnClickListener(this);
        updateText.setOnClickListener(this);
        updateCounttText.setOnClickListener(this);
        trailerTesterText.setOnClickListener(this);
        tireGaugeText.setOnClickListener(this);
        trailerTesterImage.setOnClickListener(this);
        tireGaugeImage.setOnClickListener(this);
        videoscopeText.setOnClickListener(this);
        chasisEarText.setOnClickListener(this);
        videoscopeImage.setOnClickListener(this);
        chasisEarImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.menu_text) {
           // Toast.makeText(getApplicationContext(),"You have clicked menu",Toast.LENGTH_SHORT).show();
            Intent intent;
            intent=new Intent(MainActivity.this, UpdateScreen.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.exit_text){
            finish();
            //Toast.makeText(getApplicationContext(),"You have clicked exit",Toast.LENGTH_SHORT).show();
        }
        if (v.getId()==R.id.update_text||v.getId()==R.id.update_count_text){
            //Toast.makeText(getApplicationContext(),"You have clicked update",Toast.LENGTH_SHORT).show();
            Intent intent;
            intent=new Intent(MainActivity.this, UpdateScreen.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.trailer_tester_text||v.getId()==R.id.trailer_tester_image){
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.jssteelman.bluetoothtrailer");
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(launchIntent);//null pointer check in case package name was not found
            }
        }
        if (v.getId()==R.id.tire_guage_text||v.getId()==R.id.tire_guage_image){
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.reubro.tiregauge.ThreadDepthGauge");
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(launchIntent);//null pointer check in case package name was not found
            }

        }
        if (v.getId()==R.id.videoscope_text||v.getId()==R.id.videoscope_image){
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.steelmanpro.wifivideoscope");
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(launchIntent);//null pointer check in case package name was not found
            }

        }
        if (v.getId()==R.id.chasis_ear_text||v.getId()==R.id.chasis_ear_image){
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.jsproducts.wirelesschasispro");
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(launchIntent);//null pointer check in case package name was not found
            }

        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

    public void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }

}
