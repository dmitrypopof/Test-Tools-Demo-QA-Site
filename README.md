# Test-Tools-Demo-QA-Site
## [Ссылка на сайт](https://demoqa.com)
____
### Проект использует библиотеки:
* JUnit » 4.13.2
* Allure » 2.23.0
* Allure-junit4 » 2.23.0
* Allure-java-commons » 2.23.0
* Selenium Java » 4.10.0
* Selenium Chrome Driver » 4.10.0

____
___Версии Java 11,___
___Google Chrome 115.0.5790.102___
____
#### Тест:

````
1. Страница Practice Form

1.1.Успешное заполнение формы
````
____
#### Используемые команды Maven:
````
mvn clean test --> запустить тесты
mvn allure:serve --> запустить веб-сервер Allure, в браузере откроется страница c отчетом
````
____
#### Прочее:
_Приём остановки страницы в DevTools браузера при поиске локаторов в раскрывающимся списке:_
```
javascript
setTimeout(function() {
    debugger;
}, 5000);
```