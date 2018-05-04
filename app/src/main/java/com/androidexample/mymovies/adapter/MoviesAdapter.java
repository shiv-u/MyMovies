package com.androidexample.mymovies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidexample.mymovies.DetailActivity;
import com.androidexample.mymovies.R;
import com.androidexample.mymovies.model.Movie;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * Created by shivu on 04-04-2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder>{
    private Context mContext;
    private List<Movie> movieList;
    public MoviesAdapter(Context mContext,List<Movie> movieList)
    {
        this.mContext=mContext;
        this.movieList=movieList;
    }
    @Override
    public  MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup,int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_card,viewGroup,false);
        return new MyViewHolder(view);

    }
    @Override
    public void onBindViewHolder(final MoviesAdapter.MyViewHolder viewHolder,int i)
    {
        viewHolder.title.setText(movieList.get(i).getOriginalTitle());
        String vote = Double.toString(movieList.get(i).getVoteAverage());
        viewHolder.userrating.setText(vote);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.loading);
        Glide.with(mContext)
                .load(movieList.get(i).getPosterPath())
                .apply(requestOptions)
                .into(viewHolder.thumnail);


    }
    @Override
    public int getItemCount()
    {
        return movieList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView userrating,title;
        public ImageView thumnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movietitle);
            userrating=itemView.findViewById(R.id.userrating);
            thumnail=itemView.findViewById(R.id.thumbnail);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view)
                {
                    int pos = getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION)
                    {
                        Movie clickedDataItem = movieList.get(pos);
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        intent.putExtra("original_title",movieList.get(pos).getOriginalTitle());
                        intent.putExtra("poster_path",movieList.get(pos).getPosterPath());
                        intent.putExtra("overview",movieList.get(pos).getOverview());
                        intent.putExtra("vote_average",Double.toString(movieList.get(pos).getVoteAverage()));
                        intent.putExtra("release_date",movieList.get(pos).getReleaseDate());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(view.getContext(),"You Clicked"+clickedDataItem.getOriginalTitle(),Toast.LENGTH_SHORT).show();





                    }
                }
            });
        }
    }
}
