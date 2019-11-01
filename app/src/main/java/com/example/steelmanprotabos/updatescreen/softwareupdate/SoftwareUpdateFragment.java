package com.example.steelmanprotabos.updatescreen.softwareupdate;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.steelmanprotabos.R;


public class SoftwareUpdateFragment extends Fragment implements View.OnClickListener{
    View view;
    TextView softwareUpdateText,currentVersionText,currentVersionNoText,updateAvailableText,availableVersionNoText;
    Button checkUpdateButton,installUpdateButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_software_update, container, false);
        initview();
        return view;
    }

    private void initview() {
        softwareUpdateText=view.findViewById(R.id.software_update_text);
        currentVersionText=view.findViewById(R.id.current_version_txt);
        currentVersionNoText=view.findViewById(R.id.current_version_no_text);
        updateAvailableText=view.findViewById(R.id.update_available_text);
        availableVersionNoText=view.findViewById(R.id.available_version_no_text);
        checkUpdateButton=view.findViewById(R.id.check_update_btn);
        installUpdateButton=view.findViewById(R.id.install_update_btn);
        checkUpdateButton.setOnClickListener(this);
        installUpdateButton.setOnClickListener(this);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.check_update_btn){
            checkUpdateButton.setBackgroundColor(Color.parseColor("#424242"));
            installUpdateButton.setBackgroundColor(Color.parseColor("#EA2527"));
            availableVersionNoText.setText("1.1");
        }else {
            checkUpdateButton.setBackgroundColor(Color.parseColor("#D3D3D3"));
            installUpdateButton.setBackgroundColor(Color.parseColor("#424242"));
            availableVersionNoText.setText("");
        }
    }
}
