
# Taller 2: Orquestador
## Corriendo en:


```bash
  http://localhost:8080/v1/getOneEnigma/getStep/
```

### SERVICIO 1: 8081

```http
  POST http://localhost:8081/v1/getOneEnigma/getStep/

  {
    "data": [
      {
        "header": {
          "id": "12345",
          "type": "StepsGiraffeRefrigerator"
        },
        "step": "1"
      }
    ]
  }

  
  

```

### SERVICIO 2: 8082

```http
  POST http://localhost:8082/v1/getOneEnigma/getStep/

  {
    "data": [
      {
        "header": {
          "id": "12345",
          "type": "StepsGiraffeRefrigerator"
        },
        "step": "2"
      }
    ]
  }
```


### SERVICIO 3: 8083

```http
  POST http://localhost:8083/v1/getOneEnigma/getStep/

  {
    "data": [
      {
        "header": {
          "id": "12345",
          "type": "StepsGiraffeRefrigerator"
        },
        "step": "3"
      }
    ]
  }
```

### ORQUESTADOR: 8080

```http
  POST http://localhost:8080/v1/getOneEnigma/getSteps/

  {  
   "data":[  
      {  
         "header":{  
            "id":"12345",
            "type":"TestGiraffeRefrigerator"
         },
         "enigma":"How to put a giraffe into a refrigerator?"
      }
   ]
  }
```

