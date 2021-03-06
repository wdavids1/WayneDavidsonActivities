package edu.westga.cs6242.waynedavidsonactivities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public final static String NEW_EXTRA_MESSAGE = "edu.westga.cs6242.waynedavidsonactivities.MESSAGE";
    public final static String NEW_EXTRA_MESSAGE2 = "edu.westga.cs6242.waynedavidsonactivities.MESSAGE2";

    /** Called when the user clicks the next button */
    public void nextMessage(View view) {
        Intent intent = new Intent(this, DisplayTwoMessagesActivity.class);

        TextView textView = (TextView) findViewById(R.id.first_message);
        String message = textView.getText().toString();
        intent.putExtra(NEW_EXTRA_MESSAGE, message);

        EditText editText = (EditText) findViewById(R.id.edit_second_message);
        String message2 = editText.getText().toString();
        intent.putExtra(NEW_EXTRA_MESSAGE2, message2);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.first_message);
        textView.setText(message);
    }

}
