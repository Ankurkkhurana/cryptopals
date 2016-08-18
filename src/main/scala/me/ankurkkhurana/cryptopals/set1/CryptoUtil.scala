package me.ankurkkhurana.cryptopals.set1

/**
 * Created by Ankur on 8/18/16.
 */
object CryptoUtil {

  def byteToBooleanArray(byte: Byte): Array[Boolean] = {
    (0 to 7).map(bit => (byte & 1 << bit) > 0).toArray
  }

  // Least significant reside on bit 0 and most significant on bit 7 (or the last index of the arra)
  def bitArrayToByte(bits: Seq[Boolean]) = {
    require(bits.length <= 8, "More than 8 bits are given")
    var result: Byte = 0.toByte
    val OneBitByte: Byte = 1.toByte
    bits.zipWithIndex.foreach(bit => if (bit._1) {
      result = (result | (OneBitByte << bit._2)).toByte
    })
    result
  }

  def hexStringToBytes(str: String) = {
    str.grouped(2).map(p => Integer.parseInt(p, 16).toByte).toArray
  }

  def bytesToHexString(bytes: Seq[Byte]) = {
    bytes.grouped(4).map(bytes => BigInt(bytes.toArray).toInt.toHexString).mkString("")
  }
}
