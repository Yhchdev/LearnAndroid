package yhch.xyz.uitest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    private ImageView imageView;

    private ProgressBar process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        editText = findViewById(R.id.edit);
        imageView = findViewById(R.id.image_view);

        process = findViewById(R.id.process);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String str = editText.getText().toString();
//                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();

                //imageView.setImageResource(R.mipmap.logo);

//                if(process.getVisibility() == View.GONE){
//                    process.setVisibility(View.VISIBLE);
//                }else{
//                    process.setVisibility(View.GONE);
//                }

//                int processValue = process.getProgress();
//                processValue +=10;
//                process.setProgress(processValue);

//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//
//                builder.setTitle("Dialog");
//                builder.setMessage("弹出重要信息");
//                builder.setCancelable(false);
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//
//                builder.show();

                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("processDialog");
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
                progressDialog.show();

            }
        });
    }
}
