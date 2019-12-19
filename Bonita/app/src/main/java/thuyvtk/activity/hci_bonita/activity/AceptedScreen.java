package thuyvtk.activity.hci_bonita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    public void CancelOrder(View view) {
        Toast.makeText(this, "Bạn đã hủy đặt chỗ !", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
    }

    public void useCode(View view) {
        Toast.makeText(this, "Bạn đã sử dụng mã đặt chỗ thành công!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }
}
