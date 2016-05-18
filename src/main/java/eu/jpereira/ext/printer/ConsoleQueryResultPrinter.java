package eu.jpereira.ext.printer;

import eu.jpereira.ext.query.QueryResult;
import org.springframework.stereotype.Component;

/**
 * Prints in the console
 */
@Component
public class ConsoleQueryResultPrinter implements QueryResultPrinter {
    @Override
    public void printResult(QueryResult result) {

    }
}
