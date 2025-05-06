package com.storia.config;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.*;
import com.storia.dtos.EmailDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@ApplicationScoped
public class EmailReader {

    private final Gmail gmailService;

    public EmailReader() throws Exception {
        this.gmailService = EmailConfig.getGmailService();
    }

    public List<EmailDto> readEmailWithFilter(String filtro) throws Exception {
        List<EmailDto> result = new ArrayList<>();

        ListMessagesResponse response = gmailService.users().messages()
                .list("me")
                .setQ("in:inbox")
                .setMaxResults(20L)
                .execute();

        List<Message> messages = response.getMessages();
        if (messages == null) return result;

        for (Message messageSummary : messages) {
            Message fullMessage = gmailService.users().messages().get("me", messageSummary.getId()).setFormat("FULL").execute();

            String body = getTextFromMessage(fullMessage);
            String subject = getHeader(fullMessage, "Subject");
            String from = getHeader(fullMessage, "From");

            if (body.toLowerCase().contains(filtro.toLowerCase())) {
                EmailDto emailDto = new EmailDto("me", body, subject, from);
                result.add(emailDto);
            }
        }

        return result;
    }

    private String getTextFromMessage(Message message) throws Exception {
        if (message.getPayload() == null) return "";
        return getTextFromParts(message.getPayload().getParts());
    }

    private String getTextFromParts(List<MessagePart> parts) throws Exception {
        if (parts == null) return "";

        StringBuilder sb = new StringBuilder();
        for (MessagePart part : parts) {
            if (part.getMimeType().equals("text/plain") && part.getBody() != null) {
                byte[] bytes = Base64.getUrlDecoder().decode(part.getBody().getData());
                sb.append(new String(bytes));
            } else if (part.getParts() != null) {
                sb.append(getTextFromParts(part.getParts()));
            }
        }
        return sb.toString();
    }

    private String getHeader(Message message, String name) {
        if (message.getPayload() == null) return "";
        for (MessagePartHeader header : message.getPayload().getHeaders()) {
            if (header.getName().equalsIgnoreCase(name)) {
                return header.getValue();
            }
        }
        return "";
    }
}
