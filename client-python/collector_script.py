import socket
import psutil
import time
import json

def collect_system_data() -> dict:
    """
    Collect system metrics.
    """

    #Get CPU usage.
    cpu_usage = psutil.cpu_percent(interval=1)

    #Get memory data.
    memory = psutil.virtual_memory()

    memory_total = round(memory.total / (1024 ** 3), 2)
    memory_available = round(memory.available / (1024 ** 3), 2)
    memory_used = round(memory.used / (1024 ** 3), 2)
    memory_percentage = memory.percent

    #Generate timestamp
    timestamp = int(time.time())

    #Get hostname.
    hostname = socket.gethostname()

    #Convert data into dict.
    system_data = {
        'hostname': hostname,
        'cpu_usage': cpu_usage,
        'timestamp': timestamp,
        'memory_total': memory_total,
        'memory_available': memory_available,
        'memory_used': memory_used,
        'memory_percentage': memory_percentage,
    }

    return system_data

if __name__ == '__main__':
    print(collect_system_data())
