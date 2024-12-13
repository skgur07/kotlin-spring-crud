package com.legend.kotlinspringcrud.board.controller

import com.legend.kotlinspringcrud.board.BoardService
import com.legend.kotlinspringcrud.board.dto.BoardCreateReqDto
import com.legend.kotlinspringcrud.board.dto.BoardUpdateReqDto
import com.legend.kotlinspringcrud.board.entity.Board
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BoardController (
    private val boardService: BoardService
) {

    @PostMapping("/create")
    fun createBoard(@RequestBody boardCreateReqDto: BoardCreateReqDto) : ResponseEntity<Void> {
        boardService.createBoard(boardCreateReqDto)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun getBoard(@PathVariable id: Long) : ResponseEntity<Board>  {
        return ResponseEntity.ok(boardService.getBoard(id))
    }

    @GetMapping("/list")
    fun getAllBoard(): ResponseEntity<List<Board>> {
        return ResponseEntity.ok(boardService.getAllBoard())
    }

    @PutMapping("/{id}")
    fun updateBoard(@PathVariable id: Long, @RequestBody boardUpdateReqDto: BoardUpdateReqDto) : ResponseEntity<Board> {
        boardService.updateBoard(id, boardUpdateReqDto)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: Long) : ResponseEntity<Void>{
        boardService.deleteBoard(id)
        return ResponseEntity.ok().build()
    }

}

