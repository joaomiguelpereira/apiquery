package eu.jpereira.ext.configuration.reader;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jpereira on 18/05/2016.
 */
public class SystemPropertiesQueryExtractorImplTest {


    public static final String SOMEAPI = "someapi";
    public static final String DUMMY = "dummy";
    public static final String MOVIE = "movie";
    public static final String ALBUM = "album";
    private SystemPropertiesQueryExtractor systemPropertiesQueryExtractor;


    @Before
    public void setup() {
        systemPropertiesQueryExtractor = new SystemPropertiesQueryExtractorImpl();
        //Not the best way to do it because the ci process may set some system properties and this will clean everything... not sure to review
        System.getProperties().clear();
    }

    @Test
    public void shouldReturnNullQueryAndNullApi() {
        String api = systemPropertiesQueryExtractor.readApi();
        Assertions.assertThat(api).isNull();
        String query = systemPropertiesQueryExtractor.readQuery();
        Assertions.assertThat(query).isNull();
    }

    @Test
    public void shouldReturnCorrectApi() {
        System.getProperties().put("api", SOMEAPI);
        String api = systemPropertiesQueryExtractor.readApi();
        Assertions.assertThat(api).isEqualTo(SOMEAPI);
    }

    @Test
    public void shouldReturnEmptyQuery() {

        System.getProperties().put("movie", "");
        String query = systemPropertiesQueryExtractor.readQuery();
        Assertions.assertThat(query).isNull();

        System.getProperties().put("album", "");
        query = systemPropertiesQueryExtractor.readQuery();
        Assertions.assertThat(query).isNull();

    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfProvideBothMovieAndAlbum() {
        System.getProperties().put(MOVIE, DUMMY);
        System.getProperties().put(ALBUM, DUMMY);
        systemPropertiesQueryExtractor.readQuery();
    }


    @Test
    public void shouldReadMovie() {
        System.getProperties().put(MOVIE, DUMMY);
        String query = systemPropertiesQueryExtractor.readQuery();
        Assertions.assertThat(query).isEqualTo(MOVIE + "=" + DUMMY);
    }

    @Test
    public void shouldReadAlbum() {
        System.getProperties().put(ALBUM, DUMMY);
        String query = systemPropertiesQueryExtractor.readQuery();
        Assertions.assertThat(query).isEqualTo(ALBUM+"="+DUMMY);
    }

}