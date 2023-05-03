#!/bin/bash

# TURKCELL TEST ORTAMI
# move jars local to 10.220.12.190
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/account-service/target/account-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/api-gateway-service/target/api-gateway-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/kafka-service/target/kafka-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/portal-service/target/portal-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/subscription-service/target/subscription-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/migration-service/target/migration-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
AFRpm522

scp -r /home/beyza/Desktop/dss-suit-backend/account-service/target/account-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /home/beyza/Desktop/dss-suit-backend/api-gateway-service/target/api-gateway-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /home/beyza/Desktop/dss-suit-backend/kafka-service/target/kafka-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /home/beyza/Desktop/dss-suit-backend/portal-service/target/portal-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /home/beyza/Desktop/dss-suit-backend/subscription-service/target/subscription-service-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/


scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/api-documentation/target/api-documentation-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar c0192102@10.220.12.190:/home/c0192102/suit/

scp -r /Users/bkocoglu/Desktop/suit-prod-v2/backend-v2.zip c0192102@10.220.12.190:/tmp
scp -r /Users/bkocoglu/Desktop/suit-prod-v2/frontend-v2.zip c0192102@10.220.12.190:/tmp

scp -r /Users/bkocoglu/Desktop/suit-prod-v3/backend-v3.zip c0192102@10.220.12.190:/tmp
scp -r /Users/bkocoglu/Desktop/suit-prod-v3/frontend-v3.zip c0192102@10.220.12.190:/tmp

#

scp -r /Users/bkocoglu/Documents/projects/omreon/dss-suit-frontend/build.zip c0192102@172.18.69.7:/home/c0192102/
scp -r /Users/bkocoglu/Documents/projects/omreon/dss-suit-frontend/build.zip c0192102@172.18.69.8:/home/c0192102/

# start jars in turkcell server
nohup /data01/java/bin/java -jar -Dspring.profiles.active=test -Dspring.sql.init.mode=never account-service-0.0.1-SNAPSHOT.jar &
nohup /data01/java/bin/java -jar -Dspring.profiles.active=test api-gateway-service-0.0.1-SNAPSHOT.jar &
nohup /data01/java/bin/java -jar -Dspring.profiles.active=test portal-service-0.0.1-SNAPSHOT.jar &
nohup /data01/java/bin/java -jar -Dspring.profiles.active=test subscription-service-0.0.1-SNAPSHOT.jar &
nohup /data01/java/bin/java -jar -Dspring.profiles.active=test kafka-service-0.0.1-SNAPSHOT.jar &
nohup /data01/java/bin/java -jar -Dspring.profiles.active=test migration-service-0.0.1-SNAPSHOT.jar &

nohup /data01/java/bin/java -jar eureka-server-0.0.1-SNAPSHOT.jar &
nohup /data01/java/bin/java -jar -Dspring.profiles.active=test api-documentation-0.0.1-SNAPSHOT.jar &
#

scp -r c0192102@10.220.12.190:/tmp/nohup.out /Users/bkocoglu/Desktop/suit-logs
scp -r c0192102@10.220.12.190:/tmp/21-03-2023.tar.gz /Users/bkocoglu/Desktop/suit-logs

/data01/java/bin/java --version

scp -r /Users/bkocoglu/Desktop/suit-example.xlsx c0192102@10.220.12.190:/home/c0192102/
scp -r /Users/bkocoglu/Desktop/suit-eula/v1.html c0192102@10.220.12.190:/home/c0192102/
scp -r /Users/bkocoglu/Downloads/create-account.html c0192102@10.220.12.190:/home/c0192102/
scp -r /Users/bkocoglu/Desktop/create-account-v2.html c0192102@10.220.12.190:/home/c0192102/

nohup /data01/java/bin/java -jar -Dserver.port=9070 -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=test /data01/suit/kafka-service-0.0.1-SNAPSHOT.jar --spring.config.location=/data01/suit/conf/kafka-service/ &
nohup /data01/java/bin/java -jar -Dserver.port=9071 -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=test /data01/suit/kafka-service-0.0.1-SNAPSHOT.jar --spring.config.location=/data01/suit/conf/kafka-service/ &


dzdo -iu wsadmin
AFRpm522
#move config files

scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/account-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/account-service/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/api-gateway-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/api-gateway-service/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/portal-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/portal-service/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/subscription-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/subscription-service/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/kafka-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/kafka-service/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/migration-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/migration-service/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/eureka-server/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/eureka-server/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/api-documentation/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/api-documentation/

scp -r /home/beyza/Desktop/dss-suit-backend/account-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/account-service/
scp -r /home/beyza/Desktop/dss-suit-backend/api-gateway-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/api-gateway-service/
scp -r /home/beyza/Desktop/dss-suit-backend/portal-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/portal-service/
scp -r /home/beyza/Desktop/dss-suit-backend/subscription-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/subscription-service/
scp -r /home/beyza/Desktop/dss-suit-backend/kafka-service/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/kafka-service/
scp -r /home/beyza/Desktop/dss-suit-backend/eureka-server/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/eureka-server/
scp -r /home/beyza/Desktop/dss-suit-backend/api-documentation/src/main/resources/config/* c0192102@10.220.12.190:/home/c0192102/suit/conf/api-documentation/

#

scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/ci-cd/server-restart-apps.sh c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/ci-cd/move-temp.sh c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/ci-cd/move-data01.sh c0192102@10.220.12.190:/tmp/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/ci-cd/copy-6-machine.sh c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/ci-cd/copy-9-machine.sh c0192102@10.220.12.190:/home/c0192102/suit/
scp -r /home/c0192102/suit/server-restart-apps.sh c0192102@10.220.15.6:/home/c0192102/suit/
scp -r /home/c0192102/suit/server-restart-apps.sh c0192102@10.220.15.9:/home/c0192102/suit/
scp -r /home/c0192102/suit/23-11-2022.zip c0192102@10.220.15.6:/tmp/
scp -r /home/c0192102/suit/23-11-2022.zip c0192102@10.220.15.9:/tmp/

scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/dml_versions/prod.v01.1-13/ddl.sql c0192102@10.220.12.190:/tmp/prod-v1
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/dml_versions/prod.v01.1-13/ddl-rollback.sql c0192102@10.220.12.190:/tmp/prod-v1
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/dml_versions/prod.v01.1-13/dml.sql c0192102@10.220.12.190:/tmp/prod-v1
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/dml_versions/prod.v01.1-13/dml-rollback.sql c0192102@10.220.12.190:/tmp/prod-v1
scp -r c0192102@10.220.12.190:/home/c0192102/suit/nohup.out /Users/bkocoglu/Desktop/
scp -r c0192102@10.220.12.190:/data01/logs/account-service.02-03-2023.log /Users/bkocoglu/Desktop/

-Dlogging.level.root=trace   -- logları debug modda görüntülemek için







# OMREON TEST ORTAMI
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/account-service/target/account-service-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/api-gateway-service/target/api-gateway-service-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/portal-service/target/portal-service-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /Users/bkocoglu/Documents/projects/omreon/suit-backend/subscription-service/target/subscription-service-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend


scp -r /home/beyza/Desktop/dss-suit-backend/account-service/target/account-service-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /home/beyza/Desktop/dss-suit-backend/api-gateway-service/target/api-gateway-service-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /home/beyza/Desktop/dss-suit-backend/api-documentation/target/api-documentation-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /home/beyza/Desktop/dss-suit-backend/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /home/beyza/Desktop/dss-suit-backend/portal-service/target/portal-service-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend
scp -r /home/beyza/Desktop/dss-suit-backend/subscription-service/target/subscription-service-0.0.1-SNAPSHOT.jar omreon@89.252.189.2:/home/omreon/project/suit/backend


nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' eureka-server-0.0.1-SNAPSHOT.jar &
nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.datasource.url='jdbc:postgresql://89.252.189.2:5432/tsabitpoc?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone='UTC+3'&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true' -Dspring.datasource.password='ENC(n7FSKIS+JdpJ2XBJSmLw6w==)' -Dspring.profiles.active=dev -Dspring.sql.init.mode=never account-service-0.0.1-SNAPSHOT.jar &
nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.datasource.url='jdbc:postgresql://89.252.189.2:5432/tsabitpoc?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone='UTC+3'&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true' -Dspring.datasource.password='ENC(n7FSKIS+JdpJ2XBJSmLw6w==)' -Dspring.profiles.active=dev api-gateway-service-0.0.1-SNAPSHOT.jar &
nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.datasource.url='jdbc:postgresql://89.252.189.2:5432/tsabitpoc?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone='UTC+3'&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true' -Dspring.datasource.password='ENC(n7FSKIS+JdpJ2XBJSmLw6w==)' -Dspring.profiles.active=dev portal-service-0.0.1-SNAPSHOT.jar &
nohup java -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.datasource.url='jdbc:postgresql://89.252.189.2:5432/tsabitpoc?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone='UTC+3'&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true' -Dspring.datasource.password='ENC(n7FSKIS+JdpJ2XBJSmLw6w==)' -Dspring.profiles.active=dev subscription-service-0.0.1-SNAPSHOT.jar &

ps aux | grep SNAPSHOT