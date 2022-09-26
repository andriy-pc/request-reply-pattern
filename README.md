# Request-reply pattern in event-driven architecture

## Primitive implementation of request-reply pattern
`Order service` request shipping from the `shipping service`. Then shipping service responds whether this shipping request was satisfied.
Kafka is used as message broker.

### Bootstrap
Too bootstrap project you need to build both projects with `Maven`: 
   
    mvn clean package spring-boot:repackage

start kafka with `Docker compose` in detached mode:

    docker-compose up -d

run shipment service:

    java -jar ./shipment-service/target/shipment-service-0.0.1-SNAPSHOT.jar 

run order service:

    java -jar ./order-service/target/order-service-0.0.1-SNAPSHOT.jar

**Note:** services bootstrap order doesn't matter. Both services have logic to create topics. 

### How to use
Basically you have only two available HTTP requests:

This one returns information about order

    curl --location --request GET 'http://localhost:6050/orders-service/114-14345-12'

This one starts request-reply pattern

    curl --location --request PATCH 'http://localhost:6050/orders-service/ship/114-14345-12'

After you execute this request - status of the order is changed to `SHIPPING_REQUESTED`. After `order service` received response
from `shipment service` - status is changed to what `shipment service` returned.
`Shipment service` randomly decides if order is `SHIPPING` or `SHIPPING_REJECTED` and responds to the `Order service`

