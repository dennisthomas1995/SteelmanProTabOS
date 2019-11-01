package com.example.steelmanprotabos.updatescreen;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steelmanprotabos.R;
import com.example.steelmanprotabos.home.MainActivity;
import com.example.steelmanprotabos.updatescreen.license.ViewLicenseFragment;
import com.example.steelmanprotabos.updatescreen.softwareupdate.SoftwareUpdateFragment;
import com.example.steelmanprotabos.updatescreen.userdetail.UserDetailFragment;

import java.util.List;

public class UpdateScreen extends AppCompatActivity implements View.OnClickListener {

    boolean doubleBackToExitPressedOnce = false;
    TextView logoText,softwareUpdateText,userDetailtext,viewLicenseText,serialNoText;
    LinearLayout updateLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_screen);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flContent, new SoftwareUpdateFragment());
        ft.commit();
        initview();
    }

    private void initview() {
        logoText=findViewById(R.id.logo_text);
        softwareUpdateText=findViewById(R.id.software_update_text);
        userDetailtext=findViewById(R.id.user_detail_text);
        viewLicenseText=findViewById(R.id.view_license_text);
        serialNoText=findViewById(R.id.serial_no_text);
        updateLinearLayout=findViewById(R.id.updation_linear_layout);
        softwareUpdateText.setOnClickListener(this);
        userDetailtext.setOnClickListener(this);
        viewLicenseText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.software_update_text){

          replaceFragment(new SoftwareUpdateFragment());

        }
        if (v.getId()==R.id.user_detail_text){

            replaceFragment(new UserDetailFragment());

        }
        if (v.getId()==R.id.view_license_text){

            replaceFragment(new ViewLicenseFragment());

        }
    }
    @Override
    public void onBackPressed() {
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.flContent);

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {

            if (getVisibleFragment() instanceof SoftwareUpdateFragment){
                for(int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); ++i) {
                    getSupportFragmentManager().popBackStack();
                    System.out.println("inside if if");
                }
                Toast.makeText(getApplicationContext(),"Please click BACK again to exit ",Toast.LENGTH_SHORT).show();
                System.out.println("inside if");
            }

            else{
                System.out.println("inside if else");
                getSupportFragmentManager().popBackStack();
            }

        }
//        else if (!doubleBackToExitPressedOnce) {
//            this.doubleBackToExitPressedOnce = true;
//            Toast.makeText(this,"Please click BACK again to exit.", Toast.LENGTH_SHORT).show();
//
//            new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//                    doubleBackToExitPressedOnce = false;
//                }
//            }, 2000);
//        }

        else{
            System.out.println("inside else");
            super.onBackPressed();

        }

    }
    private Fragment getVisibleFragment() {
        FragmentManager fragmentManager = UpdateScreen.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isVisible())
                return fragment;
        }
        return null;
    }
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flContent, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
