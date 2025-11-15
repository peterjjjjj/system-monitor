package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class SystemMetric {
    //Jason format metric.
    @JsonProperty("hostname")
    private String hostname;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("cpu_usage")
    private double cpuUsage;

    @JsonProperty("memory_total")
    private double memoryTotal;

    @JsonProperty("memory_available")
    private double memoryAvailable;

    @JsonProperty("memory_used")
    private double memoryUsed;

    @JsonProperty("memory_percentage")
    private double memoryPercentage;

    public SystemMetric() {}

    public SystemMetric(String hostname,
                        double cpuUsage,
                        long timestamp,
                        double memoryTotal,
                        double memoryAvailable,
                        double memoryUsed,
                        double memoryPercentage) {
        this.hostname = hostname;
        this.cpuUsage = cpuUsage;
        this.timestamp = timestamp;
        this.memoryTotal = memoryTotal;
        this.memoryAvailable = memoryAvailable;
        this.memoryUsed = memoryUsed;
        this.memoryPercentage = memoryPercentage;
    }

    public String getHostname() { return hostname; }
    public void setHostname(String hostname) { this.hostname = hostname; }

    public double getCpuUsage() { return cpuUsage; }
    public void setCpuUsage(double cpuUsage) { this.cpuUsage = cpuUsage; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public double getMemoryTotal() { return memoryTotal; }
    public void setMemoryTotal(double memoryTotal) { this.memoryTotal = memoryTotal; }

    public double getMemoryAvailable() { return memoryAvailable; }
    public void setMemoryAvailable(double memoryAvailable) { this.memoryAvailable = memoryAvailable; }

    public double getMemoryUsed() { return memoryUsed; }
    public void setMemoryUsed(double memoryUsed) { this.memoryUsed = memoryUsed; }

    public double getMemoryPercentage() { return memoryPercentage; }
    public void setMemoryPercentage(double memoryPercentage) { this.memoryPercentage = memoryPercentage; }

    @Override
    public String toString() {
        return "SystemMetric{" +
                "hostname='" + hostname + '\'' +
                ", timestamp=" + timestamp +
                ", cpuUsage=" + cpuUsage +
                ", memoryTotal=" + memoryTotal +
                ", memoryAvailable=" + memoryAvailable +
                ", memoryUsed=" + memoryUsed +
                ", memoryPercentage=" + memoryPercentage +
                '}';
    }

}
