package com.example.callingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText numTxt;
    String sNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button)findViewById(R.id.idbtnCall);
        numTxt= (EditText)findViewById(R.id.idNumtxt);
    }

    public void onClick(View v){
        Intent i = new Intent(Intent.ACTION_CALL);
        sNum= numTxt.getText().toString();
        if(TextUtils.isEmpty(sNum)) {
            numTxt.setError("This field cannot be left empty!");
            startActivity(new Intent(this,MainActivity.class));
        }
        else {
            i.setData(Uri.parse("tel:"+sNum));
        }
        if(ActivityCompat.checkSelfPermission(this , Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this ,"Please grant the permission to call",Toast.LENGTH_SHORT).show();
            requestPermission();
        }
        else{
            startActivity(i);
        }
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
