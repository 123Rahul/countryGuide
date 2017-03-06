package com.ambeyindustry.countryguide;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Country>> {

    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView countryListView = (ListView) findViewById(R.id.list);
        countryAdapter = new CountryAdapter(this, new ArrayList<Country>());
        countryListView.setAdapter(countryAdapter);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(1, null, this);

        countryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Country country = (Country) ((ListView) adapterView).getAdapter().getItem(i);
                Intent phrasesIntent = new Intent(view.getContext(), InfoActivity.class);
                phrasesIntent.putExtra("country", country);
                startActivity(phrasesIntent);
            }
        });
    }

    @Override
    public Loader<List<Country>> onCreateLoader(int i, Bundle bundle) {
        return new CountryListLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Country>> loader, List<Country> countries) {
        countryAdapter.clear();
        if (countries != null) {
            countryAdapter.addAll(countries);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Country>> loader) {
        countryAdapter.clear();
    }
}
