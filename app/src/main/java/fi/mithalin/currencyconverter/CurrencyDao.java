package fi.mithalin.currencyconverter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CurrencyDao {
    @Query("SELECT * FROM currencies")
    List<Currency> getAll();

    @Query("SELECT * FROM currencies WHERE abbreviation LIKE :abb LIMIT 1")
    Currency findByAbbreviation(String abb);

    @Query("SELECT count(*) FROM currencies")
    int currencyCount();

    @Insert
    void insertAll(Currency... currencies);

    @Delete
    void delete(Currency currency);
}