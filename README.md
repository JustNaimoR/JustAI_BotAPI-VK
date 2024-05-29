# Демонстрация работы
![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/34b3b3dd-781b-4179-ac04-1a40a6c83eb9)

# Файл конфигурации

# Инструкция использования
> ***Если использовать бота не конкретно к созданной мною группе, а в целом иметь возможность добавить его к любой другой:***

<spring.application.name=BotAPI_VK

api.token.access=vk1.a.pYyIEmIHofzw9bFVtT2oW8CVR7HkkPxmowkez2-KcLZR0PZkjp5e6uBqpy2-ZXZd1jO_08u9ptbA7DQlw905AWiwK3Io6bcMlx3kwWiR0zyh6ZwZ2og5Rsgo04WAlskk6VzunnjG25uLTRM82mccojJXadOILLdNltaY9_T_yB8AEEP6-BtbL0mibrgrzp71oSzOR8YgfKe682RulBfrGQ
api.token.confirmation=77b49bd1
api.secret=5PF0SkVZ>
1. Создается отдельная vk-группа
2. Далее переходим в "Управление"->"Работа с API"
3. На интерфейсе сверху требуется прежде всего выбрать "Создать ключ" и выбрать все необходимые права
  ![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/d9371686-1ee9-45d8-9940-77067d233d3c)
4. После подтверждения мы получаем сгенерированный ключ, который будет в api.token.access переменной
5. Переходим в Callback API вкладку и указываем свой секретный ключ (любой)
6. Далее нам требуется использование внешних https адресов для локальной машины - я использовал ngrok
   Полученный адрес к боту из ngrok указываем в "Адрес" поле - адрес сервера
7. Под полем формы адреса указана строка, которая должна быть возвращена ботом для проверки - поле api.token.confirmation
 ![image](https://github.com/JustNaimoR/JustAI_BotAPI-VK/assets/68927773/54bd253c-267f-4087-8e55-e21996336ddd)
Бот подключен. Остается лишь написать сообщение в группу (важно - сообщение самому сообществу, а не новый чат в сообщенстве) и он вернет требуемый ответ в личных сообщениях
