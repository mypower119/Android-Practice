package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/*
* {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link AndroidFlavor} objects.
* */
public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mColorResourceId;
    //private MediaPlayer mediaPlayer;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of AndroidFlavor objects to display in a list
     */
    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0, words);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the {@link AndroidFlavor} object located at this position in the list
        final Word currentWord = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        // CHạy lần đầu tiên để xác định listView tại layout hiện tại
        if(listItemView == null) {
            // Lưu ý getContext của class chứ không phải view listViewItem
            // Hàm nay thay thế cho số 0 mà ta thêm vô ở constructor khi không biết truyền ID resource gì bởi vì ta đã inflating the layout ở hàm getView
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_word_list, parent, false);
        }

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView textMiwok = (TextView) listItemView.findViewById(R.id.text_miwok);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        textMiwok.setText(currentWord.getMiwokTranslationId());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView textDefault = (TextView) listItemView.findViewById(R.id.text_default);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        textDefault.setText(currentWord.getDefaultTranslationId());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        // get color phù hợp với background nền và với color với linearlayout trả về color phù hợp cho linearlayout bao gồm 2 textbox
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

//        if(currentWord.hasAudio()) {
//            listItemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(mediaPlayer != null) mediaPlayer.release();
//                    mediaPlayer = MediaPlayer.create(getContext(),
//                            currentWord.getAudioResourceId());
//                    mediaPlayer.start();
//                }
//            });
//        }
        return listItemView;
    }

}
