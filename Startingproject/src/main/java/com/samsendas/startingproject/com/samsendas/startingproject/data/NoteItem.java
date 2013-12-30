package com.samsendas.startingproject.com.samsendas.startingproject.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sambulosenda on 29/12/13.
 */
public class NoteItem {
    private String key;
    private String text;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static NoteItem getNew()
    {

        Locale locale =  new Locale("en_US");
        Locale.setDefault(locale);

        String pattern = "yyyy-MM-dd HH:mm:ss Z";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String key = formatter.format(new Date());

        NoteItem note = new NoteItem();
        note.setKey("Key");
        note.setText("");
        return note;




    }


    @Override
    public String toString() {
        return this.getText();
    }
}
