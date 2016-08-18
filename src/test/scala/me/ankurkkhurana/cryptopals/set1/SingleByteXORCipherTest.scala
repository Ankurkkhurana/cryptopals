package me.ankurkkhurana.cryptopals.set1

import org.scalatest.{Matchers, WordSpec}

import scala.io.Source

/**
 * Created by Ankur on 8/16/16.
 * http://cryptopals.com/sets/1/challenges/1
 */
class SingleByteXORCipherTest extends WordSpec with Matchers {

  import me.ankurkkhurana.cryptopals.set1.CryptoUtil._

  "SingleByteXORCipher" should {
    "Print all the solution" in {
      val input = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"
      val expectedOutput = "Cooking MC's like a pound of bacon"
      SingleByteXORCipher.getPossibleMessageWithScore(hexStringToBytes(input)).decodedString should be(expectedOutput)
    }
  }

  "find single encrypted line" in {

    val lines = Source.fromFile("/Users/ankur/Development/Cryptopals/src/test/resources/singlebyteXORCipherTestInput.txt").getLines()
    val expectedOutput = "Now that the party is jumping"
    val decodedString = lines.
      map(input => SingleByteXORCipher.getPossibleMessageWithScore(CryptoUtil.hexStringToBytes(input))).
      toList.
      zipWithIndex.sortBy(-1 * _._1.score)
    println(decodedString.head._1.decodedString)
    decodedString.head._1.decodedString.trim should be(expectedOutput)
  }
}
