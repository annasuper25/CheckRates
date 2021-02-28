# CheckRates
Displaying the change of the exchange rate with GIF

Данный сервис обращается к сервису курсов валют https://docs.openexchangerates.org/, и отдает gif в ответ:
если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдает рандомную отсюда https://giphy.com/search/rich
если ниже - рандомную отсюда https://giphy.com/search/broke


В приложении имеется 2 endpoint:
- url, чтобы получить ссылку на картинку
localhost:8080/url
 
- gif, чтобы сразу из браузера видеть пришедшую картинку
localhost:8080/gif


Так как в условии задания не было описано поведение в случае равенства курсов валют, то решено сделать настройку для проверки 
курсов на равенство (check-equals-rates-enabled), которая задается в файле application.properties. 
её можно включать и выключать, установив значение true либо false.

При равенстве курсов валют, если эта настройка включена (true), будет выводиться рандомная GIF с тэгом "mem" (запрос 
https://giphy.com/search/mem)
а если она выключена (false), то ничего не будет выведено.

Тэги для 3-х возможных результатов сравнения курсов также вынесены в файл application.properties и могут быть легко изменены:
main.rate-up-tag:rich
main.rate-down-tag:broke
main.rate-flat-tag:mem



ИНСТРУКЦИЯ ПО ЗАПУСКУ ПРИЛОЖЕНИЯ
*Требуется Gradle 6.3 или новее.

1. Открыть командную строку (cmd)

2. Скачать репозиторий:
git clone https://github.com/annasuper25/CheckRate.git

3. Перейти в директорию проекта командой: 
cd CheckRate

4. Создать враппер командой:
gradle wrapper

5. Запустить сборку проекта командой:
gradle.bat clean build (для Windows)
или 
./gradlew clean build (для Unix)

6. Перейти в папку с собранным jar файлом:
cd build/libs

7. Запустить проект командой:
java -jar check-rates-api-0.0.1-SNAPSHOT.jar

Готово. Приложение запущено.


Далее для проверки работы в зависимости от ОС:

Для любой ОС (Windows или Unix), можно открыть браузер и написать в строке поиска:
localhost:8080/url (получить ссылку на картинку)
или
localhost:8080/gif (получить GIF)


Если операционная система семейства Unix, то можно запустить приложение также из терминала командами: 
curl -X GET localhost:8080/url (получить ссылку на картинку)
или
curl -X GET localhost:8080/gif (получить GIF)