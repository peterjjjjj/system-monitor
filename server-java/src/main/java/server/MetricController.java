package server;

import model.SystemMetric;
import org.springframework.web.bind.annotation.*;

@RestController
//This class is to handle the page /metrics.
@RequestMapping("/metrics")
public class MetricController {

    @PostMapping
    public String receiveMetrics(@RequestBody SystemMetric metrics) {
        System.out.println("Received host" + metrics.getHostname() + '\n');
        System.out.println(metrics.toString());
        return "Success.";

    }
}
