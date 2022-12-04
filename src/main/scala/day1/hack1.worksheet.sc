
import scala.io.Source

val filePath = "./src/main/scala/day1/AOC_input_1.txt"

val lines = Source.fromFile(filePath).getLines().toList

def splitIntoElves(input: List[String]): List[List[Int]] =
    if (input.isEmpty) Nil
    else input.takeWhile(_.toIntOption.isDefined).map(_.toInt) :: splitIntoElves(input.dropWhile(_.toIntOption.isDefined).drop(1))

splitIntoElves(lines).foldLeft(0)((best, elf) => math.max(elf.sum,best) )