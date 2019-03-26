package com.biz.file.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ScriptAssert(lang="javascript", message="비밀번호와 비밀번호확인이 일치하지 않습니다.", reportOn="m_re_password", script="(_this.m_password==_this.m_re_password)")
public class MemberVO {
	/*
	 	constraints(제약조건)
	 	
	 	@null : null인 경우만 정상
	 	@NotNull : null이 아닌 경우만 정상
	 	@NotBlank : 문자열의 경우 공백이 아닐경우만 정상
	 	
	 	@Size(min=x, max=y) : 최소x부터 최대y까지의 갯수만 정상
	 	@Max(x) : max값 제한(x값 이하일 경우만 정상)
	 	@Min(x): min값 제한(x값 이상일 경우만 정상)
	 	
	 	@AssetTrue: boolean형일경우 조건이 참인가 ?
	 	@Assetfalse: boolean형일경우 조건이 거짓인가 ?
	 	
	 	@DecimalMax(x) : x값 이하의 실수만 정상
	 	@DecimalMin(x) : x값 이상의 실수만 정상
	 	@Digits(integer=x) : x 자릿수 이하의 정수만 정상
	 	@digits(integer=x, fraction=y) : x자릿수의 정수와 y자릿수의 소수 이하의 숫자만 정상
	 */
	
	
	//constraints(제약조건) 설정 : id를 3~15개까지만 입력가능
	@Size(min=3, max=30,message="UserID는 3~15글자만 입력하세요")
//	@Pattern(regexp= "\\s{''}",message="UserID는 공백이 올수없습니다") 오류
	@NotBlank(message="UserID는 공백이 올수없습니다")
	@Email(message="ID는 Email형식 이어야 합니다.")
	private String m_userid;
	
	//constraints(제약조건) 설정 : null값 X
	@NotBlank(message="비밀번호를 입력하세요")
	private String m_password;
	
	private String m_re_password;
	
	@Size(min=2, max=5,message="이름은 2~5글자만 입력하세요")
	@NotBlank(message="이름을 입력하세요")
	private String m_name;
	
	private String m_addr;
	
	@Pattern(regexp= "\\d{1,15}",message="전화번호는 숫자 1~15자리까지만 가능합니다")
	private String m_tel;
}
