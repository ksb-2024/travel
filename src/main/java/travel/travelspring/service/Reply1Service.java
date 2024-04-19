package travel.travelspring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Board;
import travel.travelspring.domain.Board1;
import travel.travelspring.domain.Reply;
import travel.travelspring.domain.Reply1;
import travel.travelspring.repository.Board1Repository;
import travel.travelspring.repository.Reply1Repository;

@Service
public class Reply1Service {
	
	private final Reply1Repository reply1Repository;
	private final Board1Repository board1Repository;

	public Reply1Service(Reply1Repository reply1Repository, Board1Repository board1Repository) {
		this.reply1Repository = reply1Repository;
		this.board1Repository = board1Repository;
	}
	
	// 동행자찾기 게시글 하나에 해당되는 모든 댓글 조회
	public List<Reply1> getReplyListByBno(Long bno){
		return reply1Repository.findAllByBno1(bno);
	}
	
	// 동행자찾기 게시글 하나의 댓글 조회
	public Reply1 getReplyOne(Long rno) {
		return reply1Repository.findById(rno).get();
	}
	
	// 게시글 하나에 해당되는 댓글 개수
	public Long getReplyCount(Long bno) {
		return reply1Repository.countByBno1(bno);
	}
	
	// 댓글 입력
	public void insertReply(Long bno, String rcontent, String replyer) {
		Reply1 reply = new Reply1();
		reply.setBno1(bno);
		reply.setRcontent1(rcontent);
		reply.setReplyer1(replyer);
		reply.setRdate1(LocalDateTime.now());
		reply1Repository.save(reply);
		
		// 해당 게시글에 댓글 수 반영
		Board1 board = board1Repository.findById(bno).get();
		board.setReply_count1(getReplyCount(bno));
		board1Repository.save(board);
	}
	
	// 댓글 수정
	public void updateReply(Long rno, String rcontent) {
		Reply1 reply = reply1Repository.findById(rno).get();
		reply.setRcontent1(rcontent);
		reply.setRupdate1(LocalDateTime.now());
		reply1Repository.save(reply);
	}
	
	// 댓글 삭제
	public void deleteReply(Long rno, Long bno) {
		reply1Repository.deleteById(rno);
		
		// 해당 게시글에 댓글 수 반영
		Board1 board = board1Repository.findById(bno).get();
		board.setReply_count1(getReplyCount(bno));
		board1Repository.save(board);
	}
}
