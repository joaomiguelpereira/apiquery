package eu.jpereira.ext;


import eu.jpereira.ext.configuration.CommandLineApplicationConfig;
import eu.jpereira.ext.printer.QueryResultPrinter;
import eu.jpereira.ext.provider.ApiProvider;
import eu.jpereira.ext.provider.ApiProviderFactory;
import eu.jpereira.ext.query.QueryResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class CommandLineApplication implements CommandLineRunner {


    @Autowired
    private ApiProviderFactory apiProviderFactory;

    @Autowired
    private CommandLineApplicationConfig commandLineApplicationConfig;

    @Autowired
    private QueryResultPrinter queryResultPrinter;

    public static void main(String[] args) {
        SpringApplication.run(CommandLineApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        //Get Configuration. It could have been through arguments, but the exercise allows to be this way.
        String api = commandLineApplicationConfig.getApi();
        String query = commandLineApplicationConfig.getQuery();

        //Could look for default in the config file thought, but if any is null at this point, just fail
        if (StringUtils.isEmpty(api) || StringUtils.isEmpty(query)) {
            printHelp();
            return;
        }

        Optional<ApiProvider> provider = apiProviderFactory.getApiProvider(api);

        if (provider.isPresent()) {
            QueryResult result = provider.get().executeQuery(query);
            queryResultPrinter.printResult(result);
        } else {
            printHelp();
        }
    }

    private void printHelp() {
        System.out.println("Please define systems properties: \n");
        System.out.println("api=\"name of the api\" \n");
        System.out.println("[movie=\"title of the movie\"] \n");
        System.out.println("[album=\"title of the album\"] \n");
        System.out.println("Provide one of: album or movie\n");
        System.out.println("Example: -Dapi=imdb -Dmovie=\"Indiana Jones\"\n");
        System.out.println("Example 2: -Dapi=rt -Dmovie=\"Indiana Jones\"\n");
        System.out.println("Available APIS: imdb, rt (rotten tomatoes)");




    }
}
