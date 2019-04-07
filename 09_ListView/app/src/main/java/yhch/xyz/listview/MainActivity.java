package yhch.xyz.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

/**
    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear"
    ,"Grape","Pineapple","Strawberry","Cherry","Mango","Apple","Banana","Orange","Watermelon","Pear"
            ,"Grape","Pineapple","Strawberry","Cherry","Mango",};

**/
    private List<Fruit> listfruit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,data
        );

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
         **/

        initFruit();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item,listfruit);
        final ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = listfruit.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        for(int i=0;i<2;i++){
            Fruit apple = new Fruit("apple",R.drawable.apple);
            listfruit.add(apple);
            Fruit banana = new Fruit("banana",R.drawable.banana);
            listfruit.add(banana);
            Fruit cherry = new Fruit("cherry",R.drawable.cherry);
            listfruit.add(cherry);
            Fruit grape = new Fruit("grape",R.drawable.grape);
            listfruit.add(grape);
            Fruit mango = new Fruit("mango",R.drawable.mango);
            listfruit.add(mango);
            Fruit orange = new Fruit("orange",R.drawable.orange);
            listfruit.add(orange);
            Fruit pear = new Fruit("pear",R.drawable.pear);
            listfruit.add(pear);
            Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple);
            listfruit.add(pineapple);
            Fruit watermelon = new Fruit("watermelon",R.drawable.watermelon);
            listfruit.add(watermelon);
        }



    }
}
