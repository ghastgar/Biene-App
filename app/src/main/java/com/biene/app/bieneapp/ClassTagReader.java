package com.biene.app.bieneapp;

import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.util.Log;

public class ClassTagReader implements NfcAdapter.ReaderCallback {

    private static final String TAG = ClassTagReader.class.getSimpleName();

    /**
     * Callback when a new tag is discovered by the system.
     *
     * <p>Communication with the card should take place here.
     *
     * @param tag Discovered tag
     */
    @Override
    public void onTagDiscovered(Tag tag) {
        Log.i(TAG, "New tag discovered");
        // Android's Host-based Card Emulation (HCE) feature implements the ISO-DEP (ISO 14443-4)
        // protocol.
        //
        // In order to communicate with a device using HCE, the discovered tag should be processed
        // using the IsoDep class.
        Log.e("tag id: ", tag.getId() + " ");
        //((TextView) findViewById(R.id.text)).setText("Read tag: " + tag.getId() + " ");
        IsoDep isoDep = IsoDep.get(tag);

    }
}
