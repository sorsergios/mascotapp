package ar.com.ponele.mascotapp.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient;

import ar.com.ponele.mascotapp.R;
import ar.com.ponele.mascotapp.dto.CardDTO;

public class HomeFragment extends Fragment {

    private TextView name;
    private TextView prof;
    private TextView number;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        name = (TextView) view.findViewById(R.id.editText);
        prof = (TextView) view.findViewById(R.id.editText2);
        number = (TextView) view.findViewById(R.id.editText3);

        // Initialize the Amazon Cognito credentials provider
        final CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                this.getActivity().getApplicationContext(),
                "ap-northeast-1:ab39b2b8-105e-48f2-9a41-c66d0a5b64c5", // Identity Pool ID
                Regions.AP_NORTHEAST_1 // Region
        );


        final HomeFragment self = this;
        final Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CardDTO card = new CardDTO();
                card.setPkey("primeItem");
                card.setName(name.getText().toString());
                card.setPhone(prof.getText().toString());
                card.setType(number.getText().toString());

                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        final AmazonDynamoDBAsyncClient ddbClient = new AmazonDynamoDBAsyncClient(credentialsProvider);
                        ddbClient.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
                        final DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
                        mapper.save(card);
                    }
                }).start();
                Snackbar.make(self.getActivity().findViewById(R.id.mainLayout), card.toString(), Snackbar.LENGTH_SHORT)
                        .show(); // Don’t forget to show!
            }
        });


        return view;
    }

}
