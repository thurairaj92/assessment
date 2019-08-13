# assessment
This assessment supports two enpoint. 

### GET /feature

This endpoint will retrieve whether user has permission for given feature or not, default will be `false`.
```
GET /feature1?email=user@email.com&amp; featureName=testOne HTTP/1.1
Host: localhost:8080
User-Agent: PostmanRuntime/7.15.2
Accept: */*
Cache-Control: no-cache
Postman-Token: d88a0da0-a306-465d-8482-3a14ed71de2c,ff1fce71-fb12-4d2e-8ff4-2093cedd73d4
Host: localhost:8080
Accept-Encoding: gzip, deflate
Connection: keep-alive
cache-control: no-cache
```

### POST /feature
This endpoint will create new feature access rule for given user if specified feature name rule doesn't exist for the user. If such rule exists then this request will update the rule for the user. By default enable is `false`.
```
POST /feature HTTP/1.1
Host: localhost:8080
Content-Type: application/json
User-Agent: PostmanRuntime/7.15.2
Accept: */*
Cache-Control: no-cache
Postman-Token: 7108e81f-6e41-4555-9d22-5a9afe9ccd3c,928b6c92-d52f-48f1-88e8-7076001496bc
Host: localhost:8080
Accept-Encoding: gzip, deflate
Content-Length: 72
Connection: keep-alive
cache-control: no-cache

{
    "email": "user@email.com",
    "featureName": "testOne",
    "enable": "true"
}
```
