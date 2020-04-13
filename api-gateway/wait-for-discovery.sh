#!/bin/sh

while ! nc -zv discovery-server 9091 ; do
    echo "Waiting for the Discovery Server to start..."
    sleep 5
done

echo "Discovery Server is up !"

echo "Starting api-gateway..."
java -jar api-gateway.1.0.0.jar