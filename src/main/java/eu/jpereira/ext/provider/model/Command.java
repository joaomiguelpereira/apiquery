package eu.jpereira.ext.provider.model;

/**
 * Created by jpereira on 19/05/2016.
 */
public class Command {
    private final String api;
    private final String query;



    public Command(String api, String query) {
        this.api = api;
        this.query = query;

    }

    public String getApi() {
        return api;
    }

    public String getQuery() {
        return query;
    }
}
