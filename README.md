# Демонстрация работы
![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/34b3b3dd-781b-4179-ac04-1a40a6c83eb9)

# Файл конфигурации
- Все необходимые параметры конфигурации задаются в **application.properties** проекта
```
api.token.access= {your_accessToken}            // ключ доступа генерируется в самом начале
api.token.confirmation= {yout_confirmation}     // строка подстверждения для проверки сервера-бота, куда будут присылаться запросы
api.secret= {your_token}                        // наше значение, которое необходимо для проверки, что присланный запрос именно с нашей группы
```

# Сущности в виде POJO 
... находятся в **event** папке проекта - **Event**, **EventObject**, **Message**

# Инструкция использования
> ***Если использовать бота не конкретно к созданной мною группе, а в целом иметь возможность добавить его к любой другой:***
1. Создается отдельная vk-группа
2. Далее переходим в '**Управление**'->'**Работа с API**'
3. На интерфейсе сверху требуется прежде всего выбрать '**Создать ключ**' и выбрать все необходимые права
  ![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/d9371686-1ee9-45d8-9940-77067d233d3c)
5. После подтверждения мы получаем сгенерированный ключ - наше **api.token.access** поле в файле конфигурации
6. Переходим в '**Callback API**' вкладку и указываем свой секретный ключ (любой) - **api.secret**
7. Далее нам требуется использование внешних https адресов для локальной машины - я использовал ngrok.\
   Полученный адрес к боту из ngrok указываем в '**Адрес**' поле - адрес сервера-бота
8. Под полем формы адреса указана строка, которая должна быть возвращена ботом для проверки - поле **api.token.confirmation** в конфигурации\
 ![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/54bd253c-267f-4087-8e55-e21996336ddd)\
⭐ Бот подключен. Остается лишь написать сообщение в группу (*****важно - сообщение самому сообществу, а не новый чат в сообщенстве*****) и он вернет требуемый ответ в личных сообщениях
