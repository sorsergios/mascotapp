package ar.com.ponele.mascotapp.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;

import ar.com.ponele.mascotapp.R;
import ar.com.ponele.mascotapp.amazon.AmazonConnector;
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

        final FragmentActivity self = this.getActivity();
        final DynamoDBMapper mapper = AmazonConnector.createDynamoDBMapper(self);
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
                        mapper.save(card);
                    }
                }).start();
                Snackbar.make(self.findViewById(R.id.mainLayout), card.toString(), Snackbar.LENGTH_SHORT)
                        .show(); // Don’t forget to show!
            }
        });


        return view;
    }

}
