<a href="/README.md">вернуться к оглавлению</a>

<b>Создаем проект</b> <br><br>

File > New Project > Spring Initializr <br> 
Name - rabbit_producer <br>
Language - Java <br>
Type - Maven <br>
Project - SDK 17 <br>
Java - 17 <br>
Packaging - Jar <br><br>

Spring Boot 2.7.12 <br>

Dependencies: <br>
Developer Tools > Lombok <br>
Web > Spring Web <br> 
Messaging > Spring for RabbitMQ <br><br> 

Добавляем README.md

Примечание
Чтобы файл настроек адекватно относился к русскому языку
я изменяю кодировку файлов .properties
Для этого я изменил следующую настройку:
File > Settings > Editor > File Encodings
Default encoding for properties files:
Было: Properties Default: ISO-8859-1
Стало: UTF-8