#!/bin/bash

# OMREON TEST ORTAMI
scp -r /Users/bkocoglu/Documents/projects/omreon/atmosfer-poc/backend/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar omreon@185.126.217.205:/home/omreon/project/atmosfer-poc/backend
scp -r /Users/bkocoglu/Documents/projects/omreon/atmosfer-poc/backend/account-service/target/account-service-0.0.1-SNAPSHOT.jar omreon@185.126.217.205:/home/omreon/project/atmosfer-poc/backend
scp -r /Users/bkocoglu/Documents/projects/omreon/atmosfer-poc/backend/api-gateway-service/target/api-gateway-service-0.0.1-SNAPSHOT.jar omreon@185.126.217.205:/home/omreon/project/atmosfer-poc/backend
scp -r /Users/bkocoglu/Documents/projects/omreon/atmosfer-poc/backend/advertisement-service/target/advertisement-service-0.0.1-SNAPSHOT.jar omreon@185.126.217.205:/home/omreon/project/atmosfer-poc/backend
scp -r /Users/bkocoglu/Documents/projects/omreon/atmosfer-poc/backend/application-service/target/application-service-0.0.1-SNAPSHOT.jar omreon@185.126.217.205:/home/omreon/project/atmosfer-poc/backend

nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' eureka-server-0.0.1-SNAPSHOT.jar &
nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dfile.path='/home/omreon/project/atmosfer-poc/files' -Dspring.profiles.active=dev account-service-0.0.1-SNAPSHOT.jar &
nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dfile.path='/home/omreon/project/atmosfer-poc/files' -Dspring.profiles.active=dev api-gateway-service-0.0.1-SNAPSHOT.jar &
nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dfile.path='/home/omreon/project/atmosfer-poc/files' -Dspring.profiles.active=dev advertisement-service-0.0.1-SNAPSHOT.jar &
nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dfile.path='/home/omreon/project/atmosfer-poc/files' -Dspring.profiles.active=dev application-service-0.0.1-SNAPSHOT.jar &

ps aux | grep SNAPSHOT
