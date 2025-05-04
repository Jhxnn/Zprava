package com.storia.config;

import com.storia.dtos.EmailDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mail.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@ApplicationScoped
public class EmailReader {

    @Inject
    EmailConfig emailConfig;

    public List<EmailDto> lerEmailsComFiltro(String filtro) throws Exception {

        String host = emailConfig.host;
        String username = emailConfig.username;
        String password = emailConfig.password;

                Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        Session session = Session.getInstance(props);
        Store store = session.getStore();
        store.connect(host, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        System.out.println("Total de mensagens: " + messages.length);
        List<EmailDto> listEmail = new ArrayList<>();
        for (Message message : messages) {
            Object content = message.getContent();
            String text = "";


            if (content instanceof String) {
                text = (String) content;
            } else if (content instanceof Multipart) {
                Multipart multipart = (Multipart) content;
                for (int j = 0; j < multipart.getCount(); j++) {
                    BodyPart part = multipart.getBodyPart(j);
                    if (part.isMimeType("text/plain")) {
                        text += part.getContent().toString();
                    }
                }
            }

            if (text.toLowerCase().contains(filtro.toLowerCase())) {
                EmailDto emailDto = new EmailDto(username,text, message.getSubject(),String.valueOf(message.getFrom()[0]));
                listEmail.add(emailDto);
            }
        }

        inbox.close(false);
        store.close();
        return  listEmail;
    }


}
