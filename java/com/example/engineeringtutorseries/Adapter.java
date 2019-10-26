package com.example.engineeringtutorseries;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.engineeringtutorseries.Callback.NoteEventListener;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
     List<Note> notes;
   // private NoteEventListener listener;


    Adapter(Context context, List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view =inflater.inflate(R.layout.custom_list_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int i) {

        String title = notes.get(i).getTitle();
        String date = notes.get(i).getDate();
        String time = notes.get(i).getTime();
        String category = notes.get(i).getCategory();
        long id = notes.get(i).getId();
        Log.d("ID", "Getting onBindViewHolder: ID" + id);
        Log.d("Title", "onBindViewHolder: Title"+ title);
        viewHolder.nTitle.setText(title);
        viewHolder.nDate.setText(date);
        viewHolder.nTime.setText(time);
        viewHolder.nCategory.setText(category);
        viewHolder.nID.setText(String.valueOf(notes.get(i).getId()));

    }

    @Override
    public int getItemCount() {

        return notes.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private NoteEventListener listener;
        TextView nID,nTitle,nDate,nTime,nCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nID = itemView.findViewById(R.id.nID);
            nTitle = itemView.findViewById(R.id.nTitle);
            nDate = itemView.findViewById(R.id.nDate);
            nTime = itemView.findViewById(R.id.nTime);
            nCategory = itemView.findViewById(R.id.nCategory);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(view.getContext(), Edit.class);
                    i.putExtra("ID", notes.get(getAdapterPosition()).getId());
                    view.getContext().startActivity(i);
                }
            });

        }

    }

}
