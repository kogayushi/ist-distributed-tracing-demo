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
for i in `seq 1 100`; do for endpoint in /top /order-history/me /cart/me/detail /cart/me/checkout ; do curl -s 'http://localhost:8081'$endpoint 2>&1 >/dev/null ; done ; done ; echo done
```

see zipkin server
