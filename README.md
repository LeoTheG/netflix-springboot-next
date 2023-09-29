# Netflix Clone - NextJS + Spring Boot + Postgres

![example-img](https://github.com/LeoTheG/netflix-springboot-next/assets/6187214/be8d6962-9e10-435e-abe0-462486bc8278)

## Local Setup

- Install docker
- `npm start` - starts the local docker containers

Frontend is on http://localhost:3000/

Backend is on http://localhost:8080

## How to add more items to the database

Edit `backend/src/main/java/com/example/demo/MediaItem/MediaItemSeeder.java`

## Building and running backend for production

Build the backend container: `npm run build:prod:backend`

Run the local postgres container: `docker-compose -f docker-compose.dev.yml up postgres`

Start the backend container on the same network as the postgres container and with the correct credentials:

`docker run --network netflix-springboot-next_default -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/mydatabase -e SPRING_DATASOURCE_USERNAME=myuser -e SPRING_DATASOURCE_PASSWORD=mypassword netflix-springboot-next-backend:latest`

## Deploying live

Backend is deployed using fly.io at https://leog-netflix-backend.fly.dev/hello

After code changes, run `fly deploy`

### Push image to remote registry (unused)

Rename (tag) the container to the ghcr.io repo:

`docker tag netflix-springboot-next-backend:latest ghcr.io/leotheg/netflix-springboot-next-backend:latest`

Login with docker to ghcr with your PAT (created on github, Tokens(classic))

`docker login ghcr.io -u leotheg`

`docker push ghcr.io/leotheg/netflix-springboot-next-backend:latest`
