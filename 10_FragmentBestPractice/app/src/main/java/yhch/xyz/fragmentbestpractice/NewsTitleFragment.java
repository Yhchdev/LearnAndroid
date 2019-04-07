package yhch.xyz.fragmentbestpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {
    private boolean isTwPane;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        RecyclerView NewsTitlereView = view.findViewById(R.id.news_title_recycler);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        NewsTitlereView.setLayoutManager(lm);
        NewsAdapter adapter = new NewsAdapter(getNews());
        NewsTitlereView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        for(int i=1;i<151;i++){
            News news = new News();
            news.setTitle("this is news title"+ i);
            news.setContent(getRandomLengthContent("this is new content" +i+"."));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String s) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<length;i++){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content)!=null){
            isTwPane = true; //是双页模式
        }else {
            isTwPane = false; //是单页模式
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHodle>{
        private List<News> mNewsList;

        @NonNull
        @Override
        public ViewHodle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.news_item,parent,false
            );
            final RecyclerView.ViewHolder holder = new ViewHodle(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());

                    if(isTwPane){
                        //双页模式刷新碎片中的内容
                        NewsContentFragment newsContentFragment =
                                (NewsContentFragment) getFragmentManager().findFragmentById(
                                        R.id.news_content_fragment);
                        newsContentFragment.refresh(
                                news.getTitle(),news.getContent()
                        );
                    }else {
                        //单页模式直接启动NewsContentActivity
                        NewsContentActivity.actionStart(
                                getActivity(),news.getTitle(),news.getContent());
                    };
                }
            });
            return (ViewHodle) holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHodle holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHodle extends RecyclerView.ViewHolder{
            TextView newsTitleText;

            public ViewHodle(View view) {
                super(view);
                newsTitleText = view.findViewById(R.id.news_title);
            }
        }

        public NewsAdapter(List<News> newsList){
            mNewsList = newsList;
        }
    }
}
