# Parking Service

## Задача
Необходимо реализовать сервис, который получает информацию по загрузке парковки.  
Реализовать 4 CRUD запроса: получение, создание, редактирование и удаление всех связей данных одним запросом.


Требования:
1. Хранить 3 сущности:  
   1. машина (клиент);
   2. парковочное место;
   3. время бронирования и цена;
2. Обеспечить связи между сущностями (связь на своё усмотрение, но нужно будет обосновать)
3. Хранить данные сущности в бд (выбор СУБД не принципиален)
4. Обеспечить получение данных согласно тексту задачи всех связанных сущностей
5. Получать данные из бд средствами JPA
6. Реализовать REST API для получения данных
7. Для проверки рекомендовано использовать Swagger

Технологический стек:
-	Клиентская часть (отсутствует) – для проверки использовать swager или постман
-	Серверная часть – Spring Boot
-	Бд – выбор не принципиален (рекомендовано H2)

Дополнение:
При большей погружённости рекомендовано обеспечить автоматическую накатку данных в бд пользуясь средствами Flyway.

## Реализация
1. Хранятся 3 сущности:
   1. Car (машина)
   2. BookingInfo (время бронирования и цена)
   3. ParkingSpot (парковочное место)
2. Использовал bidirectional one-to-one relationship. 
Плюс данного подхода в том, что есть возможность отследить не только информацию о конкретной машине,
но и, например,  о парковочном месте (посмотреть, какая машина на нем стоит).
3. Сущности хранятся в PostgreSQL
4. Использовал CrudRepository
5. Получаю данные из БД средствами JPA
6. Реализовал 6 методов REST контроллера:
    - createCar (добавление записи)
    - getAllCars (чтение всех записей)
    - getCar (чтение конкретной записи)
    - editCar (изменение конкретной записи)
    - deleteCar (удаление конкретной записи)
    - deleteAllCars (удаление всех записей)
7. Для проверки использовал Postman