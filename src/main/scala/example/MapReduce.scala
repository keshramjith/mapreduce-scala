package example

import cats.effect.IOApp
import cats.effect.ExitCode
import cats.effect.IO

object MapReduce extends IOApp {
    override def run(args: List[String]): IO[ExitCode] =
        for {
            _ <- IO.println("Hello from cats-effects 3.6.1")
        } yield ExitCode.Success
}