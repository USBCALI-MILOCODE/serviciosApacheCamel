SERVICIO 1 PUERTO: 8081 | http://localhost:8081/v1/getOneEnigma/getStep/
SERVICIO 2 PUERTO: 8082 | http://localhost:8082/v1/getOneEnigma/getStep/
SERVICIO 3 PUERTO: 8083 | http://localhost:8083/v1/getOneEnigma/getStep/

SERVICIO ORQUESTADOR PUERTO: 8080 | http://localhost:8080/v1/getOneEnigma/getSteps/

REQUEST MICROSERVICIOS:
{  
   "data":[  
      {  
         "header":{  
            "id":"12345",
            "type":"StepsGiraffeRefrigerator"
         },
         "step":"1"
      }
   ]
}

{  
   "data":[  
      {  
         "header":{  
            "id":"12345",
            "type":"StepsGiraffeRefrigerator"
         },
         "step":"2"
      }
   ]
}

{  
   "data":[  
      {  
         "header":{  
            "id":"12345",
            "type":"StepsGiraffeRefrigerator"
         },
         "step":"3"
      }
   ]
}

REQUEST ORQUESTADOR:
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
