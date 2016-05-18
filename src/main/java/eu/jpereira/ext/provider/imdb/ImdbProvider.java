package eu.jpereira.ext.provider.imdb;

import eu.jpereira.ext.NotImementedException;
import eu.jpereira.ext.provider.ApiProvider;
import eu.jpereira.ext.query.QueryResult;
import org.springframework.stereotype.Component;

/**
 * Implementation of IMDB API
 */

@Component
public class ImdbProvider implements ApiProvider {


    private static final String API_NAME = "imdb";

    @Override
    public boolean implementsApi(String api) {
        return API_NAME.equals(api);
    }

    @Override
    public QueryResult executeQuery(String query) {
        throw new NotImementedException("The IMDB does not provide a public API. Will need to investigate the undocumented API. See http://stackoverflow.com/questions/1966503/does-imdb-provide-an-api");

    }
}
