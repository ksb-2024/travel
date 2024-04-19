package travel.travelspring.service;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Blike;
import travel.travelspring.domain.Board;
import travel.travelspring.domain.Nlike;
import travel.travelspring.domain.Notice;
import travel.travelspring.repository.NlikeRepository;
import travel.travelspring.repository.NoticeRepository;

@Service
public class NlikeService {
	
	private final NlikeRepository nlikeRepository;
	private final NoticeRepository noticeRepository;

	public NlikeService(NlikeRepository nlikeRepository, NoticeRepository noticeRepository) {
		this.nlikeRepository = nlikeRepository;
		this.noticeRepository = noticeRepository;
	}
	
	// 좋아요 등록
	public void like(Long nno, String nusername) {
		Nlike nlike = new Nlike();
		nlike.setNno(nno);
		nlike.setNusername(nusername);
		nlikeRepository.save(nlike);
		
		// 게시글에 좋아요 수 반영
		Notice notice = noticeRepository.findById(nno).get();
		notice.setNlikeCount(notice.getNlikeCount() + 1);
		noticeRepository.save(notice);
	}
	
	// 이미 등록된 좋아요 있는지 확인
	public boolean checkLikeByNno(Long nno, String nusername) {
		return nlikeRepository.existsByNnoAndNusername(nno, nusername);
	}
	
	// 좋아요 삭제
	public void deleteLike(Long nno, String nusername) {
		Nlike like = nlikeRepository.findByNnoAndNusername(nno, nusername);
		nlikeRepository.delete(like);
		
		// 게시글에 좋아요 수 반영
		Notice notice = noticeRepository.findById(nno).get();
		notice.setNlikeCount(notice.getNlikeCount() - 1);
		noticeRepository.save(notice);
	}
}
