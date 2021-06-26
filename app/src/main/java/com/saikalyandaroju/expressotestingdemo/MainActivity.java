package com.saikalyandaroju.expressotestingdemo;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.afollestad.materialdialogs.DialogBehavior;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.MaterialDialogKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.dialog.MaterialDialogs;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {



    TextView textView;
    Button openDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.text_name);
        openDialog=findViewById(R.id.button_launch_dialog);
        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMyDialog();
            }
        });
    }

    private void showMyDialog() {

        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dilaog);
        EditText name=dialog.findViewById(R.id.editTextTextPersonName);
        Button button=dialog.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty()){
                    return;
                }
                setView(name.getText().toString());

                dialog.dismiss();
                showToast(name.getText().toString());
            }
        });
        dialog.show();
    }

    private void showToast(String toString) {
        Toast.makeText(this, "Toast Displayed "+toString,Toast.LENGTH_SHORT).show();
    }


    private void setView(String toString) {
        textView.setText(toString);
    }


}