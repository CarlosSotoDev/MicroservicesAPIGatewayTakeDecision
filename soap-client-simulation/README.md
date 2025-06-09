# Cliente a API Gateway y a Microservicios

## 1. Uso de REST TEMPLATE 
Configurar dentro de la aplicación del cliente el RestTemplate con dirección al API GATEWAY

La dirección del rest template va a estar conformada por tres partes:

1. Url de Dirección del Api Gateway.
2. Configuracion de Predicado en application.yml dentro del Api Gateway.
3. Endpoint del Microservicio a donde llegara y se procesara el mensaje.

La dirección quedaria completa de la siguiente forma como ejemplo:

`http://localhost:8082/api/transaction/send`




<div align="center">

| DESCRIPCION | SEGMENTO |
|:---------:|:---------:|
|  URL de la dirección del API GATEWAY    |  http://localhost:8082  |
|  Predicado configurado dentro del API GATEWAY   |  api/transaction   |
|  EndPoint del Microservicios al que va a llegar y recibir los datos desde el API Gateway   |  /send   |

</div>



## 2. Configuración de rutas en el API GATEWAY
Se deben de agregar las configuración de rutas para poder mandar el mensaje desde el cliente, aqui se deben de usar configuración de Eureka gateway, y pueden ser en los siguientes formatos  
- `application.yml`**(Recomendado mas para configuraciones mas complejas tipo servidor como API Gateway).**

```YML
server:
  port: 8082  # Puerto en el que se ejecuta el API Gateway

spring:
  application:
    name: api-gateway  # Nombre de la aplicación (usado en Eureka si aplica)

  cloud:
    gateway:
      routes:
        - id: transaction-service  # Identificador interno para esta ruta (puede ser cualquier nombre único)
          uri: http://localhost:8083  # URL del microservicio al que se reenviará la petición
          predicates:
            - Path=/api/transaction/**  # Condición: esta ruta se activa si el path coincide con este patrón
          filters:
            - StripPrefix=2  # Quita los dos primeros segmentos del path (/api/transaction), deja solo /lo-que-siga

```

- `application.properties` **(No tan recomendado en configuraciones de tipo de servidor por su lectura mas compleja y menos amigable visualmente).**

```PROPERTIES
# Puerto en el que se ejecuta el API Gateway
server.port=8082

# Nombre de la aplicación (útil para Eureka, si lo estás usando)
spring.application.name=api-gateway

# ID de la ruta (nombre interno para identificar la ruta en el gateway)
spring.cloud.gateway.routes[0].id=transaction-service

# URI del microservicio (puerto donde está corriendo el microservicio real)
spring.cloud.gateway.routes[0].uri=http://localhost:8083

# Predicado: esta ruta aplica si la petición entra por /api/transaction/**
spring.cloud.gateway.routes[0].predicates[0]=Path=/api/transaction/**

# Filtro: elimina los dos primeros segmentos del path (/api/transaction), deja solo /lo-que-siga
spring.cloud.gateway.routes[0].filters[0]=StripPrefix=2

```

Se puede usar una mezcla de ambos, spring lee primero el formato .properties y luego el .yml

En este programa se usa ambos, .properties para asignar los elmentos básicos como nombre y puerto y .yml para las propiedades del servidor predicados y demás



