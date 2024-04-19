package travel.travelspring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Board;
import travel.travelspring.domain.NReply;
import travel.travelspring.domain.Notice;
import travel.travelspring.domain.Reply;
import travel.travelspring.repository.NReplyRepository;
import travel.travelspring.repository.NoticeRepository;

@Service
public class NReplyService {
	
	private final NReplyRepository nreplyRepository;
	private final NoticeRepository noticeRepository;

	public NReplyService(NReplyRepository nreplyRepository, NoticeRepository noticeRepository) {
		this.nreplyRepository = nreplyRepository;
		this.noticeRepository = noticeRepository;
	}
	
	// 공지 사항 게시글 하나에 해당되는 모든 댓글 조회
	public List<NReply> getNReplyListByNno(Long nno){
		return nreplyRepository.findAllByNno(nno);
	}
	
	// 공지 사항 게시글 하나의 댓글 조회
	public NReply getNReplyOne(Long nrno) {
		return nreplyRepository.findById(nrno).get();
	}
	
	// 게시글 하나에 해당되는 댓글 개수
	public Long getNReplyCount(Long nno) {
		return nreplyRepository.countByNno(nno);
	}
	
	// 댓글 입력
	public void insertNReply(Long nno, String nrcontent, String nreplyer) {
		NReply nreply = new NReply();
		nreply.setNno(nno);
		nreply.setNrcontent(nrcontent);
		nreply.setNreplyer(nreplyer);
		nreply.setNrdate(LocalDateTime.now());
		nreplyRepository.save(nreply);
		
		// 해당 게시글에 댓글 수 반영
		Notice notice = noticeRepository.findById(nno).get();
		notice.setNreply_count(getNReplyCount(nno));
		noticeRepository.save(notice);
	}
	
	// 댓글 수정
	public void updateNReply(Long nrno, String nrcontent) {
		NReply nreply = nreplyRepository.findById(nrno).get();
		nreply.setNrcontent(nrcontent);
		nreply.setNrupdate(LocalDateTime.now());
		nreplyRepository.save(nreply);
	}
	
	// 댓글 삭제
	public void deleteNReply(Long nrno, Long nno) {
		nreplyRepository.deleteById(nrno);
		
		// 해당 게시글에 댓글 수 반영
		Notice notice = noticeRepository.findById(nno).get();
		notice.setNreply_count(getNReplyCount(nno));
		noticeRepository.save(notice);
	}
}
