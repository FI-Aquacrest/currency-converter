package fi.mithalin.currencyconverter;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Currency.class}, version = 1)
abstract class CurrencyDatabase extends RoomDatabase {
    private static CurrencyDatabase sInstance;

    public abstract CurrencyDao currencyDao();

    private Executor dbExecutor;

    public static CurrencyDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (CurrencyDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context,
                            CurrencyDatabase.class, "currency-converter")
                            .fallbackToDestructiveMigration()
                            .build();
                    sInstance.populateInitialData(context);
                }
            }
        }
        return sInstance;
    }

    public Executor getExecutor() {
        if (dbExecutor == null) {
            dbExecutor = Executors.newSingleThreadExecutor();
        }
        return dbExecutor;
    }

    private void populateInitialData(Context context) {
        getExecutor().execute(() -> {
            if (currencyDao().currencyCount() == 0) {
                Currency[] currencies = {
                        new Currency("USD", context.getString(R.string.curr_usd_name), R.drawable.dollar_symbol),
                        new Currency("EUR", context.getString(R.string.curr_eur_name), R.drawable.euro_symbol),
                        new Currency("JPY", context.getString(R.string.curr_jpy_name), R.drawable.yen_symbol),
                        new Currency("GBP", context.getString(R.string.curr_gbp_name), R.drawable.pound_symbol),
                        new Currency("AUD", context.getString(R.string.curr_aud_name), R.drawable.dollar_symbol),
                        new Currency("CNH", context.getString(R.string.curr_cnh_name), R.drawable.yen_symbol),
                        new Currency("NZD", context.getString(R.string.curr_nzd_name), R.drawable.dollar_symbol)
                };

                currencyDao().insertAll(currencies);
            }
        });
    }
}
