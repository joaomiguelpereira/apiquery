package eu.jpereira.ext.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.jpereira.ext.provider.model.Command;
import eu.jpereira.ext.provider.model.MovieQueryResult;
import eu.jpereira.ext.provider.model.QueryResult;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jpereira on 19/05/2016.
 */
public abstract class AbstractApiProvider implements ApiProvider {


    public static final String UTF_8 = "UTF-8";

    public AbstractApiProvider() {
    }

    protected MovieQueryResult callMovieApi(String api, String query) {


        HttpClient client = HttpClientBuilder.create().build();

        String body = getBody(api, query);

        try {
            HttpPost request = new HttpPost("http://localhost:8080/api/dummy/v.10/query");
            StringEntity params = new StringEntity(body);
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");
            request.setEntity(params);
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return handleResponse(response);

            } else {
                throw new ProviderException("Did not return data from the API");
            }


        } catch (Exception ex) {
            throw new ProviderException("Could not call End point, ", ex);
        }



    }

    /**
     * JSONify a command object
     * @param api
     * @param query
     * @return
     */
    private String getBody(String api, String query) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Command command = new Command(api, query);
        return gson.toJson(command);
    }

    private MovieQueryResult handleResponse(HttpResponse response) {

        InputStream responseIs = null;

        try {
            responseIs = response.getEntity().getContent();
        } catch (IOException e) {
            IOUtils.closeQuietly(responseIs);
            throw new ProviderException("Could not process response", e);
        }


        String theString;

        try {
            theString = IOUtils.toString(responseIs, UTF_8);
        } catch (IOException e) {
            IOUtils.closeQuietly(responseIs);
            throw new ProviderException("Could not process response", e);
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        MovieQueryResult result = gson.fromJson(theString, MovieQueryResult.class);
        return result;
    }
}
