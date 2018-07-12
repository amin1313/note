package com.example.amin.note;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1001;
    NoteAdapter adapter;
    List<Note> noteList_main = new ArrayList<>();
    RecyclerView recyclerView;
    Button btn_new_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_Main);
        btn_new_note = findViewById(R.id.btn_new);

        noteList_main = getdata();
        adapter = new NoteAdapter(MainActivity.this, noteList_main);
        //  NoteAdapter adapter=new NoteAdapter(MainActivity.this,noteList_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        btn_new_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Note_update.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && data != null) {
            String Note_Note_update = data.getStringExtra(Note_update.RESULT_KEY);
            Toast.makeText(MainActivity.this, Note_Note_update, Toast.LENGTH_LONG).show();

            List<Note> noteList = new ArrayList<>();
            Note note_new = new Note();
            note_new.setNote(Note_Note_update);
            noteList.add(note_new);
            adapter.add(note_new);
        }


    }


    private List<Note> getdata() {
        List<Note> noteList = new ArrayList<>();
        Note note_new = new Note();
        for (int i = 0; i < 4; i++) {
            note_new.setNote("example");
            noteList.add(note_new);


        }


        return noteList;
    }


}
