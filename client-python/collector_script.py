import socket
import psutil
import time
import json
import requests

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

def send_metrics(system_data: dict, server_url: str) -> None:
    """
    Send metrics to server.

    :param system_data:
    :param server_url:
    :return: None
    """

    try:
        response = requests.post(server_url, json=system_data)
        response.raise_for_status()
        print('Successfully sent metrics to server')
    except requests.exceptions.RequestException as e:
        print(f"ERROR: Failed to send metrics to {server_url}. {e}")



if __name__ == '__main__':
    SERVER_URL = "http://localhost:8080/metrics"
    COLLECTION_INTERVAL_SECONDS = 5

    while True:
        system_data = collect_system_data()
        print(system_data)

        send_metrics(system_data, SERVER_URL)
        print("Data sent to url.")

        #Wait for 5 seconds.
        time.sleep(COLLECTION_INTERVAL_SECONDS)
