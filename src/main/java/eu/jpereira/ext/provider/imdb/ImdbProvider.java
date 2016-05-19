package eu.jpereira.ext.provider.imdb;

import eu.jpereira.ext.provider.AbstractApiProvider;
import eu.jpereira.ext.provider.model.MovieQueryResult;
import org.springframework.stereotype.Component;

/**
 * Implementation of IMDB API
 */

@Component
public class ImdbProvider extends AbstractApiProvider {


    private static final String API_NAME = "imdb";

    @Override
    public boolean implementsApi(String api) {
        return API_NAME.equals(api);
    }

    @Override
    public MovieQueryResult executeMovieQuery(String query) {
        //Dummy call to some WEB API, without any authorization code or whatsoever
        return callMovieApi(API_NAME, query);

    }
}
