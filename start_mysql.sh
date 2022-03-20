docker run -d -p 3306:3306  \
-e MYSQL_DATABASE=testdb \
-e MYSQL_USER=dbuser \
-e MYSQL_PASSWORD=userpass \
-e MYSQL_ALLOW_EMPTY_PASSWORD=1 \
-e MYSQL_ROOT_PASSWORD=toor \
mysql