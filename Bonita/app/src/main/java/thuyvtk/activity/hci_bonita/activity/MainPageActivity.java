package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.CircularSliderHandle;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.adapter.BrandAdapter;
import thuyvtk.activity.hci_bonita.adapter.DeadlineAdapter;
import thuyvtk.activity.hci_bonita.adapter.MenuAdapter;
import thuyvtk.activity.hci_bonita.adapter.RecycleViewAdapter;
import thuyvtk.activity.hci_bonita.adapter.SliderAdapter;
import thuyvtk.activity.hci_bonita.adapter.SuperDiscountAdapter;
import thuyvtk.activity.hci_bonita.adapter.TopAdapter;
import thuyvtk.activity.hci_bonita.dialog.ScrollPickerDialog;
import thuyvtk.activity.hci_bonita.dtos.MenuItemDTO;

public class MainPageActivity extends FragmentActivity implements ScrollPickerDialog.ChooseModelListener{

    private final int MENU_ITEM_HEIGHT = 170;

    SliderView imageSlider;
    LinearLayout search_bar_main;
    LinearLayout lnSearchBar;
    TextView txtContainer;

    RecyclerView rvType;
    RecyclerView rvBrand;
    RecyclerView rvSuperDiscount;
    RecyclerView rvTop;
    RecyclerView rvDeadline;
    DrawerLayout drawerLayout;

    ScrollPickerDialog scrollPickerDialog;

    BrandAdapter brandAdapter = new BrandAdapter();
    SuperDiscountAdapter superDiscountAdapter = new SuperDiscountAdapter();
    TopAdapter topAdapter = new TopAdapter();
    DeadlineAdapter deadlineAdapter = new DeadlineAdapter();

    ArrayList<MenuItemDTO> arrayList = new ArrayList<>();
    ArrayList<MenuItemDTO> categories = new ArrayList<>();
    ArrayList<MenuItemDTO> other = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        defineView();
        showThumbnails();
        loadListViewLeftMenu();
    }

    private void defineView() {
        imageSlider = findViewById(R.id.imageSlider);
        search_bar_main = findViewById(R.id.search_bar_main);
        lnSearchBar = findViewById(R.id.lnSearchBar);
        txtContainer = findViewById(R.id.txtContainer);
//        imgNotification = findViewById(R.id.imgNotification);

        rvType = findViewById(R.id.rvType);
        rvType.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        rvType.setAdapter(new RecycleViewAdapter(this));

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


    public void showLeftMenu(View view) {
        drawerLayout = findViewById(R.id.drawer);
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    private void loadListViewLeftMenu(){
        MenuAdapter menuAdapter = new MenuAdapter(getMenus(),this);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ListView lvSale = navigationView.getHeaderView(0).findViewById(R.id.lvSale);
        lvSale.setAdapter(menuAdapter);
       ViewGroup.LayoutParams param = lvSale.getLayoutParams();
       param.width = ViewGroup.LayoutParams.MATCH_PARENT;
       param.height = getListViewHeight(arrayList.size());
       lvSale.setLayoutParams(param);

       //load danh muc
        ListView lvCategory = navigationView.getHeaderView(0).findViewById(R.id.lvCategory);
        MenuAdapter categoryAdapder = new MenuAdapter(getCategory(),this);
        lvCategory.setAdapter(categoryAdapder);
        param.height = getListViewHeight(categories.size());
        lvCategory.setLayoutParams(param);

        // others
        ListView lvOther = navigationView.getHeaderView(0).findViewById(R.id.lvOther);
        MenuAdapter otherAdapter = new MenuAdapter(getOther(),this);
        lvOther.setAdapter(otherAdapter);
        param.height = getListViewHeight(other.size());
        lvOther.setLayoutParams(param);

        // onclick listener
        lvSale.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent ;
                switch (position){
                    case  0:
                        intent = new Intent(getApplicationContext(), SaleOffActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), MarkedSaleOff.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), TradeMarkFollow.class);
                        startActivity(intent);
                        break;
                    case 3:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        FragmentManager fm = getSupportFragmentManager();
                        String[] arrItems = new String[]{"TP Hồ Chí Minh", "Hà Nội", "Đà Nẵng", "Cần Thơ"};
                        scrollPickerDialog = new ScrollPickerDialog(1, arrItems,"THÀNH PHỐ");
                        scrollPickerDialog.show(fm, "fragment_choose_slot");
                        break;
                }
            }
        });

    }

    private int getListViewHeight(int size){
        return size * MENU_ITEM_HEIGHT;
    }

    private ArrayList<MenuItemDTO> getMenus(){
        arrayList.add(new MenuItemDTO("Mã khuyến mãi của tôi",R.drawable.ic_menu_item1));
        arrayList.add(new MenuItemDTO("Đánh dấu",R.drawable.ic_tag_black));
        arrayList.add(new MenuItemDTO("Theo dõi thương hiệu",R.drawable.ic_add_black));
        arrayList.add(new MenuItemDTO("Thành Phố Hồ Chí Minh",R.drawable.ic_location_black));
        return arrayList;
    }

    private ArrayList<MenuItemDTO> getCategory(){
        categories.add(new MenuItemDTO("Nữ",R.drawable.ic_add_black));
        categories.add(new MenuItemDTO("Nam",R.drawable.ic_add_black));
        categories.add(new MenuItemDTO("Nail",R.drawable.ic_add_black));
        categories.add(new MenuItemDTO("Trang điểm",R.drawable.ic_add_black));
        categories.add(new MenuItemDTO("Spa",R.drawable.ic_add_black));
        return categories;
    }

    private ArrayList<MenuItemDTO> getOther(){
        other.add(new MenuItemDTO("Đánh giá BONITA",R.drawable.ic_add_black));
        other.add(new MenuItemDTO("Điều khoản",R.drawable.ic_add_black));
        other.add(new MenuItemDTO("Chính sách bảo mật",R.drawable.ic_add_black));
        return other;
    }

    @Override
    public void itemPicked(Integer itemType, Integer modelId, String modelName) {
        scrollPickerDialog.dismiss();
    }


    public void clickToViewNotification(View view) {
        Intent intent = new Intent(this,Notification.class);
        startActivity(intent);
    }
}
