#!/bin/bash

echo Enter packages file name :

read packageFolderName

mkdir $packageFolderName

cd $packageFolderName

packagePath=$(pwd)

echo $packagePath

echo 'Enter project base path (example : /Users/bkocoglu/Documents/projects/omreon/suit-backend ) : '

read projectBasePath

echo 'Are you deploy account service ? (y / n)'

read isAccountDeploy

echo 'Are you deploy api documentation service ? (y / n)'

read isApiDocumentationDeploy

echo 'Are you deploy api gateway service ? (y / n)'

read isApiGatewayDeploy

echo 'Are you deploy eureka server ? (y / n)'

read isEurekaServerDeploy

echo 'Are you deploy kafka service ? (y / n)'

read isKafkaServiceDeploy

echo 'Are you deploy portal service ? (y / n)'

read isPortalServiceDeploy

echo 'Are you deploy subscription service ? (y / n)'

read isSubscriptionServiceDeploy

if [[ "$isAccountDeploy" = "y" ]] ; then
  cp -R $projectBasePath/account-service/target/account-service-0.0.1-SNAPSHOT.jar $packagePath
fi

if [[ "$isApiDocumentationDeploy" = "y" ]] ; then
  cp -R $projectBasePath/api-documentation/target/api-documentation-0.0.1-SNAPSHOT.jar $packagePath
fi

if [[ "$isApiGatewayDeploy" = "y" ]] ; then
  cp -R $projectBasePath/api-gateway-service/target/api-gateway-service-0.0.1-SNAPSHOT.jar $packagePath
fi

if [[ "$isEurekaServerDeploy" = "y" ]] ; then
  cp -R $projectBasePath/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar $packagePath
fi

if [[ "$isKafkaServiceDeploy" = "y" ]] ; then
  cp -R $projectBasePath/kafka-service/target/kafka-service-0.0.1-SNAPSHOT.jar $packagePath
fi

if [[ "$isPortalServiceDeploy" = "y" ]] ; then
  cp -R $projectBasePath/portal-service/target/portal-service-0.0.1-SNAPSHOT.jar $packagePath
fi

if [[ "$isSubscriptionServiceDeploy" = "y" ]] ; then
  cp -R $projectBasePath/subscription-service/target/subscription-service-0.0.1-SNAPSHOT.jar $packagePath
fi

cd $packagePath

cd ..

zip -r $packageFolderName.zip $packageFolderName

scp -r -p AXXab478 $packageFolderName.zip c0192102@10.220.15.5:/home/c0192102/suit/

