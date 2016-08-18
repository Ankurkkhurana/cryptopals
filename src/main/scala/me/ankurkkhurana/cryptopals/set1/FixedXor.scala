package me.ankurkkhurana.cryptopals.set1

/**
 * Created by Ankur on 8/18/16.
 * http://cryptopals.com/sets/1/challenges/2
 */
object FixedXor {
  def xor(input1: Seq[Byte], input2: Seq[Byte]): Seq[Byte] = {
    require(input1.length == input2.length, "trying to do xor on unequal length.")
    input1.zip(input2).map(input => (input._1 ^ input._2).toByte)
  }
}
