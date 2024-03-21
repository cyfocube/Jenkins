FROM ubuntu
MAINTAINER Cyfocube
RUN apt-get update && \
    apt-get install -y nginx git

WORKDIR /var/www/html

RUN git clone https://github.com/hariharanjenkin/webapp.git

RUN cp webapp/index.html /var/www/html && \
    cp webapp/Readme.file /var/www/html && \
    cp -r webapp/src /var/www/html

CMD ["nginx", "-g", "daemon off;"]

