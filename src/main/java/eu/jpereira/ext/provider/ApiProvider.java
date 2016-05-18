package eu.jpereira.ext.provider;


import eu.jpereira.ext.query.QueryResult;

public interface ApiProvider {

    /**
     * Check if the prvider can implement the API provided as param
     * @param api the name of the api
     * @return true if yes, false if no
     */
    boolean implementsApi(String api);

    /**
     * Execute a query
     * @param query
     * @return
     */
    QueryResult executeQuery(String query);
}
