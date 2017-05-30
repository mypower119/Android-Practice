package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.android.quakereport.R.id.magnitude;

/**
 * Created by TruongVu on 18/5/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private final static String LOCATION_SEPARATOR = "of ";

    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_earthquake, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView textMagnitude = (TextView) itemView.findViewById(magnitude);
        textMagnitude.setText(formatMagnitude(currentEarthquake.getMagnitude()));
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) textMagnitude.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        String[] locationSplit = splitPlace(currentEarthquake.getLocation());
        TextView textLocation = (TextView) itemView.findViewById(R.id.location_offset);
        textLocation.setText(locationSplit[0]);
        TextView textPlace = (TextView) itemView.findViewById(R.id.primary_location);
        textPlace.setText(locationSplit[1]);

        Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());
        TextView textDate = (TextView) itemView.findViewById(R.id.date);
        textDate.setText(formatDate(dateObject));
        TextView textTime = (TextView) itemView.findViewById(R.id.time);
        textTime.setText(formatTime(dateObject));

        return itemView;
    }

    private int getMagnitudeColor(double magnitudeValue) {
        int magnitudeColor = 0;
        switch ((int)magnitudeValue) {
            case 0:
            case 1:
                magnitudeColor = R.color.magnitude1;
                break;
            case 2:
                magnitudeColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeColor = R.color.magnitude9;
                break;
            default:
                magnitudeColor = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColor);
    }

    private String formatMagnitude(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(number);
    }

    private String[] splitPlace(String strSrc) {
        String[] strResult = new String[]{"", ""};
        if(strSrc.contains(LOCATION_SEPARATOR)) {
            strResult = strSrc.split("(?<="+LOCATION_SEPARATOR+")");
        } else {
            strResult[0] = getContext().getString(R.string.near_the);
            strResult[1] = strSrc;
        }
        return strResult;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return simpleDateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat simpleDateFormat  =new SimpleDateFormat("h:mm a");
        return simpleDateFormat.format(dateObject);
    }
}
