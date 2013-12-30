package com.samsendas.startingproject.com.samsendas.startingproject.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.renderscript.Sampler;

import java.util.*;

/**
 * Created by sambulosenda on 29/12/13.
 */
public class NotesDataSource {

    private static final String PREFKEY = "notes";
    private SharedPreferences notePrefs;

    public NotesDataSource(Context context) {
        notePrefs = context.getSharedPreferences(PREFKEY, Context.MODE_PRIVATE);
    }

 // returns all notes
    public List<NoteItem> findAll() {

        Map<String, ?> noteMap = notePrefs.getAll();

        SortedSet<String> keys = new TreeSet<String>(noteMap.keySet());


        List<NoteItem> noteList = new ArrayList<NoteItem>(); // store the data in the same order u created it in


        for(String Key : keys){
            NoteItem note = new NoteItem();
            note.setKey(Key);
            note.setText((String) noteMap.get(Key));
            noteList.add(note);


        }

        return noteList;
    }

    public boolean update(NoteItem note)
    {
        SharedPreferences.Editor editor = notePrefs.edit();
        editor.putString(note.getKey(), note.getText());
        editor.commit();
        return true;
    }
    public boolean remove(NoteItem note){
    {
       if (notePrefs.contains(note.getKey())) {
       SharedPreferences.Editor editor = notePrefs.edit();
        editor.remove(note.getKey());
        editor.commit();

       }
        return true;
    }
    }

    }
