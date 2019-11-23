After cloning the reposetry Tasks ...

To run the application on docker envieroment ,download maven-jdk image from dockerhub----> https://hub.docker.com/_/maven?tab=tags
I used this 'maven:3.6.2-jdk-14' and commcand ----> [ docker pull maven:3.6.2-jdk-14 ]

then do ----> [ cd AppForTwitter ]

I wrote the instructions I want to run while building the image in Dockerfie 

then build docker image and name it with 'twitterapp' or anything else, by this command----> [ docker build -t twitterapp . ]
then run the docker image ----> [ docker run -it twitterApp ]
