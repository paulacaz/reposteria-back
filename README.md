
## Instalación

Clonar repositorio

```bash
  git clone https://github.com/paulacaz/reposteria-back.git
```

Generar jar con maven desde la consola de comandos cmd ubicado en la raíz del proyecto

```bash
  mvn package
```

Ejecutar aplicación - por defecto ejecuta base de datos en memoria

```bash
  java -jar target/Proyecto-0.0.1-SNAPSHOT.jar
```

Ejecutar aplicación en modo local (Conectando a base de datos local)

```bash
  java -jar target/Proyecto-0.0.1-SNAPSHOT.jar --spring.profiles.active=local
```
## Environment Variables - opcional

Si desea parametrizar las siguientes variables de entorno para que sea configurable

`SECRET_KEY` -> llave de JWT

`ADMIN_SECRET_KEY` -> llave para registro de administradores

`USUARIO_PASSWORD_REGEXP` -> Regexp para validación de contraseñas

## Tecnologías

Java 17, Maven, Spring Boot 3, Spring Data, Jwt, H2 Database, Mysql, Swagger, Lombok

