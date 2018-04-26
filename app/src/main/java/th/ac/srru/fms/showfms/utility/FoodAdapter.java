package th.ac.srru.fms.showfms.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import th.ac.srru.fms.showfms.R;

public class FoodAdapter extends BaseAdapter{

    private Context context;
    private String[] imageStrings, fooStrings , priceStrings, deStrings;

    public FoodAdapter(Context context,
                       String[] imageStrings,
                       String[] fooStrings,
                       String[] priceStrings,
                       String[] deStrings) {
        this.context = context;
        this.imageStrings = imageStrings;
        this.fooStrings = fooStrings;
        this.priceStrings = priceStrings;
        this.deStrings = deStrings;
    }

    @Override
    public int getCount() {
        return fooStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_food, parent, false);

        TextView fooTextView = view.findViewById(R.id.txtfood);
        TextView priceTextView = view.findViewById(R.id.txtprice);
        TextView detailTextView = view.findViewById(R.id.txtdetail);
        ImageView imageView = view.findViewById(R.id.imvFood);

        fooTextView.setText(fooStrings[position]);
        priceTextView.setText(priceStrings[position]);
        detailTextView.setText(deStrings[position]);

        Picasso.get().load(imageStrings[position]).into(imageView);

        return null;
    }
}
