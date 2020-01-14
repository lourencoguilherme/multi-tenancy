### ref https://medium.com/swlh/multi-tenancy-implementation-using-spring-boot-hibernate-6a8e3ecb251a

# Criação das bases de dados

### multi_client
Database: multi_client

-- DROP DATABASE multi_client;

CREATE DATABASE multi_client
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;
       
       
### multi_client_a
Database: multi_client_a

-- DROP DATABASE multi_client_a;

CREATE DATABASE multi_client_a
 WITH OWNER = postgres
      ENCODING = 'UTF8'
      TABLESPACE = pg_default
      LC_COLLATE = 'en_US.UTF-8'
      LC_CTYPE = 'en_US.UTF-8'
      CONNECTION LIMIT = -1;
      
### multi_client_a
Database: multi_client_b

-- DROP DATABASE multi_client_b;

CREATE DATABASE multi_client_b
 WITH OWNER = postgres
      ENCODING = 'UTF8'
      TABLESPACE = pg_default
      LC_COLLATE = 'en_US.UTF-8'
      LC_CTYPE = 'en_US.UTF-8'
      CONNECTION LIMIT = -1;      