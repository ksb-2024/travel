package travel.travelspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Blike;
import travel.travelspring.domain.Blike1;
import travel.travelspring.domain.Board1;
import travel.travelspring.repository.Blike1Repository;
import travel.travelspring.repository.Board1Repository;

@Service
public class Blike1Service {
	
	private final Blike1Repository blike1Repository;
	private final Board1Repository board1Repository;

	public Blike1Service(Blike1Repository blike1Repository, Board1Repository board1Repository) {
		this.blike1Repository = blike1Repository;
		this.board1Repository = board1Repository;
	}
	
	// 좋아요 등록
	public void like(Long bno, String username) {
		Blike1 blike = new Blike1();
		blike.setBno1(bno);
		blike.setUsername1(username);
		blike1Repository.save(blike);
		
		// 게시글에 좋아요 수 반영
		Board1 board = board1Repository.findById(bno).get();
		board.setLikeCount1(board.getLikeCount1() + 1);
		board1Repository.save(board);
	}
	
	// 이미 등록된 좋아요 있는지 확인
	public boolean checkLikeByBno(Long bno, String username) {
		return blike1Repository.existsByBno1AndUsername1(bno, username);
	}
	
	// 좋아요 삭제
	public void deleteLike(Long bno, String username) {
		Blike1 like = blike1Repository.findByBno1AndUsername1(bno, username);
		blike1Repository.delete(like);
		
		// 게시글에 좋아요 수 반영
		Board1 board = board1Repository.findById(bno).get();
		board.setLikeCount1(board.getLikeCount1() - 1);
		board1Repository.save(board);
	}
	
	// 자신이 누른 좋아요 전체 조회
	public List<Blike1> getMyLikes(String username){
		return blike1Repository.findAllByUsername1OrderByLikeno1Desc(username);
	}
}
