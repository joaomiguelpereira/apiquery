package eu.jpereira.ext.printer;


import eu.jpereira.ext.query.QueryResult;

/**
 * Prints a result
 */
public interface QueryResultPrinter {

    void printResult(QueryResult result);
}
