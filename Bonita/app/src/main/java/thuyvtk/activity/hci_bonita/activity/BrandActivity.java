package thuyvtk.activity.hci_bonita.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

import thuyvtk.activity.hci_bonita.R;

public class BrandActivity extends Activity {
    ImageButton btnBack;
    ImageButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        defineView();
    }

    public void defineView() {
        btnBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnSave);
        btnBack.getBackground().setAlpha(150);
        btnSave.getBackground().setAlpha(150);


    }
}
