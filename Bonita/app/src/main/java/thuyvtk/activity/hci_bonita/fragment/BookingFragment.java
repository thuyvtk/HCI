package thuyvtk.activity.hci_bonita.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.activity.AceptedScreen;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment {

    ImageView imv1;

    public BookingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        imv1 = view.findViewById(R.id.imv1);
        imv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickToViewDetail();
            }
        });
        return view;
    }

    public void clickToViewDetail() {
        Intent intent = new Intent(getContext(), AceptedScreen.class);
        startActivity(intent);
    }

}
