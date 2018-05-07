# Cloud Native Frontend

Frontend application accessing the Cloud Native [backend](git clone https://github.com/snowdrop/cloud-native-backend.git)

## Run locally the Spring Boot Backend application

- Clone the [backend](https://github.com/snowdrop/cloud-native-backend)
- Run the backend locally according to it's instructions
```bash
$ mvn clean spring-boot:run -Dspring.profiles.active=local -Ph2
```
- The application will be available at `http://localhost:8090`

## Deploy on OpenShift

1. Create a new app on the cloud platform

```bash
oc new-app -f openshift/cloud-native-demo_frontend_template.yml
```

2. Start the build using project's source

```bash
oc start-build cloud-native-front-s2i --from-dir=. --follow
``` 

3. Wait until the pod is created and then open the app in the browser

```bash
export HOST=$(oc get route/cloud-native-front -o jsonpath='{.spec.host}')
open $HOST
```

## Run on OpenShift using Fabric8

During the development stage in order to get very quick feedback, the Fabric8 Maven plugin can be 
used to deploy the application to the cluster. The following instructions specify the details  

- Run the [backend](https://github.com/snowdrop/cloud-native-backend) on OpenShift following it's instructions
- Run this project by issuing
```bash
    $ mvn clean verify fabric8:deploy -Popenshift
```
- The app will be available at the address returned by `$(oc get route/cloud-native-front -o jsonpath='{.spec.host}')`
