## Dependencies
```

```


## Setup
Create a sever.yaml
```
    server:
      type: simple
      applicationContextPath: /
      adminContextPath: /admin
      connector:
        type: http
        port: 4444
    
    version: 99
    
```
- applicationContextPath
    
    By default, Dropwizard application will start and running in the / like http://localhost:8080/. 
    If you want to configure your own context path for your application, you can add config 
        applicationContextPath: /application

server:
  applicationContextPath: /application


## Run
Set Program arguments
```
    server serve.yaml
```

## Annotations
    - https://docs.oracle.com/cd/E19798-01/821-1841/6nmq2cp1v/index.html

- javax.ws.rs.Consumes : MIME media types can accept, or consume, from the client.

- javax.ws.rs.Produces : MIME media types or representations a resource can produce and send back to the client
