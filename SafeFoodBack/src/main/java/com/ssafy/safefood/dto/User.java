package com.ssafy.safefood.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	/**사용자 아이디 */
	private String id;
	/**사용자 비밀번호 */
	private String password;
	/**사용자 이름 */
	private String name;
	/**사용자 주소 */
	private String address;
	/**사용자 전화번호 */
	private String phone;
	/**사용자 알러지 정보 */
	private List<Allergy> allergyList;
	
	private List<Food> foodList;
}
