package cn.ben.dropwizardrestapi;

import cn.ben.dropwizardrestapi.resources.FileResource;
import io.dropwizard.Application;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class RestApiApp extends Application<RestApiConfig> {

    public static void main(String[] args) throws Exception {
        new RestApiApp().run(args);
    }

    @Override
    public void run(RestApiConfig config, Environment env) {
        final FilterRegistration.Dynamic cors =
            env.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");


        // Register resources
        env.jersey().register(FileResource.class);
    }

    @Override
    public void initialize(final Bootstrap<RestApiConfig> bootstrap) {
        super.initialize(bootstrap);

        bootstrap.addBundle(new MultiPartBundle());   // To support file upload with MULTIPART_FORM_DATA
    }
}