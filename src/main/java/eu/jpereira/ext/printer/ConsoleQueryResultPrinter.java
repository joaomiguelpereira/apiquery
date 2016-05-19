package eu.jpereira.ext.printer;

import eu.jpereira.ext.provider.model.Movie;
import eu.jpereira.ext.provider.model.MovieQueryResult;
import eu.jpereira.ext.provider.model.QueryResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Prints in the console
 */
@Component
public class ConsoleQueryResultPrinter implements QueryResultPrinter {


    /**
     * Simple implementation only prints movies
     *
     * @param result
     */
    @Override
    public void printMoviesResult(MovieQueryResult result) {

        final StringBuilder stringBuilder = new StringBuilder();

        List<Movie> data = result.getData();
        data.stream().forEach(entry -> {
            stringBuilder.append(entry.getTitle()).append("     ");
            stringBuilder.append(entry.getDirector()).append("     ");
            stringBuilder.append(entry.getYear());
            stringBuilder.append("\n");


        });
        System.out.println(stringBuilder.toString());

    }
}
