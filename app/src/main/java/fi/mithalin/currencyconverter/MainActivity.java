package fi.mithalin.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurrencyDatabase db = CurrencyDatabase.getInstance(getApplicationContext());

        Thread thread = new Thread(() -> {
            String[] currencies = new String[db.currencyDao().currencyCount()];
            List<Currency> currencyList = db.currencyDao().getAll();

            for (int i = 0; i < currencyList.size(); i++) {
                currencies[i] = currencyList.get(i).getAbbreviation();
            }

            ArrayAdapter<String> adapter =
                    new ArrayAdapter<>(
                            getApplicationContext(),
                            R.layout.dropdown_menu_popup_item,
                            currencies);

            AutoCompleteTextView inputDropdown =
                    findViewById(R.id.filled_input_dropdown);
            inputDropdown.setAdapter(adapter);

            AutoCompleteTextView outputDropdown =
                    findViewById(R.id.filled_output_dropdown);
            outputDropdown.setAdapter(adapter);
        });

        thread.start();
    }
}