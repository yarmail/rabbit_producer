<a href="/README.md">вернуться к оглавлению</a>

<b>Сборка и запуск проекта</b> <br><br>
После проведения Подготовки к сборке начинаем сборку.<br>

В своей домашней папке создаем папку проекта rabbit_connect<br>
и переходим в нее <br>

<pre>
user1@ubuntu:~$ mkdir rabbit_connect
user1@ubuntu:~$ cd rabbit_connect/
user1@ubuntu:~/rabbit_connect$ 
</pre>

Клонируем с гита оба проекта в нашу рабочую папку
<pre>
user1@ubuntu:~/rabbit_connect$ git clone https://github.com/yarmail/rabbit_producer.git
user1@ubuntu:~/rabbit_connect$ git clone https://github.com/yarmail/rabbit_consumer.git
user1@ubuntu:~/rabbit_connect$ ls
rabbit_consumer  rabbit_producer
</pre>

Создаем или копируем в папку docker-compose.yml <br>
user1@ubuntu:~/rabbit_connect$ nano docker-compose.yml <br>

следующего содержания:
```
version: '3.8'
services:

  rabbit_producer:
    container_name: rabbit_producer
	build: ./rabbit_producer
	ports:
	  - "8081:8081"
	
  rabbit_consumer:
    container_name: rabbit_consumer
	build: ./rabbit_consumer
	ports:
	  - "8080:8080"
	  
  rabbitmq:
    container_name: rabbitmq
    image: rabbitmq:management
    ports:
      - "5672:5672"
      - "15672:15672"
```

Запускаем проект командой <br>
`user1@ubuntu:~/rabbit_connect$ docker-compose up -d`