package cn.ben.dropwizardrestapi;

import cn.ben.dropwizardrestapi.resources.FileResource;
import io.dropwizard.Application;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestApiApp extends Application<RestApiConfig> {

    public static void main(String[] args) throws Exception {
        new RestApiApp().run(args);
    }

    @Override
    public void run(RestApiConfig config, Environment env) {
        // Register resources
        env.jersey().register(FileResource.class);
    }

    @Override
    public void initialize(final Bootstrap<RestApiConfig> bootstrap) {
        super.initialize(bootstrap);

        bootstrap.addBundle(new MultiPartBundle());   // To support file upload with MULTIPART_FORM_DATA
    }
}