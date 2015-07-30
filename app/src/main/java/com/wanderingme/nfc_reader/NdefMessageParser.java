package com.wanderingme.nfc_reader;

/**
 * Created by Aimee on 7/23/2015.
 */
import java.util.ArrayList;
import java.util.List;

import com.wanderingme.nfc_reader.record.*;
import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NdefMessageParser {

    // Utility class
    private NdefMessageParser() {

    }

    /** Parse an NdefMessage */
    public static List<ParsedNdefRecord> parse(NdefMessage message) {
        return getRecords(message.getRecords());
    }

    public static List<ParsedNdefRecord> getRecords(NdefRecord[] records) {
        List<ParsedNdefRecord> elements = new ArrayList<ParsedNdefRecord>();
        for (final NdefRecord record : records) {

            elements.add(new ParsedNdefRecord() {
                @Override
                public View getView(Activity activity, LayoutInflater inflater, ViewGroup parent, int offset) {
                    TextView text = (TextView) inflater.inflate(R.layout.tag_text, parent, false);
                    text.setText(new String(record.getPayload()));
                    return text;
                }

            });


        }
        return elements;
    }
}