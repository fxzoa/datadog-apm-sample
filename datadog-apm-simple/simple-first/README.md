# Simple Project for docker

## build image
docker build -t fxzoa/datadog-apm-sample-first .

## run image
docker run --rm -d --name simple-first -p 8080:8080 -d fxzoa/datadog-apm-sample-first

## push to dockerhub repository
docker push fxzoa/datadog-apm-sample-first

## Path

### API
> /api/port
> /api/hello

### Page
> /page/port
