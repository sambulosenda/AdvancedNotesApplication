package com.samsendas.startingproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.samsendas.startingproject.com.samsendas.startingproject.data.NoteItem;

/**
 * Created by sambulosenda on 29/12/13.
 */
public class NoteAditorActivity extends Activity {


    private NoteItem note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        Intent intent = this.getIntent();
        note = new NoteItem();
        note.setKey(intent.getStringExtra("Key"));
        note.setText(intent.getStringExtra("text"));

        EditText et = (EditText) findViewById(R.id.noteText);
        et.setText(note.getText());
        et.setSelection(note.getKey().length());
    }
}
