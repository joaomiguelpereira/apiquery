package eu.jpereira.ext.provider.model;

import java.util.List;

/**
 * Created by jpereira on 19/05/2016.
 */
public class MovieQueryResult implements QueryResult<Movie>{


    private List<Movie> data;

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }

}
