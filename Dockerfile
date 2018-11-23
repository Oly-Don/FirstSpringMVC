ROM centos:7.4

ENV images="gcr.io/google_containers/k8s-dns-sidecar-amd64:1.14.13 "

RUN makedir /data/ &\
    yum uptate & \
    yum install -y git wget tar curl docker-io & \
	service docker start & \
	docker pull $images &\
	docker save $(docker images -q) -o /data/images.zip
	
VOLUME /data
EXPORT 22
