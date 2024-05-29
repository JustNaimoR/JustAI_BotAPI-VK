# Демонстрация работы
![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/34b3b3dd-781b-4179-ac04-1a40a6c83eb9)

# Файл конфигурации
- Все необходимые параметры конфигурации задаются в **application.properties** проекта
```
api.token.access= {your_accessToken}            // ключ доступа генерируется в самом начале
api.token.confirmation= {yout_confirmation}     // строка подстверждения для проверки сервера-бота, куда будут присылаться запросы
api.secret= {your_token}                        // наше значение, которое необходимо для проверки, что присланный запрос именно с нашей группы
```

# Инструкция использования
> ***Если использовать бота не конкретно к созданной мною группе, а в целом иметь возможность добавить его к любой другой:***
1. Создается отдельная vk-группа
2. Далее переходим в "**Управление**"->"**Работа с API**"
3. На интерфейсе сверху требуется прежде всего выбрать "**Создать ключ**" и выбрать все необходимые права
  ![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/d9371686-1ee9-45d8-9940-77067d233d3c)
4. После подтверждения мы получаем сгенерированный ключ, который будет в api.token.access переменной
5. Переходим в Callback API вкладку и указываем свой секретный ключ (любой)
6. Далее нам требуется использование внешних https адресов для локальной машины - я использовал ngrok
   Полученный адрес к боту из ngrok указываем в "Адрес" поле - адрес сервера
7. Под полем формы адреса указана строка, которая должна быть возвращена ботом для проверки - поле api.token.confirmation
 ![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/54bd253c-267f-4087-8e55-e21996336ddd)
Бот подключен. Остается лишь написать сообщение в группу (важно - сообщение самому сообществу, а не новый чат в сообщенстве) и он вернет требуемый ответ в личных сообщениях
