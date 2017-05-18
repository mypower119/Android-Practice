package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app display an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, "");
//        intent.putExtra(Intent.EXTRA_SUBJECT, "");
//        intent.putExtra(Intent.EXTRA_STREAM, "");
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
        // Figure out if the user wants whipped cream toppings
        CheckBox checkWhippedCream = (CheckBox) findViewById(R.id.check_whipped_cream);
        boolean hasWhippedCream = checkWhippedCream.isChecked();

        // Figure out if the user wants chocolate toppings
        CheckBox checkAdChocolate = (CheckBox) findViewById(R.id.check_add_chocolate);
        boolean addChocolate = checkAdChocolate.isChecked();

        // Find the user's name
        EditText textNameField = (EditText) findViewById(R.id.text_name_field);
        String name = textNameField.getText().toString();

        String message = createOrderSummary(hasWhippedCream, addChocolate, name);
        displayMessage(message);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));    // only email app should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

}

    /**
     * This method display the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView txtQuantity = (TextView) findViewById(
                R.id.text_quantity);
        txtQuantity.setText(number + "");
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if(quantity == 0) return;
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if(quantity == 100) return;
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method display the given text on the screen
     */
    public void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.text_order_summary);
        priceTextView.setText(message);
    }

    /**
     *  calculate the price of the order
     *
     * @return total price with data type of integer
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream) basePrice += 1;
        if (addChocolate) basePrice += 2;
        basePrice = basePrice * quantity;
        return basePrice;
    }

    /**
     * Create summary of order
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants add chocolate
     * @return  text summary
     */
    private String createOrderSummary(boolean addWhippedCream, boolean addChocolate,
                                      String name) {
        String quan = String.valueOf(quantity);
        String messageSummary = getString(R.string.order_summary_name, name)
                + "\n" + getString(R.string.order_summary_whipped_cream, addWhippedCream)
                + "\n" + getString(R.string.order_summary_chocolate, addChocolate)
                + "\n" + getString(R.string.order_summary_quantity,quantity)
                + "\n" + getString(R.string.order_summary_price,
                String.valueOf(calculatePrice(addWhippedCream, addChocolate)))
                + "\n" + getString(R.string.thank_you);
        return messageSummary;
    }
}
