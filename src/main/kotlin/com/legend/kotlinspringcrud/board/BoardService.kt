package com.legend.kotlinspringcrud.board

import com.legend.kotlinspringcrud.board.dto.BoardCreateReqDto
import com.legend.kotlinspringcrud.board.dto.BoardUpdateReqDto
import com.legend.kotlinspringcrud.board.entity.Board
import com.legend.kotlinspringcrud.board.repository.BoardRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestBody

@Service
class BoardService (
    private val boardRepository: BoardRepository,
){
    @Transactional
    fun createBoard(@RequestBody boardCreateReqDto: BoardCreateReqDto) {
        val board = Board(
            title = boardCreateReqDto.title,
            content = boardCreateReqDto.content
        )
        boardRepository.save(board)
    }

    @Transactional(readOnly = true)
    fun getBoard(id: Long) = boardRepository.findByIdOrNull(id)
        ?: throw ChangeSetPersister.NotFoundException()

    @Transactional(readOnly = true)
    fun getAllBoard(): MutableList<Board> = boardRepository.findAll()

    @Transactional
    fun updateBoard(id: Long, boardUpdateReqDto: BoardUpdateReqDto) {
        val board = boardRepository.findById(id)
            ?: throw ChangeSetPersister.NotFoundException()
    }

    @Transactional
    fun deleteBoard(id: Long) = boardRepository.deleteById(id)
        ?: throw ChangeSetPersister.NotFoundException()
}