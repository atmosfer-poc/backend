#!/bin/bash

echo 'Jar ların klasörün path ini giriniz (örn : /data01/suit) : '

read jarfolder

echo 'Konfigürasyon dosyalarının bulunduğu path i giriniz (örn : /data01/suit/conf) : '

read configFolder

echo 'Profil (test / prp / prod) : '

read profile

echo 'Java path (örn : /data01/java/bin/java) : '

read javaPath

pkill -9 -e -f 'SNAPSHOT'

echo 'Servisler durduruldu.'

nohup $javaPath -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=$profile -Dspring.sql.init.mode=never $jarfolder/account-service-0.0.1-SNAPSHOT.jar --spring.config.location=$configFolder/account-service/ &
nohup $javaPath -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=$profile $jarfolder/api-gateway-service-0.0.1-SNAPSHOT.jar --spring.config.location=$configFolder/api-gateway-service/ &
nohup $javaPath -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=$profile $jarfolder/portal-service-0.0.1-SNAPSHOT.jar --spring.config.location=$configFolder/portal-service/ &
nohup $javaPath -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=$profile $jarfolder/subscription-service-0.0.1-SNAPSHOT.jar --spring.config.location=$configFolder/subscription-service/ &
nohup $javaPath -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=$profile $jarfolder/kafka-service-0.0.1-SNAPSHOT.jar --spring.config.location=$configFolder/kafka-service/ &
nohup $javaPath -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=$profile $jarfolder/migration-service-0.0.1-SNAPSHOT.jar --spring.config.location=$configFolder/migration-service/ &
nohup $javaPath -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' $jarfolder/eureka-server-0.0.1-SNAPSHOT.jar --spring.config.location=$configFolder/eureka-server/ &
nohup $javaPath -jar -Djasypt.encryptor.password='5gArdh@8$0Z2' -Dspring.profiles.active=$profile $jarfolder/api-documentation-0.0.1-SNAPSHOT.jar --spring.config.location=$configFolder/api-documentation/ &

echo 'Servisler başlatıldı, sistem yaklaşık 5dk. içinde erişilebilir hale gelecektir...'


