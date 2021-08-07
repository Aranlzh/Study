package top.aranlzh.servlet;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String address = (String) req.getAttribute("address");
        String title = (String) req.getAttribute("title");
        String content = (String) req.getAttribute("content");


        // ssl ttls 多种协议
        int protocol = 1;


        // 配置：发件人账号相关
        Properties prop = new Properties();
        // 主机
        // 邮件服务器，类似smtp.163.com
        prop.put("mail.host", "smtp.qq.com");
        // 邮件发送协议
        prop.put("mail.transport.protocol", "smtp");
        // 使用smtp身份验证
        prop.put("mail.smtp.auth", "true");

        if (protocol == 1){
            // 使用SSL开启安全协议

            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
            } catch (GeneralSecurityException e) {
               e.printStackTrace();
            }
            prop.put("mail.smtp.port", 465);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);
        } else if (protocol == 2){
            prop.put("mail.smtp.port", 587);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.timeout","125000");
        } else {
            prop.put("mail.smtp.port", 25);
        }

        // 连接服务器：获取Session对象
        Session session = Session.getDefaultInstance(prop,new Authenticator() {
            //此访求返回用户和密码的对象
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 此处修改成自己的账号密码
                PasswordAuthentication pa = new PasswordAuthentication("123456@qq.com", "123456");
                return pa;
            }
        });

        // 设置邮件并发送
        MimeMessage message = new MimeMessage(session);
        try {
            // 发件人邮箱地址
            message.setFrom(new InternetAddress("123456@qq.com"));
            // 收件人邮箱地址
            message.setRecipients(Message.RecipientType.TO, address);
            // 主题：不要包含测试、test之类的字样
            message.setSubject(title);

            // 一个Multipart对象包含一个或多个BodyPart对象，来组成邮件的正文部分（包括附件）。
            MimeMultipart multiPart = new MimeMultipart();

            // 添加正文
            MimeBodyPart partText = new MimeBodyPart();
            partText.setContent(content, "text/html;charset=utf-8");
            multiPart.addBodyPart(partText);

            //邮件附件
            // if (files != null) {
            //     for (File attachment : files) {
            //         BodyPart attachmentPart = new MimeBodyPart();
            //         DataSource source = new FileDataSource(attachment);
            //         attachmentPart.setDataHandler(new DataHandler(source));
            //         //避免中文乱码的处理
            //         attachmentPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
            //         multiPart.addBodyPart(attachmentPart);
            //     }
            // }
            message.setContent(multiPart);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
