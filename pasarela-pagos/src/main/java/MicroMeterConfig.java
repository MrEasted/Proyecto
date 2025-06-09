import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;

import io.micrometer.influx.InfluxMeterRegistry;
import io.micrometer.influx.InfluxConfig;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;


@ApplicationScoped
public class MicroMeterConfig {


    private MeterRegistry meterRegistry;


    @PostConstruct
    public void init() {
        InfluxConfig config = new InfluxConfig() {
            @Override
            public String get(String k) {
                return null; // valores por defecto
            }

            @Override
            public String uri() {
                return "http://localhost:8086"; // Aca hay que poner la conexion con la base de datos
            }

            @Override
            public String db() {
                return "BaseDatos_PasarelaPagos";
            }

            @Override
            public String userName() {
                return "root";
            }

            @Override
            public String password() {
                return "root";
            }
        };


        meterRegistry = new InfluxMeterRegistry(config, Clock.SYSTEM);
    }

    @Produces
    public MeterRegistry getMeterRegistry() {
        return meterRegistry;
    }
}
