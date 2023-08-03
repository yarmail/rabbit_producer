<h3>RabbitMQ Connect</h3>
Проект состоит из двух микросервисов, соединенных RabbitMQ:<br>
~ rabbit_producer (данный проект) <br>
~ <a href="https://github.com/yarmail/rabbit_consumer">rabbit_consumer</a> <br>

 
<details>
<summary>Примечание: информация о проекте</summary>
Большая часть информация о проекте: примечания, описания, 
объяснения, картинки, комментарии <br> 
находятся в папке <b><a href="01_info">01_info</a></b>.<br>
Общие детали обоих проектов (сборка и тестирование) будут находится в этом проекте.<br>
<b>Важно:</b> тестирование проекта будет проходить с использованием Ubuntu и Docker
</details> <br>

Общая схема проекта<br>
<img src="/01_info/schema.png" alt=""><br>

Описание проекта rabbit_producer.<br>
Данный микросервис rabbit_producer получает от Пользователя (User, Client)<br>
запросы, в виде данных пользователя и передает их через RabbitMQ <br> 
в микросервис rabbit_consumer <br><br>
Условия проверки работоспособности проекта: данный проект будет тестироваться<br> 
с использованием Ubuntu 22.04 и Docker. <br>
Разделим работу над проектом на 5 этапов: создание, уточнения по RabbitMQ, <br> 
подготовка к сборке, сборка и запуск, тестирование (проверка на работоспособность) <br><br>

<a href="/01_info/010_create_project/CREATE.md">010 Создание проекта rabbit_producer</a> <br>
Информация о создании нового проекта, настройки проекта <br><br>

<a href="/01_info/020_work_with_rabbitmq/RABBIT.md">020 Работа с RabbitMQ со стороны проекта </a> <br>
Зависимости, настройка application.yml, немного теории <br><br>

<a href="/01_info/030_preparation/PREPARATION.md">030 Подготовка к сборке </a> <br>
Проверка наличия необходимых для сборки компонентов. <br><br>

Начинаем сборку, запуск и тестирование проекта <br>
Система, на которой происходит сборка и тестирование проектов: <br>
~ на системе установлен Windows 7 x64 <br>
~ на Windows установлен Oracle VirtualBox 7 <br>
~ на VirtualBox установлен Ubuntu 22.04.2 LTS <br>

<a href="/01_info/040_assembly/ASSEMBLY.md">040 Сборка и запуск приложения</a> <br>
Клонируем проекты с гита, создаем docker-compose.yml и запускаем приложение <br><br>

<b>050 Проверка работоспособности приложения</b><br>
Если все предыдущие этапы выполнены успешно и на данный момент запущены все нужные<br> 
контейнеры
<pre>
 ✔ Network rabbit_connect_default  Created  
 ✔ Container rabbitmq              Started  
 ✔ Container rabbit_producer       Start... 
 ✔ Container rabbit_consumer       Start...
</pre>
начинаем проверку работоспособности <br>
Для этого запускаем Postman и отправляем запрос типа POST<br>
`http://localhost:8081/api/produce`<br>
контейнеру rabbit_producer, который должен слушать порт 8081<br>
Тело запроса Body (JSON)
<pre>
{
    "userId": "ID1",
    "userName": "pedro"
}
</pre>





Для остановки docker-compose и удаления контейнеров и сети<br>
связанные с контейнерной средой используем docker-compose down
<pre>
user1@ubuntu:~/rabbit_connect$ docker-compose down
[+] Running 4/4
 ✔ Container rabbit_producer       Removed                                                                   0.9s 
 ✔ Container rabbit_consumer       Removed                                                                   0.9s 
 ✔ Container rabbitmq              Removed                                                                   7.1s 
 ✔ Network rabbit_connect_default  Removed                                                                   0.4s 
</pre>



