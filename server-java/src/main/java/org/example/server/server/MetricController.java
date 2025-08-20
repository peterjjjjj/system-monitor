package org.example.server.server;

import org.example.server.model.SystemMetric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//This class is to handle the page /metrics.
@RequestMapping("/metrics")
public class MetricController {

    private final SystemMetricRepository systemMetricRepository;

    @Autowired
    public MetricController(SystemMetricRepository systemMetricRepository) {
        this.systemMetricRepository = systemMetricRepository;

    }

    @PostMapping
    public String receiveMetrics(@RequestBody SystemMetric metric) {
        System.out.println("Received host" + metric.getHostname() + '\n');
        System.out.println(metric.toString());

        systemMetricRepository.save(metric);
        System.out.println("Saved host" + metric.getHostname() + '\n');

        return "Success.";
    }

    @GetMapping
    public List<SystemMetric> getMetrics() {
        System.out.println("Get metrics from repository.");
        return systemMetricRepository.findAll();
    }


}

