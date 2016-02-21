package com.biene.app.bieneapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public ClassTagReader classTagReader;
    public static int READER_FLAGS =
            NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classTagReader = new ClassTagReader();
        if(!userIsRegistred())
            showRegisterForm();
        else
            enableReaderMode();
    }

    private void showRegisterForm() {


    }

    private boolean userIsRegistred() {
        SharedPreferences prefs =
                getSharedPreferences("BienePreferences", Context.MODE_PRIVATE);
        return prefs.contains("BieneUser");
    }

    private void enableReaderMode() {
        Log.i(TAG, "Enabling reader mode");
        Activity activity = this;
        NfcAdapter nfc = NfcAdapter.getDefaultAdapter(activity);
        if (nfc != null) {
            nfc.enableReaderMode(activity, classTagReader, READER_FLAGS, null);
        }
    }

}
