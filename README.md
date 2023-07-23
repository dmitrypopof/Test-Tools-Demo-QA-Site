# Test-Tools-Demo-QA-Site
## [Ссылка на сайт](https://demoqa.com)

### Проект использует библиотеки:
* JUnit » 4.13.2
* Allure » 2.23.0
* Allure-junit4 » 2.23.0
* Allure-java-commons » 2.23.0
* Selenium Java » 4.10.0
* Selenium Chrome Driver » 4.10.0


___Версии Java 11,___
___Google Chrome 115.0.5790.102___


Используемые команды Maven:
````
mvn clean test --> запустить тесты
mvn allure:serve --> запустить веб-сервер Allure, в браузере откроется страница c отчетом
````

Для остановки загрузки страницы в DevTools браузера при поиске локаторов:
```

javascript
setTimeout(function() {
    debugger;
}, 5000);
```