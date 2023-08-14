# Neobis_Android_Inventory_App


## Описание проекта

Данный проект представляет собой приложение: " Inventory App", которое охватывает компоненты Android, такие как отображение текстов и изображений, фрагменты
и переходы на другие фрагменты, загрузка изображений, редактирование/ввод текста.

Проект Inventory App- это приложение для отслеживания запасов в магазине.
Цель проекта в том, чтобы спроектировать и создать приложения Inventory, которое позволит магазину отслеживать запасы продуктов.
В данном приложении использовался навигация между фрагментами осуществляется с помощью Navigation Component.
А списки реализованы RecyclerView в виде 2 колонок
Так же использовались:
- RecyclerView
    - Adapter. Паттерн Adapter
    - Card layout
    - Bottom navigation с Bottom Navigation View
    - On Item Click
- Fragment, lifecycle
- Navigation
    - Fragment Manager
    - Navigation Component
- Glide
-  Архитектура MVP
- Coroutines
- Room для работы с базами данных
    - DAO(data access object), SQL queries(запросы), select, delete, update, ordering
    - Entity(таблицы), primary keys, column info
    - Database(getting access to your database, migration, etc)
- ActivityResultApi для работы с галереей
- View Binding
Установлен слушатель для кнопкок с помощью setOnClickListener и On Item Click.

## Установка проекта

**MacOS:**
1. Установить Android Studio https://developer.android.com/studio/
2. Открыть проект или клонировать (клонировать этот проект по инструкции https://www.jetbrains.com/idea/guide/tutorials/creating-a-project-from-github/clone-from-github/)
3. Для запуска проекта в Android Studio нажмите на зеленый треугольник на панели сверху справа


**Windows:**
1. Установить Android Studio https://developer.android.com/studio/
2. Открыть проект или клонировать (клонировать этот проект по инструкции https://www.jetbrains.com/idea/guide/tutorials/creating-a-project-from-github/clone-from-github/)
3. Для запуска проекта в Android Studio нажмите на зеленый треугольник на панели сверху справа

## Функционал проекта 

Проект Inventory App- это приложение для отслеживания запасов в магазине.
Цель проекта в том, чтобы спроектировать и создать приложения Inventory, которое позволит магазину отслеживать запасы продуктов.
Нажав на плюсик мы можем сами добавить товар, заполнив все поля и картинку. Нажимаем на добавить и возвращаемся к главному экрану, выдя добавленную
картинку в основном списке товаров.
Мы можем нажать на карточку любого товара и провалиться в подробную информацию о месте, а можем изменить его.
Так же можно нажать на стрелку в верхнем левом углу и вернуться назад к начальному списку

<img width="345" alt="Снимок экрана 2023-08-13 в 18 52 24" src="https://github.com/lizazueva/Neobis_Android_Inventory_App/assets/56483500/815b1786-ef21-4b49-afff-2306a5966869">
<img width="345" alt="Снимок экрана 2023-08-13 в 18 52 45" src="https://github.com/lizazueva/Neobis_Android_Inventory_App/assets/56483500/03a0b1d4-cfed-4049-893b-6c568c9907f8">




## Автор проекта

Автор проекта: lizazazu@gmail.com


