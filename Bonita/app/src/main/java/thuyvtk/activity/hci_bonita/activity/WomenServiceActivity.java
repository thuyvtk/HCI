package thuyvtk.activity.hci_bonita.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.adapter.AllAdapter;
import thuyvtk.activity.hci_bonita.adapter.BrandChildAdapter;
import thuyvtk.activity.hci_bonita.adapter.NearbyChildAdapter;
import thuyvtk.activity.hci_bonita.adapter.TopLocationAdapter;

public class WomenServiceActivity extends FragmentActivity {

    RecyclerView rvTopLocation;
    TextView btnNewest;
    TextView btnNearBy;
    TextView btnTrend;
    TextView btnSuperDiscount;
    RecyclerView rvBrandWoment;
    RecyclerView rvNearby;
    RecyclerView rvAll;

    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_service);
        defineView();
        showTopLocation();
        showTopBrand();
        showNearBy();
        selectedTab(btnNewest);
        showAll();
    }

    public void defineView() {
        btnNewest = findViewById(R.id.btnNewest);
        btnNearBy = findViewById(R.id.btnNearBy);
        btnTrend = findViewById(R.id.btnTrend);
        btnSuperDiscount = findViewById(R.id.btnSuperDiscount);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        selectedNewestTab();
        selectedNearByTab();
        selectedTrendTab();
        selectedSupperDiscountTab();

    }

    public void back() {
        this.finish();
    }

    public void showTopBrand() {
        Integer[] images = {
                R.drawable.four,
                R.drawable.women_brand1,
                R.drawable.women_brand3,
                R.drawable.woment_brand2,
        };
        String[] topLocationNames = {
                "GIFT SALON",
                "CHANG SALON",
                "ONE PHOTO SALON",
                "FREE SALON"
        };
        rvBrandWoment = findViewById(R.id.rvBrandWomen);
        rvBrandWoment.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvBrandWoment.setAdapter(new BrandChildAdapter(images, topLocationNames));
    }

    public void showNearBy() {
        Integer[] images = {
                R.drawable.discount1,
                R.drawable.discount2,
                R.drawable.discount4,
        };

        String[] discountNumbers = {
                "-69%",
                "-80%",
                "-50%",
        };

        String[] names = {
                "NHAT THIEN SALON",
                "HAIR STAR",
                "Bac Tran Tien Hair"
        };

        rvNearby = findViewById(R.id.rvNearby);
        rvNearby.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvNearby.setAdapter(new NearbyChildAdapter(this,images, discountNumbers,names));
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

    public void showAll() {
        rvAll = findViewById(R.id.rvAll);
        rvAll.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        rvAll.setAdapter(new AllAdapter());

    }

    public void selectedTab(TextView textView) {
        textView.setBackground(getResources().getDrawable(R.drawable.border_radius_red));
        textView.setTextColor(getResources().getColor(R.color.tab));
    }

    public void unSelectedTab(TextView textView) {
        textView.setBackground(getResources().getDrawable(R.drawable.border_tab_radius_red));
        textView.setTextColor(getResources().getColor(R.color.text));
    }

    public void selectedNewestTab() {
        btnNewest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(btnNewest);
                unSelectedTab(btnNearBy);
                unSelectedTab(btnTrend);
                unSelectedTab(btnSuperDiscount);
//                loadFragment(new HistoryFragment());
            }
        });
    }

    public void selectedNearByTab() {
        btnNearBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(btnNearBy);
                unSelectedTab(btnNewest);
                unSelectedTab(btnTrend);
                unSelectedTab(btnSuperDiscount);
//                loadFragment(new BookingFragment());
            }
        });
    }

    public void selectedTrendTab() {
        btnTrend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(btnTrend);
                unSelectedTab(btnNearBy);
                unSelectedTab(btnNewest);
                unSelectedTab(btnSuperDiscount);
//                loadFragment(new TrendFragment());
            }
        });
    }

    public void selectedSupperDiscountTab() {
        btnSuperDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(btnSuperDiscount);
                unSelectedTab(btnNearBy);
                unSelectedTab(btnNewest);
                unSelectedTab(btnTrend);
//                loadFragment(new SuperDiscountFragment());
            }
        });
    }

    public void openFilter(View view) {
        Intent intent = new Intent(this, FilterActivity.class);
        startActivity(intent);
    }
}
