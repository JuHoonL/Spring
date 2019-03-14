package com.biz.memo03.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * spring에서 model 객체들은 spring의 확장기능을 사용하지 않는 클래스들이다.
 * (단, lombok을 사용하지 않을 경우)
 * 
 * 기본적으로 자바 자료형의 member 변수를 갖고 getter,setter,생성자,toString메서드를 갖고있다.
 * 그래서 이러한 클래스들을 Plan Old Java Object(POJO)라고 부른다.
 * 
 * model 패키지를 부르는 용어로 string 이전에는 단순히 vo, dto로 불리었고 spring MVC 패턴에서는
 * model(클래스들)이라고 한다.
 * 
 * 프로그래밍 그룹이나 단체, 회사마다 조금씩 다른 용어도 사용하는데 DB관점에서 바라볼 때는 Domain객체(클래스)라고 하고
 * form(입력form)의 관점에서 바라볼 때는 Command객체(클래스)라고도 한다.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemoVO {
	
	private long id;
	private String m_auth;
	private String m_date;
	private String m_subject;
	private String m_text;
	
	private List<FileVO> files;
}
