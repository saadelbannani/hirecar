#!/bin/sh

while ! nc -zv discovery-server 9091 ; do
    echo "Waiting for the Discovery Server to start..."
    sleep 5
done

echo "Discovery Server is up !"

echo "Starting cars-service..."
java -jar cars.1.1.1.jar