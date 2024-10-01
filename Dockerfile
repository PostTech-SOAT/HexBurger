FROM maven:3.9.6-amazoncorretto-21-debian

WORKDIR /opt/app

ENV APP_HOME /opt/app

# Adicionando um usuário e suas permissões
RUN groupadd -r hexgroup && useradd -r -g hexgroup -d $APP_HOME -s /sbin/nologin hexuser

RUN chown -R hexuser:hexgroup $APP_HOME

RUN chmod -R 755 $APP_HOME

#Expondo a porta 8080
EXPOSE 8080

#Executando a aplicação
ENTRYPOINT ["java", "-jar", "/opt/app/target/hexburger.jar", "-Xms512M", "-Xmx1024M"]