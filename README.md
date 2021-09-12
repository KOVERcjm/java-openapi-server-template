# java-openapi-server-template
Easy to use OpenAPI server template, based on Spring Boot.

# 0 Getting started
Install dependency and initialize DB via Docker (if not existed):
```shell
mvn clean package

# Generate self-signed cert if necessary.
openssl req -x509 -new -nodes -sha256 -utf8 -days 365 -newkey rsa:4096 -subj '/CN=localhost' -keyout server/cert/private.key -out server/cert/certificate.crt

# Start DB via Docker if necessary
docker run --name PostgreSQL --restart always -e POSTGRES_PASSWORD=12345 -e POSTGRES_DB=examplePg -p 5432:5432 -d postgres

docker run --name Mongo --restart always -e MONGO_INITDB_ROOT_USERNAME=mongo -e MONGO_INITDB_ROOT_PASSWORD=12345 -e MONGO_INITDB_DATABASE=exampleMongo -p 27017:27017 -d mongo

docker run --name Redis --restart always -p 6379:6379 -d redis redis-server --appendonly yes --requirepass "12345"
```

Start server:

```shell
mvn spring-boot:run
```

If successfully started, the API swagger portal can be accessed via `http://localhost:3000/swagger-ui.html`.


# 4 Dockerized

Replace the DB connection string in Dockerfile if not have DB server in local.

Use Maven plugin `mvn dockerfile:build` command to pack the server into an image. The following is for your reference:

``` shell
mvn dockerfile:build
docker run -d --name my_app -p 3000:3000 my_app
```


# 5 Reference

- [OpenAPI 3.0 Specification](https://swagger.io/specification/)
- [Spring](https://spring.io/)
