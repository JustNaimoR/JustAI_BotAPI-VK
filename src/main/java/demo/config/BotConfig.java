package demo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Файл конфигурации бота:
 *  access - выданный ключ доступа для бота в VK
 *  confirmation - код подтверждения для сервера
 *  secret - установленный secret ключ для проверки выходящих запросов
 *  port - на каком порту работает бот,
 */

@Component
@Getter
public class BotConfig {
    @Value("${api.token.access}")
    private String access;
    @Value("${api.token.confirmation}")
    private String confirmation;

    @Value("${api.secret}")
    private String secret;
}