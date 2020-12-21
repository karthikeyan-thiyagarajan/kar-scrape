package utils.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class PetrolLists {

    @SerializedName("results")
    private List<Result> mResults;

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
