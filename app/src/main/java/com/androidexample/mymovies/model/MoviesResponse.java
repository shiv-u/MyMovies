package com.androidexample.mymovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shivu on 04-04-2018.
 */

public class MoviesResponse {
    @SerializedName("page")
    private String page;
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public void setPage(String page) {
        this.page = page;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
