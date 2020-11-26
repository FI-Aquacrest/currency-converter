package fi.mithalin.currencyconverter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ConversionRates {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private double usdRate;
    private double eurRate;
    private double jpyRate;
    private double gbpRate;
    private double audRate;
    private double cnhRate;
    private double nzdRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(double usdRate) {
        this.usdRate = usdRate;
    }

    public double getEurRate() {
        return eurRate;
    }

    public void setEurRate(double eurRate) {
        this.eurRate = eurRate;
    }

    public double getJpyRate() {
        return jpyRate;
    }

    public void setJpyRate(double jpyRate) {
        this.jpyRate = jpyRate;
    }

    public double getGbpRate() {
        return gbpRate;
    }

    public void setGbpRate(double gbpRate) {
        this.gbpRate = gbpRate;
    }

    public double getAudRate() {
        return audRate;
    }

    public void setAudRate(double audRate) {
        this.audRate = audRate;
    }

    public double getCnhRate() {
        return cnhRate;
    }

    public void setCnhRate(double cnhRate) {
        this.cnhRate = cnhRate;
    }

    public double getNzdRate() {
        return nzdRate;
    }

    public void setNzdRate(double nzdRate) {
        this.nzdRate = nzdRate;
    }
}
