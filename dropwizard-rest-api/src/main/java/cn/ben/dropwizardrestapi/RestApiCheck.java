package cn.ben.dropwizardrestapi;
import com.codahale.metrics.health.HealthCheck;

public class RestApiCheck extends HealthCheck
{
    private final String version;

    public RestApiCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy("OK with version: " + this.version);
    }
}
