package travel.travelspring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Board3;
import travel.travelspring.domain.Reply3;
import travel.travelspring.repository.Board3Repository;
import travel.travelspring.repository.Reply3Repository;

@Service
public class Reply3Service {
	
	private final Reply3Repository reply3Repository;
	private final Board3Repository board3Repository;

	public Reply3Service(Reply3Repository reply3Repository, Board3Repository board3Repository) {
		this.reply3Repository = reply3Repository;
		this.board3Repository = board3Repository;
	}
	
	// Q&A 게시글 하나에 해당되는 모든 댓글 조회
	public List<Reply3> getReplyListByBno(Long bno){
		return reply3Repository.findAllByBno3(bno);
	}
	
	// Q&A 게시글 하나의 댓글 조회
	public Reply3 getReplyOne(Long rno) {
		return reply3Repository.findById(rno).get();
	}
	
	// 게시글 하나에 해당되는 댓글 개수
	public Long getReplyCount(Long bno) {
		return reply3Repository.countByBno3(bno);
	}
	
	// 댓글 입력
	public void insertReply(Long bno, String rcontent, String replyer) {
		Reply3 reply = new Reply3();
		reply.setBno3(bno);
		reply.setRcontent3(rcontent);
		reply.setReplyer3(replyer);
		reply.setRdate3(LocalDateTime.now());
		reply3Repository.save(reply);
		
		// 해당 게시글에 댓글 수 반영
		Board3 board = board3Repository.findById(bno).get();
		board.setReply_count3(getReplyCount(bno));
		board3Repository.save(board);
	}
	
	// 댓글 수정
	public void updateReply(Long rno, String rcontent) {
		Reply3 reply = reply3Repository.findById(rno).get();
		reply.setRcontent3(rcontent);
		reply.setRupdate3(LocalDateTime.now());
		reply3Repository.save(reply);
	}
	
	// 댓글 삭제
	public void deleteReply(Long rno, Long bno) {
		reply3Repository.deleteById(rno);
		
		// 해당 게시글에 댓글 수 반영
		Board3 board = board3Repository.findById(bno).get();
		board.setReply_count3(getReplyCount(bno));
		board3Repository.save(board);
	}
}
