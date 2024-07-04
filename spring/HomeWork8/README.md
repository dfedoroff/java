# Фреймворк Spring. Spring AOP, управление транзакциями. Семинар 8. Домашнее задание

__1.__ Создать аннотацию замера времени исполнения метода `(Timer)`. Она может ставиться над методами или классами.
   Аннотация работает так: после исполнения метода (метода класса) с такой аннотацией, необходимо в лог записать следующее:
   `className - methodName` #(количество секунд выполнения)

__2.__ * Создать аннотацию `RecoverException`, которую можно ставить только над методами.
   ```java
   @interface RecoverException {
         Class<? extends RuntimeException>[] noRecoverFor() default {};
   }
   ```
   У аннотации должен быть параметр `noRecoverFor`, в котором можно перечислить другие классы исключений.

   Аннотация работает так: если во время исполнения метода был экспешн, то не прокидывать его выше и возвращать из метода значение по умолчанию `(null, 0, false, ...)`.

   При этом, если тип исключения входит в список перечисленных в `noRecoverFor` исключений, то исключение **НЕ** прерывается и прокидывается выше.

__3.__ *** Параметр `noRecoverFor` должен учитывать иерархию исключений.