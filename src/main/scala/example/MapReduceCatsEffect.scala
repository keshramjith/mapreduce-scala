package example

import cats.effect.IOApp
import cats.effect.IO
import java.io.File
import cats.effect.ExitCode
import cats.effect.std.Console
import scala.io.Source
import scala.util.Using

object MapReduceCatsEffect extends IOApp {
    override def run(args: List[String]): IO[ExitCode] =
        for {
            _ <- IO.println("Starting")
            file = new File(args(1))
            lines <- gatherLines(file)
            _ <- IO.println(lines)
        } yield ExitCode.Success

    def gatherLines(f: File): IO[List[String]] =
        IO.blocking {
            Using(Source.fromFile(f)) {
                source => source.getLines().toList
            }.recover {
                case ex =>
                    println(s"Error reading file: ${ex.getMessage}")
                    List.empty[String]
            }.get
        }
}
