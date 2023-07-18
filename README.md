<h3>RabbitMQ Connect</h3>
Проект состоит из двух микросервисов, соединенных RabbitMQ:<br>
~ rabbit_producer (данный проект) <br>
~ <a href="https://github.com/yarmail/rabbit_consumer">rabbit_consumer</a> <br>
<b>Одна из идей проекта</b> - создание кода в одной ОС (в данном случае Windows 7)<br>
а запуск кода в другой OC (в данном случае Ubuntu) за счет использования Docker.<br>
 
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
в микросервис rabbit_consumer <br>
Условия тестирования проекта: данный проект будет тестироваться с использованием <br>
Ubuntu 22.04 и Docker. <br>

<a href="/01_info/010_create_project/CREATE.md">010 Создание проекта rabbit_producer</a> <br>
Информация о создании нового проекта, настройки проекта <br><br>

<a href="/01_info/020_work_with_rabbitmq/RABBIT.md">020 Работа с RabbitMQ со стороны проекта </a> <br>
Зависимости, настройка application.yml, немного теории <br><br>

<a href="/01_info/030_preparation/PREPARATION.md">030 Подготовка к сборке </a> <br>
Проверка наличия необходимых для сборки компонентов. <br><br>

Начинаем сборку и тестирование проекта <br>
Система, на которой происходит сборка и тестирование проектов: <br>
~ на системе установлен Windows 7 x64 <br>
~ на Windows установлен Oracle VirtualBox 7 <br>
~ на VirtualBox установлен Ubuntu 22.04.2 LTS <br>

