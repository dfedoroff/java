# Фреймворк Spring. Spring Security. Работа с JWT. Защита от основных видов атак. Семинар 7. Домашнее задание

__1.__
   
   Для ресурсов, возвращающих HTML-страницы, реализовать авторизацию через `login-форму`.

   Остальные `/api` ресурсы, возвращающие `JSON`, закрывать не нужно!

__2.__

   2.1.* Реализовать таблицы `User`(`id`, `name`, `password`) и `Role`(`id`, `name`), связанные многие ко многим

   2.2.* Реализовать `UserDetailsService`, который предоставляет данные из БД (таблицы `User` и `Role`)

__3.__

   3.3* Ресурсы выдач `issue` доступны обладателям роли `admin`

   3.4* Ресурсы читателей `reader` доступны всем обладателям роли `reader`

   3.5* Ресурсы книг `books` доступны всем авторизованным пользователям