package travel.travelspring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import travel.travelspring.domain.Board;
import travel.travelspring.domain.Notice;
import travel.travelspring.repository.BoardSpecification;
import travel.travelspring.repository.NoticeRepository;

@Service
public class NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	public NoticeService(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}

	// 공지사항 게시글 목록 조회
	public Page<Notice> getNotices(int page, int size){
		
		Sort sort = Sort.by(Sort.Direction.DESC, "nno");
		
		return noticeRepository.findAll(PageRequest.of(page, size, sort));
	}
	
	
	// 공지사항 게시글 작성 처리
	public void writeNotice(String nusername, String ntitle, String ncontent, String nfilename) {
		Notice notice = new Notice();
		notice.setNtitle(ntitle);
		notice.setNcontent(ncontent);
		notice.setNcreateDate(LocalDate.now());
		notice.setNfilename(nfilename);
		notice.setNhit(0L);
		notice.setNusername(nusername);
		notice.setNreply_count(0L);
		notice.setNlikeCount(0L);
		
		noticeRepository.save(notice);
	}
	
	// 공지사항 게시글 상세 조회
	public Optional<Notice> getNoticeOne(Long nno) {
		return noticeRepository.findById(nno);
	}
	
	// 공지사항 게시글 조회수 증가
	public void increaseNoticeHit(Long nno) {
		Notice notice = getNoticeOne(nno).get();
		notice.setNhit(notice.getNhit() + 1);
		noticeRepository.save(notice);
	}
	
	// 공지사항 게시글 삭제
	public void deleteNotice(Long nno) {
		noticeRepository.deleteById(nno);
	}
	
	// 공지사항 게시글 수정
	public void updateNotice(Long nno, String ntitle, String ncontent, String nfilename) {
		Notice notice = getNoticeOne(nno).get();
		notice.setNtitle(ntitle);
		notice.setNcontent(ncontent);
		notice.setNfilename(nfilename);
		notice.setNmodifyDate(LocalDate.now());
		
		noticeRepository.save(notice);
	}
	
	// 공지사항 게시글 검색
	public Page<Notice> searchNoticeList(int page, int size, String field,String kw){
		Specification<Notice> spec = Specification.where(BoardSpecification.likeFieldN(field, kw));
		Sort sort = Sort.by(Sort.Direction.DESC, "nno");
		Pageable pageable = PageRequest.of(page, size, sort);
		return noticeRepository.findAll(spec, pageable);
	}
	
	// 공지사항 게시글 인기글 조회
	public List<Notice> getNoticeLikeList(){
		return noticeRepository.findAllByOrderByNlikeCountDesc();
	}
}
