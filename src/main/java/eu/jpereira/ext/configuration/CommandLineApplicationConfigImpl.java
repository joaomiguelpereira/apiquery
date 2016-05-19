package eu.jpereira.ext.configuration;


import eu.jpereira.ext.configuration.reader.SystemPropertiesQueryExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CommandLineApplicationConfigImpl implements CommandLineApplicationConfig {


    @Autowired
    private SystemPropertiesQueryExtractor systemPropertiesQueryExtractor;
    private String api;
    private String query;

    @PostConstruct
    public void loadConfiguration() {
        this.api = systemPropertiesQueryExtractor.readApi();
        this.query = systemPropertiesQueryExtractor.readQuery();
    }

    /**
     * @inheritDoc
     */

    @Override
    public String getApi() {
        return this.api;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getQuery() {
        return this.query;
    }
}
