package eu.jpereira.ext.provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ApiProviderFactory {


    //Con: Will load all providers even if they will not be used
    @Autowired
    private List<ApiProvider> avaiableProviders;

    /**
     * Find the provider for a given api
     * @param api the api name
     * @return optionally, the ApiProvider
     */
    public Optional<ApiProvider> getApiProvider(String api) {

        for (ApiProvider provider : avaiableProviders ) {
            if (provider.implementsApi(api)) {
                return Optional.of(provider);
            }
        }
        return Optional.empty();
    }
}
