# cloud-native-front

## Run locally

- Clone the [backend](https://github.com/snowdrop/cloud-native-backend)
- Run the backend locally according to it's instructions
- Run this project by issuing
```bash
    $ mvn spring-boot:run
```

## Run on Openshift

- Run the [backend](https://github.com/snowdrop/cloud-native-backend) on Openshift following it's instructions
- Run this project by issuing
```bash
    $ mvn clean verify fabric8:deploy -Popenshift
```
