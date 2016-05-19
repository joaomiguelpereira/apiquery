package eu.jpereira.ext.provider.rottentomatoes;

import eu.jpereira.ext.provider.AbstractApiProvider;
import eu.jpereira.ext.provider.model.MovieQueryResult;
import org.springframework.stereotype.Component;

/**
 * Created by jpereira on 18/05/2016.
 */
@Component
public class RTProvider extends AbstractApiProvider {

    private static final String ROTTEN_TOMATOES = "rt";


    @Override
    public boolean implementsApi(String api) {
        return ROTTEN_TOMATOES.equals(api);
    }

    @Override
    public MovieQueryResult executeMovieQuery(String query) {
        //Dummy call to some WEB API, without any authorization code or whatsoever
        return callMovieApi(ROTTEN_TOMATOES, query);
    }

}
