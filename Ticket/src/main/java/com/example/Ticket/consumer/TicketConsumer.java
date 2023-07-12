package com.example.Ticket.consumer;

import com.example.Ticket.dto.TicketDto;
import com.example.Ticket.model.TicketCache;
import com.example.Ticket.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketConsumer {

    private TicketService ticketService;


    @RabbitListener(queues = "${ticket.rabbitmq.queue}")
    public void receiveMessage(Message message) throws InterruptedException {
        String messageBody = new String(message.getBody());
        TicketDto ticketDto = createTicketDtoFromMessageBody(messageBody);
        TicketCache ticketCache = createTicketCacheFromMessageBody(messageBody);
        ticketService.createTicketCache(ticketCache);
        ticketService.save(ticketDto);


    }


    private TicketDto createTicketDtoFromMessageBody(String messageBody) {
        // messageBody'yi uygun şekilde ayrıştırma
        JSONObject jsonObject = new JSONObject(messageBody);

        TicketDto ticketDto = new TicketDto();
        //ticketDto.setId(jsonObject.getInt("id"));
        ticketDto.setName(jsonObject.getString("name"));
        ticketDto.setLastName(jsonObject.getString("lastName"));
        ticketDto.setMail(jsonObject.getString("mail"));
        ticketDto.setPrice(jsonObject.getDouble("price"));
        ticketDto.setTicketNumber(jsonObject.getInt("ticketNumber"));

        return ticketDto;
    }

    private TicketCache createTicketCacheFromMessageBody(String messageBody) {
        // messageBody'yi uygun şekilde ayrıştırma
        JSONObject jsonObject = new JSONObject(messageBody);

        TicketCache ticketCache = new TicketCache();
        //ticketDto.setId(jsonObject.getInt("id"));
        ticketCache.setName(jsonObject.getString("name"));
        ticketCache.setLastName(jsonObject.getString("lastName"));
        ticketCache.setMail(jsonObject.getString("mail"));
        ticketCache.setPrice(jsonObject.getDouble("price"));
        ticketCache.setTicketNumber(jsonObject.getInt("ticketNumber"));

        return ticketCache;
    }
}
