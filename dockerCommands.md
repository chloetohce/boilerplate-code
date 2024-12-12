`docker --version`

`docker system prune` - Clear the docker compilation/build cache

`docker build -t <docker login>/<app name>:<version>` - building docker image

`docker image ls` - shows all docker images in local docker repository

`docker run -d -p <public port>:<app port> <image name>:<version>` - run an image in the container

`docker container ls` - lists all running containers

`docker container stop <container id>` - stop running a container

`docker container start <container id>` - start a container

`docker rm <container id>` - remove a stopped container

`docker rmi <image id>` - to delete an image with no running containers