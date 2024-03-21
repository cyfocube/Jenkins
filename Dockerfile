FROM ubuntu
MAINTAINER Cyfocube
RUN apt-get update && \
    apt-get install -y nginx git

WORKDIR /var/www/html

RUN git clone https://github.com/cyfocube/Jenkins.git

RUN cp webapp/Index.html /var/www/html && \
    cp webapp/Readme.file /var/www/html && \
    cp -r webapp/src /var/www/html

CMD ["nginx", "-g", "daemon off;"]

