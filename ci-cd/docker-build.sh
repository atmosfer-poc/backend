#!/bin/bash

set -e

cd `dirname $0`
r=`pwd`
echo $r

# build
cd $r/../
mvn clean install -DskipTests

# eureka-server
cd $r/../eureka-server
echo -e "\n"
echo -e "eureka-server"
docker build -t eureka-server -f Dockerfile .

# api-gateway-service
cd $r/../api-gateway-service
echo -e "\n"
echo -e "api-gateway-service"
docker build -t api-gateway-service -f Dockerfile .

# account-service
cd $r/../account-service
echo -e "\n"
echo -e "account-service"
docker build -t account-service -f Dockerfile .

# api-documentation
cd $r/../api-documentation
echo -e "\n"
echo -e "api-documentation"
docker build -t api-documentation -f Dockerfile .

# product-service
cd $r/../product-service
echo -e "\n"
echo -e "product-service"
docker build -t product-service -f Dockerfile .

#Todo: log service
