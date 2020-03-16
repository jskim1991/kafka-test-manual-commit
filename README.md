
# How to start and test
1. Start Zookeeper
2. Start Kafka
3. Put break points and run this spring boot app
4. Wait good amount of time to cause CommitFailedException
5. Check if it is caught in try-catch statement for doing manual commit

# How to send data via kafka producer
1. Open Chrome and go to http://localhost:8080/swagger-ui.html
2. Browse into kafka-controller
3. Click kafka-test/send API
4. Enter body
5. Click Execute



