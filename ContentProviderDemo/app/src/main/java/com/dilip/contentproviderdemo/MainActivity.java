package com.dilip.contentproviderdemo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * MainActivity for the ContentProviderDemo app.
 * Displays contacts information using a Loader.
 */
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    /**
     * TAG is used for logging messages.
     * MY_PERMISSIONS_REQUEST_READ_CONTACTS is a constant request code for permission requests.
     * firstTimeLoaded keeps track of whether the data has been loaded before.
     * textViewQueryResult is the TextView used to display the query result.
     * buttonLoadData is the Button used to trigger data loading.
     */
    private static final String TAG = "ContentProviderDemo";
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 20;
    private boolean firstTimeLoaded = false;
    private TextView textViewQueryResult;
    private Button buttonLoadData;

    /**
     * mColumnProjection defines which columns to fetch from the Contacts table.
     * mSelectionClause filters the contacts to only include those with phone numbers.
     * mOrderBy specifies sorting the results by the contact's display name.
     */
    private String[] mColumnProjection = new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.HAS_PHONE_NUMBER,
            ContactsContract.Contacts._ID};

    private String mSelectionClause = ContactsContract.Contacts.HAS_PHONE_NUMBER + " = 1"; // Filter contacts with phone numbers
    private String mOrderBy = ContactsContract.Contacts.DISPLAY_NAME_PRIMARY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        textViewQueryResult = findViewById(R.id.textViewQueryResult);
        buttonLoadData = findViewById(R.id.buttonLoadData);
        buttonLoadData.setOnClickListener(this);

        // Request permissions if needed (replace with actual permission handling)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with loading data
                getLoaderManager().initLoader(1, null, this);
            } else {
                // Handle permission denied case (e.g., show a message to user)
            }
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (id == 1) {
            return new CursorLoader(MainActivity.this, ContactsContract.Contacts.CONTENT_URI,
                    mColumnProjection, mSelectionClause, null, mOrderBy);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0) {
            StringBuilder stringBuilderQueryResult = new StringBuilder();
            while (cursor.moveToNext()) {
                String name = cursor.getString(0);
                String contactId = cursor.getString(2);
                Cursor phoneCursor = getContentResolver().query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        new String[]{contactId},
                        null);

                if (phoneCursor != null && phoneCursor.moveToFirst()) {
                    @SuppressLint("Range") String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    stringBuilderQueryResult.append(name).append(" : ").append(phoneNumber).append("\n");
                    phoneCursor.close();
                }
            }
            textViewQueryResult.setText(stringBuilderQueryResult.toString());
        } else {
            textViewQueryResult.setText("No Contacts with phone numbers found.");
        }
        cursor.close();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Handle loader reset
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonLoadData) {
            if (!firstTimeLoaded) {
                getLoaderManager().initLoader(1, null, this);
                firstTimeLoaded = true;
            } else {
                getLoaderManager().restartLoader(1, null, this);
            }
        }
    }
}
