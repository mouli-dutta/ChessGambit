package moulichess.a8queens.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import moulichess.a8queens.R;

public class CustomSpinnerAdapter extends ArrayAdapter<SpinnerItems> {
    public CustomSpinnerAdapter(@NonNull Context context, ArrayList<SpinnerItems> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createCustomView(position, convertView, parent);
    }

    private View createCustomView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_row_layout, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.spinner_image);
        TextView textView = convertView.findViewById(R.id.spinner_text);

        SpinnerItems item = getItem(position);

        if (item != null) {
            imageView.setImageResource(item.getImageResource());
            textView.setText(item.getImageText());
        }
        return convertView;
    }
}
