package travel.travelspring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Board1;
import travel.travelspring.domain.Board2;
import travel.travelspring.domain.Reply1;
import travel.travelspring.domain.Reply2;
import travel.travelspring.repository.Board2Repository;
import travel.travelspring.repository.Reply2Repository;

@Service
public class Reply2Service {
	
	private final Reply2Repository reply2Repository;
	private final Board2Repository board2Repository;

	public Reply2Service(Reply2Repository reply2Repository, Board2Repository board2Repository) {
		this.reply2Repository = reply2Repository;
		this.board2Repository = board2Repository;
	}
	
	// 나의 계획 게시글 하나에 해당되는 모든 댓글 조회
	public List<Reply2> getReplyListByBno(Long bno){
		return reply2Repository.findAllByBno2(bno);
	}
	
	// 나의 계획 게시글 하나의 댓글 조회
	public Reply2 getReplyOne(Long rno) {
		return reply2Repository.findById(rno).get();
	}
	
	// 게시글 하나에 해당되는 댓글 개수
	public Long getReplyCount(Long bno) {
		return reply2Repository.countByBno2(bno);
	}
	
	// 댓글 입력
	public void insertReply(Long bno, String rcontent, String replyer) {
		Reply2 reply = new Reply2();
		reply.setBno2(bno);
		reply.setRcontent2(rcontent);
		reply.setReplyer2(replyer);
		reply.setRdate2(LocalDateTime.now());
		reply2Repository.save(reply);
		
		// 해당 게시글에 댓글 수 반영
		Board2 board = board2Repository.findById(bno).get();
		board.setReply_count2(getReplyCount(bno));
		board2Repository.save(board);
	}
	
	// 댓글 수정
	public void updateReply(Long rno, String rcontent) {
		Reply2 reply = reply2Repository.findById(rno).get();
		reply.setRcontent2(rcontent);
		reply.setRupdate2(LocalDateTime.now());
		reply2Repository.save(reply);
	}
	
	// 댓글 삭제
	public void deleteReply(Long rno, Long bno) {
		reply2Repository.deleteById(rno);
		
		// 해당 게시글에 댓글 수 반영
		Board2 board = board2Repository.findById(bno).get();
		board.setReply_count2(getReplyCount(bno));
		board2Repository.save(board);
	}
}
