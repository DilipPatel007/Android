package com.example.simplenotesapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button btnCreateNote;
    FloatingActionButton fabAdd;
    RecyclerView recyclerviewNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVar();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_note_layout);

                EditText edtTitle, edtContent;
                FloatingActionButton btnAdd;

                edtTitle = dialog.findViewById(R.id.etTitle);
                edtContent = dialog.findViewById(R.id.edtContent);
                btnAdd = dialog.findViewById(R.id.btnAdd);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title = edtTitle.getText().toString();
                        String content = edtContent.getText().toString();

                        if (content.equals("")){

                        } else {
                            Toast.makeText(MainActivity.this, "Please, enter anything!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabAdd.performClick();
            }
        });

    }

    private void initVar() {
        btnCreateNote = findViewById(R.id.btnCreateNote);
        fabAdd = findViewById(R.id.fabAdd);
        recyclerviewNotes = findViewById(R.id.recyclerviewNotes);

        recyclerviewNotes.setLayoutManager(new GridLayoutManager(this, 2));
    }
}