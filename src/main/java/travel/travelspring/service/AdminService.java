package travel.travelspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Admin;
import travel.travelspring.repository.AdminRepository;

@Service
public class AdminService {
	
	private final AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	// 전체 조회
	public List<Admin> findAdmins(){
		return adminRepository.findAll();			
	}
	
	// 단건 조회
	public Optional<Admin> findOne(String nusername){
		return adminRepository.findByNusername(nusername);
	}
	
	// 관리자 체크
	public boolean checkAdmin(String nusername) {
		return adminRepository.existsByNusername(nusername);
	}

	// 로그인 체크
	public boolean checkAdminPw(String nusername, String nuserpw) {
		Optional<Admin> admin = findOne(nusername);
		if(admin.isPresent()) { 
			if(admin.get().getNuserpw().equals(nuserpw)) {
				return true;
			}
		}
		return false;
	}
}
