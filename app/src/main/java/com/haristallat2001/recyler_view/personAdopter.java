package com.haristallat2001.recyler_view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.haristallat2001.recyler_view.R.drawable.design_ic_visibility;
import static com.haristallat2001.recyler_view.R.drawable.final_pic_haris;
import static com.haristallat2001.recyler_view.R.drawable.haseeb;
import static com.haristallat2001.recyler_view.R.drawable.juni;
import static com.haristallat2001.recyler_view.R.drawable.madni;
import static com.haristallat2001.recyler_view.R.drawable.rashid;
import static com.haristallat2001.recyler_view.R.drawable.salman;
import static com.haristallat2001.recyler_view.R.drawable.talha;
import static com.haristallat2001.recyler_view.R.drawable.umer;

public class  personAdopter extends RecyclerView.Adapter<personAdopter.viewHolder> {
    private ArrayList<person> people;
   // public clicked()
    public interface clicked{
        void clickedItem(int index);
   }
    clicked my_activity;
    public personAdopter(Context context, ArrayList<person> list)

    {
        my_activity= (clicked) context;
        people=list;
    }
    class viewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
ImageView ivpictures,mi;
TextView tvname,tvemail;
ImageView details;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivpictures= itemView.findViewById(R.id.ivpictures);
            tvname=itemView.findViewById(R.id.tvname);
            tvemail=itemView.findViewById(R.id.tvemail);
            mi=itemView.findViewById(R.id.mi);
            details=itemView.findViewById(R.id.details);

         itemView.setOnLongClickListener(this);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

my_activity.clickedItem(people.indexOf((person) itemView.getTag()));
               }
           });
        }


        @Override
        public boolean onLongClick(View v) {
            mi.setVisibility(View.VISIBLE);
            mi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAbsoluteAdapterPosition();
                    people.remove(position);
                    notifyItemRemoved(position);

                }
            });
            return true;
        }


    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.design_file,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvname.setText(people.get(position).getName());
        holder.tvemail.setText(people.get(position).getEmail());



        if(people.get(position).getName().equals("Haris"))
        {
            holder.ivpictures.setImageResource(final_pic_haris);
        }
        else   if(people.get(position).getName().equals("Talha"))
        {
            holder.ivpictures.setImageResource(talha);
        } else   if(people.get(position).getName().equals("Junaid"))
        {
            holder.ivpictures.setImageResource(juni);
        }
        else   if(people.get(position).getName().equals("Haseeb"))
        {
            holder.ivpictures.setImageResource(haseeb);
        }
        else   if(people.get(position).getName().equals("Madni"))
        {
            holder.ivpictures.setImageResource(madni);
        }
        else   if(people.get(position).getName().equals("Umer"))
        {
            holder.ivpictures.setImageResource(umer);
        }
        else   if(people.get(position).getName().equals("Salman"))
        {
            holder.ivpictures.setImageResource(salman);
        }
        else   if(people.get(position).getName().equals("Hussain"))
        {
            holder.ivpictures.setImageResource(rashid);
        }
        else
        {
            holder.ivpictures.setImageResource(R.drawable.person);
        }



    }

    @Override
    public int getItemCount()
    {
        return people.size();
    }
}
