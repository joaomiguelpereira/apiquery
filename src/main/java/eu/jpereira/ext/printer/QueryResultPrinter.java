package eu.jpereira.ext.printer;


import eu.jpereira.ext.provider.model.MovieQueryResult;

/**
 * Prints a result
 */
public interface QueryResultPrinter {

    void printMoviesResult(MovieQueryResult result);
}
