# Proyecto de Transferencia de Dinero

Este proyecto implementa un sistema de transferencia de dinero entre usuarios. Los usuarios pueden registrarse, iniciar sesión, ver información de otros usuarios, realizar transferencias de dinero y verificar el tipo de cambio entre monedas.

## Tecnologías Utilizadas
- **Spring Boot:** Framework de desarrollo para Java.
- **Spring WebFlux:** Soporte para programación reactiva en Spring.
- **Spring Data MongoDB:** Integración de MongoDB con Spring.
- **Reactor:** Biblioteca para programación reactiva en Java.
- **MongoDB:** Base de datos NoSQL utilizada para almacenar los datos del usuario y las transacciones.

## Endpoints

### Autenticación y Usuarios
- **POST `/api/auth/register`:** Registra un nuevo usuario.
  - **Entrada:** Objeto JSON con campos `nombre`, `email`, `password` y `fondo`.
- **POST `/api/auth/login`:** Inicia sesión de usuario.
  - **Entrada:** Objeto JSON con campos `email` y `password`.
  - **Salida:** Token de autenticación.

### Usuarios
- **GET `/api/auth/users`:** Obtiene la lista de todos los usuarios.
  - **Salida:** Lista de objetos JSON con detalles de usuario.
- **PUT `/api/auth/users/{userId}`:** Actualiza la información de un usuario existente.
  - **Entrada:** Objeto JSON con campos `nombre`, `email`, `password` y `fondo`.
  - **Salida:** Objeto JSON actualizado del usuario.
- **DELETE `/api/auth/users/{userId}`:** Elimina un usuario existente por su ID.
  - **Salida:** Respuesta vacía (204 No Content).

### Transferencias de Dinero
- **POST `/api/transaccion`:** Realiza una transferencia de dinero entre dos usuarios.
  - **Entrada:** Objeto JSON con campos `emisorId`, `receptorId`, `tipoCambio` y `monto`.
  - **Salida:** Mensaje indicando el éxito de la transacción.

### Tipo de Cambio
- **GET `/api/tipo-cambio`:** Obtiene la lista de todos los tipos de cambio disponibles.
  - **Salida:** Lista de objetos JSON con detalles de tipo de cambio.
- **GET `/api/tipo-cambio/{id}`:** Obtiene un tipo de cambio por su ID.
  - **Salida:** Objeto JSON con detalles de tipo de cambio.
- **POST `/api/tipo-cambio`:** Crea un nuevo tipo de cambio.
  - **Entrada:** Objeto JSON con campos `monedaOrigen`, `monedaDestino` y `tipoCambio`.
  - **Salida:** Objeto JSON creado del tipo de cambio.
- **PUT `/api/tipo-cambio/{id}`:** Actualiza un tipo de cambio existente por su ID.
  - **Entrada:** Objeto JSON con campos `monedaOrigen`, `monedaDestino` y `tipoCambio`.
  - **Salida:** Objeto JSON actualizado del tipo de cambio.
- **DELETE `/api/tipo-cambio/{id}`:** Elimina un tipo de cambio existente por su ID.
  - **Salida:** Respuesta vacía (204 No Content).

## Uso del Proyecto

1. **Clonar el Repositorio:**
   ```
   git clone <URL_DEL_REPOSITORIO>
   ```

2. **Configuración de MongoDB:**
   - Asegúrate de tener una instancia de MongoDB en ejecución.
   - Configura las credenciales y la URL de la base de datos MongoDB en `application.properties`.

3. **Ejecutar la Aplicación:**
   ```
   ./mvnw spring-boot:run
   ```

4. **Pruebas de API:**
   - Utiliza herramientas como Postman o cURL para probar los endpoints mencionados anteriormente.

## Contribuir

Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Haz tus cambios y realiza un commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Sube tus cambios a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request y describe tus cambios detalladamente.

¡Gracias por contribuir!
