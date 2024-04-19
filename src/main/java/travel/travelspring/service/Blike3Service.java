package travel.travelspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Blike2;
import travel.travelspring.domain.Blike3;
import travel.travelspring.domain.Board2;
import travel.travelspring.domain.Board3;
import travel.travelspring.repository.Blike3Repository;
import travel.travelspring.repository.Board3Repository;

@Service
public class Blike3Service {
	
	private final Blike3Repository blike3Repository;
	private final Board3Repository board3Repository;

	public Blike3Service(Blike3Repository blike3Repository, Board3Repository board3Repository) {
		this.blike3Repository = blike3Repository;
		this.board3Repository = board3Repository;
	}
	
	// 좋아요 등록
	public void like(Long bno, String username) {
		Blike3 blike = new Blike3();
		blike.setBno3(bno);
		blike.setUsername3(username);
		blike3Repository.save(blike);
		
		// 게시글에 좋아요 수 반영
		Board3 board = board3Repository.findById(bno).get();
		board.setLikeCount3(board.getLikeCount3() + 1);
		board3Repository.save(board);
	}
	
	// 이미 등록된 좋아요 있는지 확인
	public boolean checkLikeByBno(Long bno, String username) {
		return blike3Repository.existsByBno3AndUsername3(bno, username);
	}
	
	// 좋아요 삭제
	public void deleteLike(Long bno, String username) {
		Blike3 like = blike3Repository.findByBno3AndUsername3(bno, username);
		blike3Repository.delete(like);
		
		// 게시글에 좋아요 수 반영
		Board3 board = board3Repository.findById(bno).get();
		board.setLikeCount3(board.getLikeCount3() - 1);
		board3Repository.save(board);
	}
	
	// 자신이 누른 좋아요 전체 조회
	public List<Blike3> getMyLikes(String username){
		return blike3Repository.findAllByUsername3OrderByLikeno3Desc(username);
	}
}
