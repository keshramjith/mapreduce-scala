package example

import cats.effect.IOApp
import cats.effect.IO
import java.io.File
import cats.effect.ExitCode
import cats.effect.std.Console
import scala.io.Source
import scala.util.Using
import scala.collection.mutable.MultiMap

object MapReduceCatsEffect extends IOApp {
    override def run(args: List[String]): IO[ExitCode] =
        for {
            _ <- IO.println("Starting")
            file = new File(args(1))
            lines <- gatherLines(file)
            wordOccurences = countWordOccurence(lines)
            _ <- IO.println(wordOccurences)
        } yield ExitCode.Success

    def gatherLines(f: File): IO[List[String]] =
        IO.blocking {
            Using(Source.fromFile(f)) {
                source => source
                  .getLines
                  .toList
                  .flatMap(line => line.split(' '))
                  .map(line => line.filterNot(_.isDigit))
                  .map(word => word.replaceAll("\\W", ""))
                  .filterNot(_.isEmpty)
            }.recover {
                case ex =>
                    println(s"Error reading file: ${ex.getMessage}")
                    List.empty[String]
            }.get
        }

    def countWordOccurence(words: List[String]): Map[String, Int] =
        var wordOccurenceMap = Map[String, Int]()
        words.foreach(word => wordOccurenceMap += (word -> 1))
        wordOccurenceMap

}
