package example

import java.io.File
import scala.io.Source

object MapReduce {
    def main(args: Array[String]): Unit =
        var file = new File(args.head)
        var it = Source.fromFile(file).getLines
        while it.hasNext do
            println(it.next)
}