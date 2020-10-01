package com.camille.mondeafpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class DisplayNumberActivity extends AppCompatActivity {

    private TextView mNumberOfFacesText;
    private TextView mResultText;
    private Button mRollBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_number);

        Intent intent = getIntent();
        final int numberOfFaces = intent.getIntExtra("nbOfFaces", 0);
        mNumberOfFacesText = (TextView) findViewById(R.id.activity_display_number_faces_txt);
        mNumberOfFacesText.setText("Pour un Dé à " + numberOfFaces + " Faces.");

        Random random = new Random();
        int nb;
        nb = 1 + random.nextInt((numberOfFaces + 1) - 1);
        mResultText = (TextView) findViewById(R.id.activity_display_number_result_txt);
        mResultText.setText(Integer.toString(nb));

        mRollBackButton = (Button) findViewById(R.id.activity_display_number_rollBack_btn);
        mRollBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayNumberActivity.this, DisplayNumberActivity.class);
                Bundle b = new Bundle();
                b.putInt("nbOfFaces", numberOfFaces);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
