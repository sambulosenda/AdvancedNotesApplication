package com.samsendas.startingproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.samsendas.startingproject.com.samsendas.startingproject.data.NoteItem;
import com.samsendas.startingproject.com.samsendas.startingproject.data.NotesDataSource;

import java.util.List;

public class MainActivity extends ListActivity{

    private NotesDataSource datasource;
    List<NoteItem> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datasource = new NotesDataSource(this);


        refreshDisplay();


    }

    private void refreshDisplay() {

        notesList = datasource.findAll();
        ArrayAdapter<NoteItem> adapter =
                new ArrayAdapter<NoteItem>(this, R.layout.list_item_layout , notesList);
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_create){
            createNote();
        }
        return super.onOptionsItemSelected(item);
    }

    private void createNote(){
        NoteItem note = NoteItem.getNew();
        Intent intent = new Intent(this, NoteAditorActivity.class);
        intent.putExtra("Key", note.getKey());
        intent.putExtra("text", note.getText());
        startActivityForResult(intent, 1001);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        NoteItem note = notesList.get(position);
        Intent intent = new Intent(this, NoteAditorActivity.class);
        intent.putExtra("Key", note.getKey());
        intent.putExtra("text", note.getText());
        startActivityForResult(intent, 1001);
    }
}