package eu.jpereira.ext.provider.rottentomatoes;

import eu.jpereira.ext.NotImementedException;
import eu.jpereira.ext.provider.ApiProvider;
import eu.jpereira.ext.query.QueryResult;
import org.springframework.stereotype.Component;

/**
 * Created by jpereira on 18/05/2016.
 */
@Component
public class RTProvider implements ApiProvider {

    private static final String ROTTEN_TOMATOES = "rt";


    @Override
    public boolean implementsApi(String api) {
        return ROTTEN_TOMATOES.equals(api);
    }

    @Override
    public QueryResult executeQuery(String query) {
        throw new NotImementedException("Not implemented. Requires creating a new Account on rotten tomatoes");
    }
}
