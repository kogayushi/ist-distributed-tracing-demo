# Distributed Tracing Demonstration
## preparation
run zipkin server
```bash
$ java -jar zipkin.jar
```

## display zipkin
go to http://localhost:9411/zipkin

## run all service via Run Dashboard in Intellij IDEA

## demonstration
```bash
for i in `seq 1 50`; do for j in a b c d ; do echo `curl -sS 'http://localhost:8081/scenario-'$j` ; done ; done
```

see zipkin server
