package com.ambeyindustry.countryguide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {
    public CountryAdapter(Context context, List<Country> countries) {
        super(context, 0, countries);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item, parent, false);
        }
        Country country = getItem(position);

        TextView countryView = (TextView) listItemView.findViewById(R.id.name);
        countryView.setText(country.name);

        TextView capitalView = (TextView) listItemView.findViewById(R.id.capital);
        capitalView.setText(country.capital);

        ImageView flagView = (ImageView) listItemView.findViewById(R.id.flag);
        Resources res = getContext().getResources();
        int resId = res.getIdentifier(country.flag, "drawable", getContext().getPackageName());
        Drawable drawable;
        try {
            drawable = ContextCompat.getDrawable(getContext(), resId);
        } catch (Exception e) {
            e.printStackTrace();
            int resIdFallback = res.getIdentifier("who", "drawable", getContext().getPackageName());
            drawable = ContextCompat.getDrawable(getContext(), resIdFallback);
        }
        flagView.setImageDrawable(drawable);

        return listItemView;
    }
}
