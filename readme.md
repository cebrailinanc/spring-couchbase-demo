`docker run -d --name couchbase-instance -p 8091-8094:8091-8094 -p 11210:11210 couchbase`

http://localhost:8091


build image command
`docker build  -t spring-couchbase-demo .`
We can see our image listed with the command:
`docker images `

run couchbase server
`docker run -d --name couchbase-instance -p 8091-8094:8091-8094 -p 11210:11210 couchbase`

run app image
`docker run -p 1234:8080 -d spring-couchbase-demo`
# -p  <Host Port> : <  container expose port>

http://localhost:1234/swagger-ui.html
docker network rm couchbase-network

docker network ls

`docker network create "cb-network"`

`docker run --net="cb-network" --name couchbase-instance -p 8091-8094:8091-8094 -p 11210:11210 couchbase`

`docker run --net="cb-network" -p 1234:8080 -d spring-couchbase-demo --name spring-couchbase-demo`


docker network inspect cb-network


