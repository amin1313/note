package com.example.amin.note;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.SimpleItemViewHolder> {
    private List<Note> notes;

    //constructor
    private Context context;

    public NoteAdapter(Context context, List<Note> notes1) {
        this.notes = notes1;
        this.context = context;
    }

    @NonNull
    @Override
    public SimpleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_notes, parent, false);

        SimpleItemViewHolder simpleItemViewHolder = new SimpleItemViewHolder(view);
        return simpleItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SimpleItemViewHolder holder, final int position) {

        holder.bindnotes(notes.get(position));
        holder.btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.remove(position);
                holder.ItemChange(notes);
            }
        });


    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    //**********************************************************************************************
    public void add(Note e) {
        notes.add(e);
        notifyItemInserted(notes.size());
        notifyDataSetChanged();
    }

    //**********************************************************************************************
    //view_holder
    public class SimpleItemViewHolder extends RecyclerView.ViewHolder {
        private TextView note;
        private Button btn_del;

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            btn_del = itemView.findViewById(R.id.btn_del);
            note = itemView.findViewById(R.id.txt_note);

        }

        public void bindnotes(Note note1) {
            note.setText(note1.getNote());
        }

        public void remove(int i) {
            if (notes.size() - 1 >= 0) {
                notes.remove(i);
                notifyItemRemoved(i);
            }
        }


        public void ItemChange(List<Note> note_ch) {
            notes = note_ch;
            notifyDataSetChanged();
        }


    }


}
