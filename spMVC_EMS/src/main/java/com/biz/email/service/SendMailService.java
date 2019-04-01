package com.biz.email.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biz.email.model.EmailVO;

@Service
public class SendMailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	ServletContext context;
	
	public void sendMail(EmailVO emailVO) {
		String from_email = emailVO.getFrom_email();
		String to_email = emailVO.getTo_email();
		String subject = emailVO.getS_subject();
		String content = emailVO.getS_content();
		String file1 = emailVO.getS_file1();
		String file2 = emailVO.getS_file2();
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper mHelper;
		try {
			mHelper = new MimeMessageHelper(message,true,"UTF-8");
			
			mHelper.setFrom(from_email);
			mHelper.setTo(to_email);
			mHelper.setSubject(subject);
			mHelper.setText(content,true); // true 항목 삽입 시 HTML형식의 본문으로 변경
			
			if(file1 != null) {
				FileSystemResource fr = new FileSystemResource(context.getRealPath("/files/") + file1);
				
				// (첨부될 실제파일의 이름, 첨부파일을 실제로 메세지에 연결할 이름)
				mHelper.addAttachment(file1, fr);
			}
			
			if(file2 != null) {
				FileSystemResource fr1 = new FileSystemResource(context.getRealPath("/files/") + file2);
				
				// (첨부될 실제파일의 이름, 첨부파일을 실제로 메세지에 연결할 이름)
				mHelper.addAttachment(file2, fr1);
			}
			
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
