FROM openjdk
WORKDIR usr/lib
ADD ./target/BEJ_C2_S3_REST_API_MONGODB_PC_1-0.0.1-SNAPSHOT.jar /usr/lib/BEJ_C2_S3_REST_API_MONGODB_PC_1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","BEJ_C2_S3_REST_API_MONGODB_PC_1-0.0.1-SNAPSHOT.jar"]