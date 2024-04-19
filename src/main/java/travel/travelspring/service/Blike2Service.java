package travel.travelspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Blike1;
import travel.travelspring.domain.Blike2;
import travel.travelspring.domain.Board2;
import travel.travelspring.repository.Blike2Repository;
import travel.travelspring.repository.Board2Repository;

@Service
public class Blike2Service {
	
	private final Blike2Repository blike2Repository;
	private final Board2Repository board2Repository;

	public Blike2Service(Blike2Repository blike2Repository, Board2Repository board2Repository) {
		this.blike2Repository = blike2Repository;
		this.board2Repository = board2Repository;
	}
	
	// 좋아요 등록
	public void like(Long bno, String username) {
		Blike2 blike = new Blike2();
		blike.setBno2(bno);
		blike.setUsername2(username);
		blike2Repository.save(blike);
		
		// 게시글에 좋아요 수 반영
		Board2 board = board2Repository.findById(bno).get();
		board.setLikeCount2(board.getLikeCount2() + 1);
		board2Repository.save(board);
	}
	
	// 이미 등록된 좋아요 있는지 확인
	public boolean checkLikeByBno(Long bno, String username) {
		return blike2Repository.existsByBno2AndUsername2(bno, username);
	}
	
	// 좋아요 삭제
	public void deleteLike(Long bno, String username) {
		Blike2 like = blike2Repository.findByBno2AndUsername2(bno, username);
		blike2Repository.delete(like);
		
		// 게시글에 좋아요 수 반영
		Board2 board = board2Repository.findById(bno).get();
		board.setLikeCount2(board.getLikeCount2() - 1);
		board2Repository.save(board);
	}
	
	// 자신이 누른 좋아요 전체 조회
	public List<Blike2> getMyLikes(String username){
		return blike2Repository.findAllByUsername2OrderByLikeno2Desc(username);
	}
}
