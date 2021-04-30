package com.haristallat2001.recyler_view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  personAdopter.clicked
{
RecyclerView recyclerView;
ImageView ivedit_contacts,ivadd_contacts;
 public FloatingActionButton fb;
RecyclerView.LayoutManager layoutManager;
final int KEY=1;
TextView array;
    RecyclerView.Adapter my_adaptor;
    ArrayList<person> conacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.list);
     //fb=findViewById(R.id.fab);
        ivedit_contacts=findViewById(R.id.ivedit_contacts);


        ivedit_contacts.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent1=new Intent(MainActivity.this,Add_activity.class);
startActivityForResult(intent1,KEY);
           }
        });



        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        conacts= new ArrayList<>();
        conacts.add(new person("Haris","Harista201@gmail.com","lahore","20-8-2001","03054425819"));
        conacts.add(new person("Talha","Talha12@gmail.com","Multan","29-9-1999","03057728123"));
        conacts.add(new person("Junaid","Junaid2@gmail.com","Islamabad","2-10-2009","03344728123"));
        conacts.add(new person("Umer","Umer42@gmail.com","Islamabad","21-1-2002","030576528123"));
        conacts.add(new person("Haseeb","Haseeb1@gmail.com","Karachi","9-7-1997","030577928123"));
        conacts.add(new person("Hussain","Hussain005@gmail.com","lahore","20-8-2005","03154425819"));
        conacts.add(new person("Madni","Madni34@gmail.com","Multan","29-9-1991","03037728123"));
        conacts.add(new person("Salman","Salman1@gmail.com","Karachi","01-5-1998","0305772814553"));

        my_adaptor= new personAdopter(this,conacts);
        recyclerView.setAdapter(my_adaptor);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==KEY)
        {
if(resultCode== RESULT_OK){
    //Toast.makeText(this,"ADDED",Toast.LENGTH_LONG).show();
    String nameb=data.getStringExtra("namei");
    String addb=data.getStringExtra("addressi");
    String emailb=data.getStringExtra("emaili");
    String dobb=data.getStringExtra("dobii");
    String nob=data.getStringExtra("noi");
   conacts.add(new person(nameb,emailb,addb,dobb,nob));
  my_adaptor.notifyDataSetChanged();
}
      else if(requestCode== RESULT_CANCELED)
    {
        Toast.makeText(this,"Data no fided",Toast.LENGTH_LONG).show();
    }

}
        }
    @Override
    public void clickedItem(int index) {
        Intent intent3= new Intent(MainActivity.this,update_activity.class);
        intent3.putExtra("pname",conacts.get(index).getName());
        intent3.putExtra("pemail",conacts.get(index).getEmail());
        intent3.putExtra("paddress",conacts.get(index).getAddress());
        intent3.putExtra("pdob",conacts.get(index).getDOB());
        intent3.putExtra("pno",conacts.get(index).getNumber());
        startActivity(intent3);




    }
}
