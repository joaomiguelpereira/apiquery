package eu.jpereira.ext.provider.model;

import java.util.List;

/**
 * Created by jpereira on 18/05/2016.
 */
public interface QueryResult<T> {

    List<T> getData();

    void setData(List<T> data);
}
