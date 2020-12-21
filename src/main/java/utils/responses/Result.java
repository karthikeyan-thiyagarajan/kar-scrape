package utils.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Result {

    @SerializedName("cityState")
    private String mCityState;
    @SerializedName("createdDate")
    private String mCreatedDate;
    @SerializedName("dieselChange")
    private String mDieselChange;
    @SerializedName("dieselPrice")
    private String mDieselPrice;
//    @SerializedName("ID")
//    private Long mID;
//    @SerializedName("isActive")
//    private transient Long mIsActive;
//    @SerializedName("origin")
//    private transient String mOrigin;
    @SerializedName("petrolChange")
    private String mPetrolChange;
    @SerializedName("petrolPrice")
    private String mPetrolPrice;
    @SerializedName("priceDate")
    private String mPriceDate;
//    @SerializedName("seoname")
//    private transient String mSeoname;
//    @SerializedName("type")
//    private transient String mType;

    public String getCityState() {
        return mCityState;
    }

    public void setCityState(String cityState) {
        mCityState = cityState;
    }

    public String getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        mCreatedDate = createdDate;
    }

    public String getDieselChange() {
        return mDieselChange;
    }

    public void setDieselChange(String dieselChange) {
        mDieselChange = dieselChange;
    }

    public String getDieselPrice() {
        return mDieselPrice;
    }

    public void setDieselPrice(String dieselPrice) {
        mDieselPrice = dieselPrice;
    }

 /*   public Long getID() {
        return mID;
    }

    public void setID(Long iD) {
        mID = iD;
    }

    public Long getIsActive() {
        return mIsActive;
    }

    public void setIsActive(Long isActive) {
        mIsActive = isActive;
    }

    public String getOrigin() {
        return mOrigin;
    }

    public void setOrigin(String origin) {
        mOrigin = origin;
    }*/

    public String getPetrolChange() {
        return mPetrolChange;
    }

    public void setPetrolChange(String petrolChange) {
        mPetrolChange = petrolChange;
    }

    public String getPetrolPrice() {
        return mPetrolPrice;
    }

    public void setPetrolPrice(String petrolPrice) {
        mPetrolPrice = petrolPrice;
    }

    public String getPriceDate() {
        return mPriceDate;
    }

    public void setPriceDate(String priceDate) {
        mPriceDate = priceDate;
    }

/*    public String getSeoname() {
        return mSeoname;
    }

    public void setSeoname(String seoname) {
        mSeoname = seoname;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }*/

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
