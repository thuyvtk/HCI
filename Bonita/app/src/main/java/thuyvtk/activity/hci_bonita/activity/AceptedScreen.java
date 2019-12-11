package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import thuyvtk.activity.hci_bonita.R;

public class AceptedScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acepted_screen);
    }

    public void clickToBack(View view) {
        this.finish();
    }
}
