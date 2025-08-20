package org.example.server.server;

import org.example.server.model.SystemMetric;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SystemMetricRepository {

    private final List<SystemMetric> systemMetrics = new ArrayList<>();

    public void save(SystemMetric systemMetric) {
        systemMetrics.add(systemMetric);
        System.out.println("System metric saved.");
    }

    public List<SystemMetric> findAll() {
        //Return all the stored metrics.
        return new ArrayList<>(systemMetrics);
    }


}
