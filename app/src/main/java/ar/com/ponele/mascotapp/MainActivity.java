package ar.com.ponele.mascotapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ar.com.ponele.mascotapp.dto.CardDTO;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private TextView prof;
    private TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.mainToolBar);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
    }

    @Override
    protected void onStart() {
        super.onStart();

        name = (TextView) findViewById(R.id.editText);
        prof = (TextView) findViewById(R.id.editText2);
        number = (TextView) findViewById(R.id.editText3);
/*
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "policygen-Cognito_mascotappUnauth_Role-201603062210", // Identity Pool ID
                Regions.AP_NORTHEAST_1 // Region
        );;
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
*/

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CardDTO card = new CardDTO();
                card.setName(name.getText().toString());
                card.setProf(prof.getText().toString());
                card.setNumber(number.getText().toString());
            }
        });
    }
}
