# Proyecto Cache

Este es un proyecto donde resalta el uso de la cache para el almacenamiento temporal de resultados de metodos y evitar la ejecucion de metodos que se consideren de alto impacto en el tiempo de respuesta de los servicios.

Este proyecto expone 3 servicios rest para evaluar las operacion con la cache
1. Ejecuta el metodo y almacena en cache. **@Cacheable**
  - 1er llamado, ejecuta metodo.
  - 2do llamado en adelante, la cache devuelve resultado.
2. Siempre Ejecuta el metodo y actualiza en cache. **@CachePut**
  - 1er llamado, ejecuta metodo y actualiza cache.
  - 2do llamado en adelante, ejecuta metodo  y actualiza la cache.
3. Limpia la cache. **@CacheEvict**

### Ficha del Proyecto
| Tecnología  | Versión |
|-------------|---------|
| Java JDK    | 21      |
| Spring Boot | 3.4.5   |
| Lombok      | 1.18.38 |
| Maven       | 3.9.9   | 

### Documentación de Referencia
For further reference, please consider the following sections:

* [Baeldung Spring Boot Cache](https://www.baeldung.com/spring-cache-tutorial)