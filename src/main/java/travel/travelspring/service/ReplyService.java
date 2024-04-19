package travel.travelspring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Board;
import travel.travelspring.domain.Reply;
import travel.travelspring.repository.BoardRepository;
import travel.travelspring.repository.ReplyRepository;

@Service
public class ReplyService {
	
	private final ReplyRepository replyRepository;
	private final BoardRepository boardRepository;

	public ReplyService(ReplyRepository replyRepository, BoardRepository boardRepository) {
		this.replyRepository = replyRepository;
		this.boardRepository = boardRepository;
	}
	
	// 여행 후기 게시글 하나에 해당되는 모든 댓글 조회
	public List<Reply> getReplyListByBno(Long bno){
		return replyRepository.findAllByBno(bno);
	}
	
	// 여행 후기 게시글 하나의 댓글 조회
	public Reply getReplyOne(Long rno) {
		return replyRepository.findById(rno).get();
	}
	
	// 게시글 하나에 해당되는 댓글 개수
	public Long getReplyCount(Long bno) {
		return replyRepository.countByBno(bno);
	}
	
	// 댓글 입력
	public void insertReply(Long bno, String rcontent, String replyer) {
		Reply reply = new Reply();
		reply.setBno(bno);
		reply.setRcontent(rcontent);
		reply.setReplyer(replyer);
		reply.setRdate(LocalDateTime.now());
		replyRepository.save(reply);
		
		// 해당 게시글에 댓글 수 반영
		Board board = boardRepository.findById(bno).get();
		board.setReply_count(getReplyCount(bno));
		boardRepository.save(board);
	}
	
	// 댓글 수정
	public void updateReply(Long rno, String rcontent) {
		Reply reply = replyRepository.findById(rno).get();
		reply.setRcontent(rcontent);
		reply.setRupdate(LocalDateTime.now());
		replyRepository.save(reply);
	}
	
	// 댓글 삭제
	public void deleteReply(Long rno, Long bno) {
		replyRepository.deleteById(rno);
		
		// 해당 게시글에 댓글 수 반영
		Board board = boardRepository.findById(bno).get();
		board.setReply_count(getReplyCount(bno));
		boardRepository.save(board);
	}
}
