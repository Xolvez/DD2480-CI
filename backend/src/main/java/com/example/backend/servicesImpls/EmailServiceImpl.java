package com.example.backend.servicesImpls;

import com.example.backend.services.EmailService;
import jodd.mail.Email;
import jodd.mail.MailServer;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpServer;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
    @Override
    /** Send email about the build success to the address **/
    public void email_success(String to_email) {
        String email_subject = "DD2480 CI Result Success";
        String email_body = "Your commit passed. From DD2480 CI Group 6";

        send_email(to_email, email_subject, email_body);
    }

    @Override
    /** Send email about the build failure to the address **/
    public void email_failure(String to_email) {
        String email_subject = "DD2480 CI Failure";
        String email_body = "Your commit didn't pass. From DD2480 CI Group 6";

        send_email(to_email, email_subject, email_body);
    }

    /** Send email with the email_subject and email_body to the address **/
    private void send_email(String to_email, String email_subject, String email_body) {
        String mail_host = "smtp.gmail.com";
        String mail_username = "dd2480ci6@gmail.com";
        String mail_password = "zzgwqtuarkxwrtkl";

        SmtpServer smtpServer = MailServer.create()
                .ssl(true)
                .host(mail_host)
                .auth(mail_username, mail_password)
                .buildSmtpMailServer();

        Email email_send = Email.create()
                .from(mail_username)
                .to(to_email)
                .subject(email_subject)
                .textMessage(email_body);

        SendMailSession session = smtpServer.createSession();
        session.open();
        session.sendMail(email_send);
        session.close();
    }
}
