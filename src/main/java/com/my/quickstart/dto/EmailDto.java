package com.my.quickstart.dto;

import java.io.Serializable;
import java.util.Date;
/**
 * 用作邮件发送的对象
 * @author Alan
 *
 */
public class EmailDto implements Serializable {
	private static final long serialVersionUID = -8012238619143228141L;

	private String from;

	private String replyTo;

	private String[] tos;
	private String   to;

	private String[] cc;

	private String[] bcc;

	private Date sentDate;

	private String subject;

	private String text;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String[] getTos() {
		return tos;
	}

	public void setTos(String[] tos) {
		this.tos = tos;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
