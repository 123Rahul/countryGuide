package com.ambeyindustry.countryguide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    public DetailFragment() {
    }

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Country country = ((InfoActivity) getActivity()).country;

        TextView countryName = (TextView) rootView.findViewById(R.id.country);
        countryName.setText(country.name);
        TextView nativeV = (TextView) rootView.findViewById(R.id.nativeName);
        nativeV.setText(country.nativeName);
        if (country.name.equals(country.nativeName)) {
            nativeV.setVisibility(View.GONE);
        }
        TextView capital = (TextView) rootView.findViewById(R.id.capital);
        capital.setText(country.capital);
        TextView area = (TextView) rootView.findViewById(R.id.area);
        area.setText(country.area+" sq. km");
        TextView population = (TextView) rootView.findViewById(R.id.population);
        population.setText(country.population);
        TextView region = (TextView) rootView.findViewById(R.id.region);
        region.setText(country.region);
        TextView callingCode = (TextView) rootView.findViewById(R.id.callingCode);
        callingCode.setText(country.callingCode);
        TextView demonym = (TextView) rootView.findViewById(R.id.demonym);
        demonym.setText(country.demonym);
        TextView gini = (TextView) rootView.findViewById(R.id.gini);
        gini.setText(country.gini);
        TextView timezone = (TextView) rootView.findViewById(R.id.timezone);
        timezone.setText(country.timezone);
        TextView language = (TextView) rootView.findViewById(R.id.language);
        language.setText(country.language);


        ImageView flagView = (ImageView) rootView.findViewById(R.id.flag);
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

        return rootView;
    }
}