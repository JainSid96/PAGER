package com.example.msjapplication.pager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Notes_Activity extends AppCompatActivity {
    int noteId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_);

        EditText editText = (EditText)findViewById(R.id.editText);
        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId" , -1);

        if (noteId != -1){
            editText.setText( Galery_Activity.notes.get(noteId));
        }else{
            Galery_Activity.notes.add("");
            noteId = Galery_Activity.notes.size()-1;
            Galery_Activity.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Galery_Activity.notes.set(noteId , String.valueOf(s));
                Galery_Activity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.msjapplication.pager" , Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet(Galery_Activity.notes);
                sharedPreferences.edit().putStringSet("notes" , set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
