package ar.com.ponele.mascotapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

import ar.com.ponele.mascotapp.dto.CardDTO;
import ar.com.ponele.mascotapp.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView prof;
    private TextView number;

    private Firebase baseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        name = (TextView) findViewById(R.id.editText);
        prof = (TextView) findViewById(R.id.editText2);
        number = (TextView) findViewById(R.id.editText3);

        baseRef = new Firebase(Constants.FIREBASE_URL + "losts");

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CardDTO card = new CardDTO();
                card.setName(name.getText().toString());
                card.setProf(prof.getText().toString());
                card.setNumber(number.getText().toString());

                baseRef.setValue(card);
            }
        });
    }
}