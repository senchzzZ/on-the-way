package com.exp.zsq.scope;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by zhaoshengqi on 2018/12/5.
 */
public class MailTest1 {
    public static void updateSession(){
        Properties props = new Properties();
        //邮箱的发送服务器地址
        props.setProperty("mail.smtp.host", "127.0.0.1");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("admin", "admin");
            }
        });
    }
}
