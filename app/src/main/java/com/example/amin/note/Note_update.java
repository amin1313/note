package com.example.amin.note;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Note_update extends AppCompatActivity {

    public static final String RESULT_KEY = "result";
    Button btn_Note_update_save_new_note;
    EditText et_Note_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_update);

        btn_Note_update_save_new_note = findViewById(R.id.btn_update_note_update);
        et_Note_update = findViewById(R.id.et_set_note);

        btn_Note_update_save_new_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(RESULT_KEY, et_Note_update.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
