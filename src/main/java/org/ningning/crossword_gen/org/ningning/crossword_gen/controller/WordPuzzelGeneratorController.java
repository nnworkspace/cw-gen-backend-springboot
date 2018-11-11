package org.ningning.crossword_gen.org.ningning.crossword_gen.controller;


import org.ningning.crossword_gen.CrosswordGenerator;
import org.ningning.crossword_gen.model.Board;
import org.ningning.crossword_gen.model.PuzzleAndSolution;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordPuzzelGeneratorController {

  @RequestMapping("/wordpuzzle")
  public PuzzleAndSolution wordpuzzle(@RequestParam(value = "rows", defaultValue = "8") int rows,
      @RequestParam(value = "cols", defaultValue = "8") int cols,
      @RequestParam(value = "density", defaultValue = "0.75f") float density,
      @RequestParam(value= "shortestWordLength", defaultValue = "5") int shortestWordLength) {

    CrosswordGenerator cwGen = new CrosswordGenerator(new Board(rows, cols));
    cwGen.generate(density, shortestWordLength);
    return cwGen.getPuzzleAndSolution();
  }
}
