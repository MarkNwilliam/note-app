package com.example.engineeringtutorseries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.engineeringtutorseries.Interface.TitleClickListener;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {
    private Context nContex;
    private ArrayList<String> TitleList;
    private TitleClickListener clickListener;




    public QuestionAdapter(Context nContex, ArrayList<String> titleList, TitleClickListener clickListener) {
        this.nContex = nContex;
        TitleList = titleList;
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public QuestionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup myViewGroup, int i) {
        View view = LayoutInflater.from(nContex).inflate(R.layout.question_view,myViewGroup,false);



        final QuestionAdapter.MyViewHolder myViewHolder = new QuestionAdapter.MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clickListener.onItemClick(v,myViewHolder.getAdapterPosition());
            }

        } );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.MyViewHolder  myViewHolder, int i) {

        myViewHolder.title.setText(TitleList.get(i).replace("_"," "));

    }

    @Override
    public int getItemCount() {
        return TitleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.questiontitle);
        }
    }
}
