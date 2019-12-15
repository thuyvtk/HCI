package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.fragment.BookingFragment;
import thuyvtk.activity.hci_bonita.fragment.HistoryFragment;

public class SaleOffActivity extends FragmentActivity {
    TabItem tabBooking;
    TabItem tabHistory;
    TabLayout tabOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_off);
        tabOrder = findViewById(R.id.tabOrder);
        tabBooking = findViewById(R.id.tabBooking);
        tabHistory = findViewById(R.id.tabHistory);
        loadFragment(new BookingFragment());
        changeSelectedTab();

    }

    public void close(View view) {
        this.finish();
    }

    public void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    public void changeSelectedTab() {
        tabOrder.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tabOrder.getSelectedTabPosition();
                if(position == 1){
                    loadFragment(new HistoryFragment());
                }else{
                    loadFragment(new BookingFragment());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void loadTab () {

        tabBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new BookingFragment());
            }
        });
        tabHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HistoryFragment());
            }
        });


    }
}
