package thuyvtk.activity.hci_bonita.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thuyvtk.activity.hci_bonita.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends Fragment {


    public TrendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trend, container, false);
    }

}
