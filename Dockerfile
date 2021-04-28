FROM openjdk:8-jdk-alpine
ENTRYPOINT ["java", "-jar", "/home/ec2-user/employee_management/employee-management.jar"]