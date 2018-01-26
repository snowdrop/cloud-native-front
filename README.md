# cloud-native-front

## Run locally

- Clone the [backend](https://github.com/snowdrop/cloud-native-backend)
- Run the backend locally according to it's instructions
- Run this project by issuing
```bash
    $ mvn spring-boot:run
```

## Run on Openshift using Fabric8

- Run the [backend](https://github.com/snowdrop/cloud-native-backend) on Openshift following it's instructions
- Run this project by issuing
```bash
    $ mvn clean verify fabric8:deploy -Popenshift
```

## Deploy on Openshift

1. Create a new app on the cloud platform

```bash
oc new-app -f openshift/cloud-native-demo_front_template.yml
```

2. Start the build using project's source

```bash
oc start-build cloud-native-front-s2i --from-dir=. --follow
``` 

3. Wait till the pod is recreated and then test the service

```bash
export HOST=$(oc get route/cloud-native-front -o jsonpath='{.spec.host}')
open $HOST
```
