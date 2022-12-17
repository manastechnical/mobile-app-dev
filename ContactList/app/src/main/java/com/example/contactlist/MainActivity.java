package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS=100;
    Cursor c;
    ArrayList<String> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.idList);

        int permissionCheck= ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS);
        if(permissionCheck== PackageManager.PERMISSION_GRANTED){
            showContacts();
        }
        else{
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    PERMISSIONS_REQUEST_READ_CONTACTS);

        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.
                simple_list_item_1,contacts);
        listView.setAdapter(adapter);
    }
    public void onRequestPermissionResult(int requestCode, String[] permissions,int[] grantResults){
        if (requestCode==PERMISSIONS_REQUEST_READ_CONTACTS){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                showContacts();
            }
            else {
                Toast.makeText(this,"Until you grant the permission , we cannotdisplay the names",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void showContacts(){
        c=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                null,null,ContactsContract.Contacts.DISPLAY_NAME+ " ASC ");
        contacts=new ArrayList<String>();
        while(c.moveToNext()){
            String contactName= c.getString(c.getColumnIndexOrThrow(ContactsContract.
                    CommonDataKinds.Phone.DISPLAY_NAME));
            String phNumber=c.getString(c.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add("Name:"+contactName+"\n"+"PhoneNo:"+ phNumber);
        }
        c.close();
    }
}