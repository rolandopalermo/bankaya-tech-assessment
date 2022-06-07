## H2 Console
http://localhost:8080/h2-console

## WSDL
http://localhost:8080/soap/poke-api-integration/ws/soapPokeApiIntegration.wsdl

## Respuestas preguntas
1. Una clase abstracta es aquella clase que tiene al menos un método abstracto, por su parte en una interfaz todos los métodos son abstractos
2. LinkedList es más rápido para agregar y eliminar, mientras ArrayList es más rápido para acceder a un elemento específico
3. Cuando no hay referencias hacia un objeto, la memoria donde este está localizado es reclamado por el GC.
4. Pow sin multiplicación:
```
public static long pow(int base, int exp) {
    if (exp == 0) {
        return 1;
    }
    return pow(base, exp - 1) * base;
}
```

## Respuesta al problema
### Solución 1
Utilizaría ActiveMQ/Kafka para recibir la petición del usuario, encolarla y responder automáticamente. El procesamiento de la solicitud se haría de forma asíncrona.
### Solución 2
Utilizaría la API reactiva de Java para procesar la solicitud asíncronamente.
```
CompletableFuture.supplyAsync(() -> processRequest());
```
