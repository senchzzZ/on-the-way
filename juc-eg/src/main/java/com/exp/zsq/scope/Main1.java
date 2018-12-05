package com.exp.zsq.scope;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * 测试mail.Session作用域
 * Created by zhaoshengqi on 2018/12/5.
 */
public class Main1 {
    public static void main(String[] args) {
        MailTest1.updateSession();
        MailTest2.updateSession();
    }

}
