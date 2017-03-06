package com.ambeyindustry.countryguide;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class CountryListLoader extends AsyncTaskLoader<List<Country>> {

    private Context context;

    public CountryListLoader(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Country> loadInBackground() {
        return FileUtil.loadJSONFromAsset(context);
    }
}
