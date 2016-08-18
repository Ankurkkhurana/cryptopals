package me.ankurkkhurana.cryptopals.set1

/**
 * Created by Ankur on 8/18/16.
 * Decode using all the possible byte values and assign score
 * based on which string have maximum digits or letter.
 */
object SingleByteXORCipher {
  def getPossibleMessageWithScore(bytes: Seq[Byte]): DecodedStringWithScore = {
    val scoredList = (0 to 255).map(
      character => bytes.map(p => (character ^ p).toChar)).
      map(decodedArray => DecodedStringWithScore(decodedArray.mkString(""), decodedArray.count(p => p.isLetterOrDigit || p.isWhitespace)))
      .sortBy(-1 * _.score)
    scoredList.head
  }
}

case class DecodedStringWithScore(decodedString: String, score: Int)