package com.shw.uiforregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    private EditText editName,editEmail,editReenter,editPassword;
    private Button btnRegister,pick_image;
    private RadioGroup rdGroup;
    private Spinner CountrySpinner;
    private CheckBox agreeBox;
    private TextView warnName,warnEmail,warnPassword,warnReenter;
    private ConstraintLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_view();

        pick_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Yet to talk about",Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init_register();
            }
        });
    }
    private void init_register(){
        Log.d(TAG,"init_register: Start");
        if(validate_data()){
            if(agreeBox.isChecked()){
                ShowSnackBar();
            }else{
                Toast.makeText(MainActivity.this,"You must agree for the license agreement.",Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void ShowSnackBar(){
        Log.d(TAG,"ShowSnackBar: Start");
        warnReenter.setVisibility(View.GONE);
        warnEmail.setVisibility(View.GONE);
        warnPassword.setVisibility(View.GONE);
        warnName.setVisibility(View.GONE);

        Snackbar.make(parent,"User Register Successfully!",Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss",new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                    }

                }).show();
    }
    private boolean validate_data(){
        Log.d(TAG,"validate data: Start");
        if(editName.getText().toString().equals("")){
            warnName.setVisibility(View.VISIBLE);
            warnName.setText("You forget to fill your name.");
            return false;
        }
        if(editEmail.getText().toString().equals("")){
            warnEmail.setVisibility(View.VISIBLE);
            warnEmail.setText("You forget to fill your EMAIL.");
            return false;
        }
        if(editPassword.getText().toString().equals("")){
            warnPassword.setVisibility(View.VISIBLE);
            warnPassword.setText("You forget to fill your Password.");
            return false;
        }
        if(editName.getText().toString().equals("")){
            warnReenter.setVisibility(View.VISIBLE);
            warnReenter.setText("You should check the password again.");
            return false;
        }

        return true;
    }
    private void init_view(){
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editReenter = findViewById(R.id.editReenter);
        editPassword = findViewById(R.id.editPassword);

        btnRegister = findViewById(R.id.btnRegister);
        pick_image = findViewById(R.id.pick_image);

        rdGroup = findViewById(R.id.rdGroup);

        CountrySpinner = findViewById(R.id.CountrySpinner);

        agreeBox =findViewById(R.id.agreeBox);

        warnEmail = findViewById(R.id.warnEmail);
        warnName = findViewById(R.id.warnName);
        warnPassword = findViewById(R.id.warnPassword);
        warnReenter = findViewById(R.id.warnReenter);

        parent = findViewById(R.id.parents);
    }
}