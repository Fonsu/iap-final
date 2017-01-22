# iap-final
Minimal RESTful job API built with [APIKIT](https://docs.mulesoft.com/apikit/), modelled with [RAML](http://raml.org/).


**Note** all PUT/POST operations require the `Content-Type` header set to `application/json`

### Operations with single job
#### GET JOB
/api/job/8735
##### input 
no input needed
##### output
```json
{
  "cod_oferta": "2668",
  "empresa": "Cogibox",
  "localidad": "valencia",
  "categoria": "Haskell",
  "jornada": "tarde",
  "duracion": "2 meses",
  "bolsa": "423",
  "fecha_inicio": "15/02/2017",
  "num_plazas": "1"
}
```
#### PUT JOB
/api/job/8735

##### input 
```json
{
  "categoria": "java",
  "jornada": "flexible",
  "duracion": "2 meses",
  "bolsa": "400",
  "fecha_inicio": "30-01-2017",
  "num_plazas": "2"
}
```
##### output
no output

#### DELETE JOB
/api/job/8735

no input nor output

### GET operations with multiple jobs

/api/jobs

/api/jobs/{jobCity}

/api/jobs/{jobCity}/{jobCategory}
