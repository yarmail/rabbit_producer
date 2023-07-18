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

<details>
<summary>Результат команды docker-compose up -d</summary>
<pre>
user1@ubuntu:~/rabbit_connect$ docker-compose up -d
[+] Building 105.6s (19/19) FINISHED                                         
 => [rabbit_producer internal] load build definition from Dockerfile    0.1s
 => => transferring dockerfile: 368B                                    0.0s
 => [rabbit_producer internal] load .dockerignore                       0.0s
 => => transferring context: 2B                                         0.0s
 => [rabbit_consumer internal] load .dockerignore                       0.1s
 => => transferring context: 2B                                         0.0s
 => [rabbit_consumer internal] load build definition from Dockerfile    0.2s
 => => transferring dockerfile: 368B                                    0.0s
 => [rabbit_consumer internal] load metadata for docker.io/library/ope  0.0s
 => [rabbit_consumer internal] load metadata for docker.io/library/mav  0.0s
 => [rabbit_consumer maven 1/4] FROM docker.io/library/maven:3.8-openj  1.0s
 => [rabbit_producer internal] load build context                       0.4s
 => => transferring context: 475.25kB                                   0.1s
 => [rabbit_consumer stage-1 1/3] FROM docker.io/library/openjdk:17.0.  0.4s
 => [rabbit_consumer internal] load build context                       0.4s
 => => transferring context: 222.94kB                                   0.1s
 => [rabbit_producer stage-1 2/3] WORKDIR /app                          0.5s
 => [rabbit_producer maven 2/4] WORKDIR /app                            0.1s
 => [rabbit_producer maven 3/4] COPY . /app                             0.4s
 => [rabbit_consumer maven 3/4] COPY . /app                             0.4s
 => [rabbit_producer maven 4/4] RUN mvn install                        89.0s
 => [rabbit_consumer maven 4/4] RUN mvn install                       101.6s
 => [rabbit_producer stage-1 3/3] COPY --from=maven /app/target/rabbit  0.6s
 => [rabbit_consumer] exporting to image                                1.4s
 => => exporting layers                                                 0.9s
 => => writing image sha256:a56e768de9dada9e9ff3614b137c4a49d31c582f44  0.0s
 => => naming to docker.io/library/rabbit_connect-rabbit_producer       0.0s
 => => writing image sha256:fe46dfef2a703d44cacd93dfdb459fb929ba721322  0.0s
 => => naming to docker.io/library/rabbit_connect-rabbit_consumer       0.0s
 => [rabbit_consumer stage-1 3/3] COPY --from=maven /app/target/rabbit  0.8s
[+] Running 4/4
 ✔ Network rabbit_connect_default  Created                              0.2s 
 ✔ Container rabbitmq              Started                              3.0s 
 ✔ Container rabbit_producer       Start...                             2.8s 
 ✔ Container rabbit_consumer       Start...                             2.8s 
user1@ubuntu:~/rabbit_connect$
</pre>
</details> 

Примечания: <br>
~ проект собирался довольно долго - 106 секунд <br>
~ последние строки лога говорят о том, что все нужные контейнеры созданы и запущены <br>
Теперь можно попробовать проверить работоспособность проекта, (вернуться к README.md)

<a href="/README.md">вернуться к README.md</a>

