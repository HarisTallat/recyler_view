package com.haristallat2001.recyler_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;

public class update_activity extends AppCompatActivity {
    EditText d_name,d_no,d_address,d_dob,d_number,d_email;
    ImageView call,back,update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activity);
        Intent intent= getIntent();
        String pname=intent.getStringExtra("pname");
        String paddress=intent.getStringExtra("paddress");
        String pemail=intent.getStringExtra("pemail");
        String pdob=intent.getStringExtra("pdob");
        String pno=intent.getStringExtra("pno");
        d_name=findViewById(R.id.d_name);
        d_no=findViewById(R.id.d_no);
        d_email=findViewById(R.id.d_email);
        d_address=findViewById(R.id.d_address);
        call=findViewById(R.id.call);
        back=findViewById(R.id.back);
        update=findViewById(R.id.update);

        d_dob=findViewById(R.id.d_dobb);

        d_name.setText(pname);
        d_no.setText(pno);
          d_email.setText(pemail);
        d_address.setText(paddress);
        d_dob.setText(pdob);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cell= pno.toString().trim();
                Intent intent3= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + cell));
                startActivity(intent3);
                finish();
            }
        });
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intentBack= new Intent(update_activity.this,MainActivity.class);
        startActivity(intentBack);
        finish();
    }
});



    }
}