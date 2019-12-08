package thuyvtk.activity.hci_bonita.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.adapter.TopLocationAdapter;

public class WomenServiceActivity extends Activity {

    RecyclerView rvTopLocation;
    TextView btnNewest;
    TextView btnNearBy;
    TextView btnTrend;
    TextView btnSuperDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_service);
        defineView();
        showTopLocation();
    }

    public void defineView() {
        btnNewest = findViewById(R.id.btnNewest);
        btnNearBy = findViewById(R.id.btnNearBy);
        btnTrend = findViewById(R.id.btnTrend);
        btnSuperDiscount = findViewById(R.id.btnSuperDiscount);

        btnNewest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(btnNewest);
                unSelectedTab(btnNearBy);
                unSelectedTab(btnTrend);
                unSelectedTab(btnSuperDiscount);
            }
        });

        btnNearBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(btnNearBy);
                unSelectedTab(btnNewest);
                unSelectedTab(btnTrend);
                unSelectedTab(btnSuperDiscount);
            }
        });

        btnTrend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(btnTrend);
                unSelectedTab(btnNearBy);
                unSelectedTab(btnTrend);
                unSelectedTab(btnSuperDiscount);
            }
        });

        btnSuperDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(btnSuperDiscount);
                unSelectedTab(btnNearBy);
                unSelectedTab(btnSuperDiscount);
                unSelectedTab(btnTrend);
            }
        });


    }

    public void showTopLocation() {
        Integer[] images = {
                R.drawable.top8,
                R.drawable.top5,
                R.drawable.top6,
                R.drawable.top8,
        };
        String[] topLocationNames = {
                "KEIRIN HAIR : Toàn dịch vụ",
                "LIFE SALON : Làm tóc cô dâu",
                "NHAT THIEN SALON : Làm tóc",
                "BAC TRAN TIEN HAIR : Đồng giá nhuộm"
        };
        rvTopLocation = findViewById(R.id.rvTopLocation);
        rvTopLocation.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvTopLocation.setAdapter(new TopLocationAdapter(images, topLocationNames));
    }

    public void selectedTab(TextView textView) {
        textView.setBackground(getResources().getDrawable(R.drawable.border_radius_red));
        textView.setTextColor(getResources().getColor(R.color.tab));
    }

    public void unSelectedTab(TextView textView) {
        textView.setBackground(getResources().getDrawable(R.drawable.border_tab_radius_red));
        textView.setTextColor(getResources().getColor(R.color.text));
    }

}
