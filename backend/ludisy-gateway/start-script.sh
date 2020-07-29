#!/bin/bash

cd /home/pi/ludisy/microservice-template/backend/ludisy-gateway
./gradlew bootRun > /home/pi/ludisy/startup.log 2>&1 &
