#!/bin/bash
cd <path>
git pull
mvn deploy
docker stop pcbuilder-backend
docker build -t pcbuilder/backend .
docker run --name "pcbuilder-backend" -d -p 8090:8090 -t pcbuilder/backend --link pcbuilder-mysql:mysql
