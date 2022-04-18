# Dockerfile

#### docker pull mysql
 * Download mysql image

#### docker run --name mysql_db -e MYSQL_DATABASE=online_shop -e MYSQL_ROOT_PASSWORD=password -e MYSQL_PASSWORD=password -d mysql
 * Create mysql_db container with given data

#### docker build . -t backend
 * Build app container

#### docker run -p 8080:8080 --name neobis-container --link mysql_db:mysql -d backend
 * Run app container and connect it to mysql_db container

#### docker container ls
 * Check running containers

# Docker-compose

#### docker-compose up --build
 * Run docker-compose
