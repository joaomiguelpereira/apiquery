package eu.jpereira.ext.configuration.reader;


/**
 * This interface will retrieve the api name and query from the system properties.
 * use : -Dapi=imdb ­Dmovie="Indiana Jones"
 */
public interface SystemPropertiesQueryExtractor {


    /**
     * Read the api from the System Properties
     * @return the api value or null if none or invalid
     */
    String readApi();


    /**
     * Read the query from the System Properties.
     *
     * @return the query or null if none or invalid.
     */
    String readQuery();
}
