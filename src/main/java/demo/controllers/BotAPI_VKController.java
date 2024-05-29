package demo.controllers;

import demo.event.Event;
import demo.services.BotAPI_VKService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BotAPI_VKController {
    private BotAPI_VKService service;

    @PostMapping
    public String respond(@RequestBody Event event) {
        return service.respond(event);
    }

}