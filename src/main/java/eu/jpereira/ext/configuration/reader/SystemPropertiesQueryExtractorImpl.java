package eu.jpereira.ext.configuration.reader;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SystemPropertiesQueryExtractorImpl implements SystemPropertiesQueryExtractor {


    public static final String API_PARAM_NAME = "api";
    public static final String MOVIE = "movie";
    public static final String ALBUM = "album";

    /**
     * @inheritDoc
     *
     * Will read the api from system properties or return null if not present or the value is not present
     */
    @Override
    public String readApi() {

        String api = System.getProperty(API_PARAM_NAME);
        boolean present = !StringUtils.isEmpty(api);

        return present?api:null;
    }

    /**
     * @inheritDoc Will "guess" the query by trying either movie or album. If you provide -Dmovie="abc" and -Dalbum="abcd"
     * album will be ignored
     */
    @Override
    public String readQuery() {

        String movie = System.getProperty(MOVIE);
        String album = System.getProperty(ALBUM);


        if (!StringUtils.isEmpty(movie) && !StringUtils.isEmpty(album)) {
            throw new IllegalArgumentException("Provide either movie or album, but not both");
        }

        if (!StringUtils.isEmpty(movie)) {
            return encodeMovie(movie);
        }

        if (!StringUtils.isEmpty(album)) {
            return encodeAlbum(album);
        }
        //Is nothing else was provided
        return null;
    }

    private String encodeAlbum(String albumValue) {
        return new StringBuilder(ALBUM).append("=").append(albumValue).toString();

    }

    private String encodeMovie(String movieValue) {
        return new StringBuilder(MOVIE).append("=").append(movieValue).toString();
    }
}
