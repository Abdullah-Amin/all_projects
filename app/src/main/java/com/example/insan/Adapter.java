package com.example.insan;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.DataViewHolder> {

    Context context;
    ArrayList<Data> dataArrayList;

     public Adapter(Context context, ArrayList<Data> dataArrayList){
         this.context = context;
         this.dataArrayList = dataArrayList;
     }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.develop_item, parent, false);
         DataViewHolder viewHolder = new DataViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
         Data data = dataArrayList.get(position);

        Uri imgUri = Uri.fromFile(new File(String.valueOf(R.drawable.draw)));

        holder.drawing_imageView.setImageURI(imgUri);
        holder.drawing_button.setText(data.getBtn_text());
        holder.drawing_text.setText(data.getText());
        holder.mid_drawing_text.setText(data.getMid_text());

//        holder.icdl_button.setText(data.text);
//        holder.icdl_text.setText(data.text);
//        holder.mid_icdl_text.setText(data.text);
//
//        holder.handmade_button.setText(data.text);
//        holder.handmade_text.setText(data.text);
//        holder.mid_handmade_text.setText(data.text);
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        ImageView drawing_imageView/*, icdl_imageView, handmade_imageView*/;
        Button drawing_button/*, icdl_button, handmade_button*/;
        TextView drawing_text, mid_drawing_text/*,icdl_text, mid_icdl_text,handmade_text, mid_handmade_text*/;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            drawing_imageView = itemView.findViewById(R.id.drawing);
            drawing_button = itemView.findViewById(R.id.drawing_btn);
            drawing_text = itemView.findViewById(R.id.drawing_textView);
            mid_drawing_text = itemView.findViewById(R.id.drawing_middle_textView);

//           // icdl_imageView = itemView.findViewById(R.id.icdl);
//            icdl_button = itemView.findViewById(R.id.icdl_btn);
//            icdl_text = itemView.findViewById(R.id.icdl_textView);
//            mid_icdl_text = itemView.findViewById(R.id.icdl_middle_textView);

//           // handmade_imageView = itemView.findViewById(R.id.handmade);
//            handmade_button = itemView.findViewById(R.id.handmade_btn);
//            handmade_text = itemView.findViewById(R.id.handmade_textView);
//            mid_handmade_text = itemView.findViewById(R.id.handmade_middle_textView);

        }
    }
}
