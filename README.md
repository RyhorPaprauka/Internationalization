Дана следующая схема базы данных:

 



 

Задача: добавить поддержку интернационализации на уровне базы данных. Это значит, что необходимо изменить существующие и добавить новые таблицы в схему базы данных таким образом, чтобы все описания могли храниться на разных языках. В предоставленном примере название продукта (таблица item колонка name) и атрибута  (таблица attribute колонка name).

Для проверки работоспособности интернационализации написать SpringBoot приложение с использованием Spring Data, которое имеет один REST контроллер, что принимает всего два параметра: код продукта (item.code), язык (EN, RU, etc) и возвращает ответ в виде JSON файла с информации о названии продукта по переданному коду и списком его атрибутов. Валидацию на входные параметры писать не нужно.

               

Например:

 

Передан в качестве параметра язык EN:



 

Передан в качестве параметра язык RU:

