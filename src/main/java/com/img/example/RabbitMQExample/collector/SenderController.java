package com.img.example.RabbitMQExample.collector;


import com.img.example.RabbitMQExample.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sender/")
public class SenderController {

    @Autowired
    Sender sender;

    @PostMapping("/send/{msg}")
    public ResponseEntity<?> search(@PathVariable String msg) {
        sender.sendMessage(msg);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
