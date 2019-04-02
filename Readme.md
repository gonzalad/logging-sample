Sample project to show log handling with ;

* Splunk
* or ELK

# Splunk

See [](spring-boot-splunk-sleuth-demo/readme.md) 

# ELK

* Start ELK

I'm using Docker Toolbox, so I need first to copy my elk directory to ${USER_PROFILE}/.docker (we use volumes)

Then:
```
cd elk
docker-compose
```
* if necessary change logback-spring.xml to send the logs to your logstash in your docker-machine (by default 192.168.99.100)
* Start spring-boot-splunk-sleuth-demo
* Start spring-boot-splunk-sleuth-demo-2
* navigate to http://localhost:8080/proxy
* open a new tab on kibana: http://192.168.99.100:5601, you'll see the apps logging

# TODO

Create some dashboards