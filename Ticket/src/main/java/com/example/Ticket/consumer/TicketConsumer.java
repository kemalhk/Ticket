package com.example.Ticket.consumer;

import com.example.Ticket.dto.TicketDto;
import com.example.Ticket.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class TicketConsumer {
    private TicketService ticketService ;


    @RabbitListener(queues = "queue-name")
    public void receiveMessage(Message message){
        String messageBody = new String(message.getBody());
        //byte[] body = message.getBody();
        //TicketDto ticketDto = getBodyTicketDto(messageBody);
        TicketDto ticketDto = createTicketDtoFromMessageBody(messageBody);
        ticketService.save(ticketDto);
    }

    private TicketDto createTicketDtoFromMessageBody(String messageBody) {
        // messageBody'yi uygun şekilde ayrıştırma
        JSONObject jsonObject = new JSONObject(messageBody);

        TicketDto ticketDto = new TicketDto();
        ticketDto.setName(jsonObject.getString("name"));
        ticketDto.setLastName(jsonObject.getString("lastName"));
        ticketDto.setMail(jsonObject.getString("mail"));
        ticketDto.setPrice(jsonObject.getDouble("price"));
        ticketDto.setTicketNumber(jsonObject.getInt("ticketNumber"));

        return ticketDto;
    }
}
