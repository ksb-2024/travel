package travel.travelspring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import travel.travelspring.controller.UserForm;
import travel.travelspring.domain.User;
import travel.travelspring.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	* 회원 가입
	*/
	public String join(User user) {
		//같은 이름이 있는 중복 회원X
		
		validateDuplicateUser(user); // 중복 회원 검증
		userRepository.save(user);
		return user.getUsername();
	}

	private void validateDuplicateUser(User user) {
		userRepository.findByUsername(user.getUsername())
				.ifPresent(m -> {
						throw new IllegalStateException("이미 존재하는 회원입니다.");
				});
	}
	
	public boolean isDuplicateUser(String username) {
		if(userRepository.findByUsername(username).isPresent()) return true;
		return false;
	}
	
	/**
	 * 전체 회원 조회 
	 */
	public List<User> findUsers(){
			return userRepository.findAll();			
	}
	
	public Optional<User> findOne(String username){
		return userRepository.findByUsername(username);
	}
	
	// 로그인 체크
	public boolean checkPw(String username, String userpw) {
		Optional<User> user = findOne(username);
		if(user.isPresent()) { 
			if(user.get().getUserpw().equals(userpw)) {
				return true;
			}
		}
		return false;
	}
	
	// 회원 탈퇴
	public void deleteUser(String username) {
		User user = findOne(username).get();
		userRepository.delete(user);
	}
	
	// 회원 수정
	public void updateUser(String username,String pw, String tel, String email) {
		User user = findOne(username).get();
		user.setUserpw(pw);
		user.setUsertel(tel);
		user.setUseremail(email);
		user.setModifiedday(LocalDate.now());
	}
	
	// 회원 프로필 사진 등록 및 수정
	public void updateProfileImg(String username, String userimgfile) {
		User user = findOne(username).get();
		user.setUserimgfile(userimgfile);
		user.setModifiedday(LocalDate.now());
	}
	
	// 회원 프로필 소개글 등록 및 수정
	public void updateProfileIntro(String username, String introduction) {
		User user = findOne(username).get();
		user.setIntroduction(introduction);
		user.setModifiedday(LocalDate.now());
	}
	
	// 회원 마이페이지 조회
	public UserForm findUserOnMyPage(String username) {
		UserForm userform = new UserForm();
		User findUser = findOne(username).get();
		userform.setImage(findUser.getUserimgfile());
		userform.setIntroduction(findUser.getIntroduction());
		
		return userform;
	}
	
	
}
