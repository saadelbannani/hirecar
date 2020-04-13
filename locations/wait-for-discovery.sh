#!/bin/sh

while ! nc -zv discovery-server 9091 ; do
    echo "Waiting for the Discovery Server to start..."
    sleep 5
done

echo "Discovery Server is up !"

echo "Starting locations-service..."
java -jar locations.1.1.1.jar