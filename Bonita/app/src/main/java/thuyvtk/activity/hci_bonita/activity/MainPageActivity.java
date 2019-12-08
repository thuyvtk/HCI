package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.CircularSliderHandle;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.adapter.BrandAdapter;
import thuyvtk.activity.hci_bonita.adapter.DeadlineAdapter;
import thuyvtk.activity.hci_bonita.adapter.RecycleViewAdapter;
import thuyvtk.activity.hci_bonita.adapter.SliderAdapter;
import thuyvtk.activity.hci_bonita.adapter.SuperDiscountAdapter;
import thuyvtk.activity.hci_bonita.adapter.TopAdapter;

public class MainPageActivity extends Activity {

    SliderView imageSlider;
    LinearLayout search_bar_main;
    LinearLayout lnSearchBar;
    TextView txtContainer;

    RecyclerView rvType;
    RecyclerView rvBrand;
    RecyclerView rvSuperDiscount;
    RecyclerView rvTop;
    RecyclerView rvDeadline;

    BrandAdapter brandAdapter = new BrandAdapter();
    SuperDiscountAdapter superDiscountAdapter = new SuperDiscountAdapter();
    TopAdapter topAdapter = new TopAdapter();
    DeadlineAdapter deadlineAdapter = new DeadlineAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        defineView();
        showThumbnails();
    }

    private void defineView() {
        imageSlider = findViewById(R.id.imageSlider);
        search_bar_main = findViewById(R.id.search_bar_main);
        lnSearchBar = findViewById(R.id.lnSearchBar);
        txtContainer = findViewById(R.id.txtContainer);
//        imgNotification = findViewById(R.id.imgNotification);

        rvType = findViewById(R.id.rvType);
        rvType.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvType.setAdapter(new RecycleViewAdapter(getApplicationContext()));

        rvBrand = findViewById(R.id.rvBrand);
        rvBrand.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvBrand.setAdapter(brandAdapter);

        rvSuperDiscount = findViewById(R.id.rvSuperDiscount);
        rvSuperDiscount.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvSuperDiscount.setAdapter(superDiscountAdapter);

        rvTop = findViewById(R.id.rvTop);
        rvTop.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvTop.setAdapter(topAdapter);

        rvDeadline = findViewById(R.id.rvDeadline);
        rvDeadline.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvDeadline.setAdapter(deadlineAdapter);


    }

    public void showThumbnails() {
        imageSlider.setSliderAdapter(new SliderAdapter(getApplicationContext()));
        imageSlider.setAutoCycle(false);
        imageSlider.startAutoCycle();
        imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM);
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.setScrollTimeInSec(10);
    }


}
