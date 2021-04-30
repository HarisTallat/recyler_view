package com.haristallat2001.recyler_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Add_activity extends AppCompatActivity {
EditText etname,etemail,etdob,etaddress,no;
ImageView ivback;
TextView etview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);
        ivback=findViewById(R.id.ivback);
        etname=findViewById(R.id.etname);
        etemail=findViewById(R.id.etemail);
        etview=findViewById(R.id.etview);
        etdob=findViewById(R.id.etdob);
        no=findViewById(R.id.no);
        etaddress=findViewById(R.id.etaddress);
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name,email,address,dob,no1;
                name=etname.getText().toString().trim();
                address=etaddress.getText().toString().trim();
                email=etemail.getText().toString().trim();
                dob=etdob.getText().toString().trim();
               no1=no.getText().toString().trim();


                Intent intent=new Intent();
                intent.putExtra("namei",name);
                intent.putExtra("addressi",address);
                intent.putExtra("emaili",email);
                intent.putExtra("dobi",dob);
                intent.putExtra("noi",no1);
                setResult(RESULT_OK,intent);


              String file="Contact_Details.txt";

             FileOutputStream f = null;
               String data = "\n" + name + "\n" + address + "\n" + email + "\n" + dob   + "\n";
              try {
                  f= openFileOutput(file, Context.MODE_APPEND);
                 try {
                      f.write(data.getBytes());
                  } catch (IOException e) {
                     e.printStackTrace();
                 }
              } catch (FileNotFoundException e) {
                   e.printStackTrace();
              }

                finish();

      }
        });






    }
}