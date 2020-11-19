package fi.mithalin.currencyconverter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "currencies")
public class Currency {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String abbreviation;
    private String name;
    private int signId;

    public Currency(String abbreviation, String name, int signId) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.signId = signId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSignId() {
        return signId;
    }

    public void setSignId(int signId) {
        this.signId = signId;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                ", sign=" + signId +
                '}';
    }
}
