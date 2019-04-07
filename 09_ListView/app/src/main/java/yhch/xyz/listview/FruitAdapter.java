package yhch.xyz.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;
    public FruitAdapter(Context context, int resource,List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView fruitImag = view.findViewById(R.id.image);
        TextView fruitName = view.findViewById(R.id.text1);
        fruitImag.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;

    }

    /**
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHoder viewHoder;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHoder = new ViewHoder();
            viewHoder.fruitImage = view.findViewById(R.id.image);
            viewHoder.fruitName = view.findViewById(R.id.text1);
            view.setTag(viewHoder); //将viewHoder存储在view中
        }else {
            view = convertView;
            viewHoder = (ViewHoder) view.getTag(); //重新获取viewHoder
        }
        viewHoder.fruitImage.setImageResource(fruit.getImageId());
        viewHoder.fruitName.setText(fruit.getName());

        return view;
    }

    class ViewHoder{
        ImageView fruitImage;
        TextView fruitName;
    }
    **/
}
