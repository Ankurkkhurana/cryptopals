package me.ankurkkhurana.cryptopals.set1

/**
 * Created by Ankur on 8/16/16.
 */
object Base64 {
  val map = {
    (0 to 25).map(p => (p, ('A' + p).toChar)).toMap ++
      (26 to 51).map(p => (p, ('a' + p - 26).toChar)).toMap ++
      (52 to 61).map(p => (p, ('0' + p - 52).toChar)).toMap ++
      List(62 -> '+', 63 -> '/').toMap
  }

  def convertToBase64(bytes: Seq[Byte]) = {
    (0 to 63).foreach(p => println(s"$p ${map(p)}"))

    bytes.
      flatMap(p => CryptoUtil.byteToBooleanArray(p)).
      grouped(6).
      map(p => {
      println(s"$p ${CryptoUtil.bitArrayToByte(p)} ${map(CryptoUtil.bitArrayToByte(p).toInt)}")
      map(CryptoUtil.bitArrayToByte(p).toInt)
    }).
      mkString("")
  }
}
