package thuyvtk.activity.hci_bonita.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import thuyvtk.activity.hci_bonita.R;

public class ScrollPickerDialog extends DialogFragment {

    private NumberPicker numberpicker;
    int selectedSlot = 0;
    private ChooseModelListener listener;
    private int itemType = -1;
    String[] arrItems;
    RecyclerView recyclerView;
    ArrayList<String> slots;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    LinearLayoutManager horizontalLayout;


    //
    int itemSelectedPos = 0;

    public ScrollPickerDialog() {
    }

    public ScrollPickerDialog(int itemType, String[] arrItems) {
        this.itemType = itemType;
        this.arrItems = arrItems;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choose_slot, container, false);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrItems = new String[]{"TP Hồ Chí Minh", "Hà Nội", "Đà Nẵng", "Cần Thơ"};
        numberpicker = (NumberPicker) getView().findViewById(R.id.numberPicker1);
        numberpicker.setMinValue(0);
        numberpicker.setMaxValue(arrItems.length - 1);
        numberpicker.setDisplayedValues(arrItems);

        listener.itemPicked(0, 0,  arrItems[0]);

        numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                listener.itemPicked(itemType, newVal, arrItems[newVal]);
                itemSelectedPos = newVal;
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (ChooseModelListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Must implement ChooseModelListener");
        }
    }
    

    public interface ChooseModelListener {
        void itemPicked(Integer itemType, Integer modelId, String modelName);
    }
}
