package yhch.xyz.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_titles",newsTitle);
        intent.putExtra("news_contents",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle = getIntent().getStringExtra("news_titles");
        String newsContens=getIntent().getStringExtra("news_contents");
        NewsContentFragment newsContentFragment =
                (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);

        newsContentFragment.refresh(newsTitle,newsContens);
    }
}
