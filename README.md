# irctc_demo
A Backend service built using Java, Spring Boot and MySQL which has the functionalities:
1. to add/update/delete a train by ADMIN
2. to add/delete/update a booking by USER

# PROJECT SETUP
1. Clone this repository to local and reload maven
2. Run the script from "resources/sql-script/script.sql" in MySQLWorkbench/DBeaver
3. Generate jooq-codegen using maven plugin
4. Start the application by setting the profile to Local.

# Core Functionalities
1. Added Jwt token for Authorization token for all the apis after login to ensure secure data flow.
2. Use Authorization token generated from '/authenticate/log-in' api to access all other apis.
3. Used forUpdate() in jooq to avoid the race condition - only one user can book the same seat at a time.

