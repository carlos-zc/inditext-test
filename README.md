# 🔥 Inditex Technical Test

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta
tal que:
- Acepte como parámetros de entrada: fecha de aplicación, identificador de producto,
identificador de cadena.
- Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a
aplicar, fechas de aplicación y precio final a aplicar

## ▶️ Run Project
```
# Clone repository
git clone https://github.com/carlos-zc/inditext-test.git

# Enter the project directory
cd inditext-test

# Run program
./mvnw spring-boot:run
```

### Use the endpoint
Request the path `/api/prices` on port `:8080` by default , passing it as a parameter: `date, productId, brandId`. 
For example:
```
http://localhost:8080/api/prices?date=2020-06-14T10:00:00&productId=35455&brandId=1
```

## 🛡️️ Run Tests
```
./mvnw test
```
