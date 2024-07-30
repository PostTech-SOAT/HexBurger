# PARA USAR O LOCUST COMO TESTER É SÓ INSTALAR COM PIP
# pip3 install locust
# locust -v
# executar no diretório que está este arquivo:
# locust
# Abra no browser a página que será passada no output de execucão
# Coloque a url da aplicacao e a quantidade de usuário para comecar o teste
# https://docs.locust.io/ para conhecer mais
# ABRIR OS REPORTS NO BROWSER

from locust import HttpUser, task

class HelloWorldUser(HttpUser):
  @task
  def hello_world(self):
    self.client.get("/v1/produto/LANCHE")