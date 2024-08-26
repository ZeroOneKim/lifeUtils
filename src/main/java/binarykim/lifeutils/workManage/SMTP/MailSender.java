package binarykim.lifeutils.workManage.SMTP;

import binarykim.lifeutils.workManage.security.SecurityInfo;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
    private final SecurityInfo securityInfo;

    public MailSender(SecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
    }

    public void sendMail() {

    }

}
