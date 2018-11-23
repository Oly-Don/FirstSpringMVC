FROM centos

ENV images="gcr.io/google_containers/k8s-dns-sidecar-amd64:1.14.13 "
#yum uptate -y & \
RUN mkdir /data/ &\
    yum install -y git docker-io & \
	service docker start & \
	docker pull $images &\
	docker save $images  -o /data/images.zip
	
VOLUME /data
EXPOSE 22
