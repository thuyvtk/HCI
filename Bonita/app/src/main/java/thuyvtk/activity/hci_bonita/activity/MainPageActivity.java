package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smarteist.autoimageslider.CircularSliderHandle;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.adapter.BrandAdapter;
import thuyvtk.activity.hci_bonita.adapter.RecycleViewAdapter;
import thuyvtk.activity.hci_bonita.adapter.SliderAdapter;
import thuyvtk.activity.hci_bonita.adapter.SuperDiscountAdapter;

public class MainPageActivity extends Activity {

    SliderView imageSlider;
    LinearLayout search_bar_main;
    LinearLayout lnSearchBar;
    TextView txtContainer;

    RecyclerView rvType;
    RecyclerView rvBrand;
    RecyclerView rvSuperDiscount;

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
        rvType.setAdapter(new RecycleViewAdapter());

        rvBrand = findViewById(R.id.rvBrand);
        rvBrand.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvBrand.setAdapter(new BrandAdapter());

        rvSuperDiscount = findViewById(R.id.rvSuperDiscount);
        rvSuperDiscount.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvSuperDiscount.setAdapter(new SuperDiscountAdapter());


    }

    public void showThumbnails() {
        imageSlider.setSliderAdapter(new SliderAdapter(getApplicationContext()));
        imageSlider.setAutoCycle(false);
        imageSlider.startAutoCycle();
        imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM);
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.setScrollTimeInSec(10);
    }

    public void showTypeIcon() {

    }

}
